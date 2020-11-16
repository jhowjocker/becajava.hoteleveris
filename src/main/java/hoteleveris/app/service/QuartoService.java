package hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleveris.app.model.Comodidade;
import hoteleveris.app.model.Quarto;
import hoteleveris.app.model.QuartoComodidade;
import hoteleveris.app.model.TipoQuarto;
import hoteleveris.app.repository.QuartoComodidadeRepository;
import hoteleveris.app.repository.QuartoRepository;
import hoteleveris.app.request.ComodidadeRequest;
import hoteleveris.app.request.QuartoRequest;
import hoteleveris.app.response.BaseResponse;

@Service
public class QuartoService {
	
		@Autowired
		private QuartoRepository repository;
		
		@Autowired
		private QuartoComodidadeRepository quartoComodidadeRepository;
		
		public BaseResponse inserir(QuartoRequest request) {
			if(request.getAndar() <= 0)
				return new BaseResponse(400, "Insira o andar");
			
			if(request.getnQuarto() <= 0)
				return new BaseResponse(400, "Insira o numero do quarto");
			
			var checknQuarto = repository.findBynQuarto(request.getnQuarto());
			
			if(!checknQuarto.isEmpty())
				return new BaseResponse(400, "O número do quarto já existe");
			
			if(request.getSituacao() =="" || request.getSituacao() == null)
				return new BaseResponse(400, "Insira a situação");
			
			
			TipoQuarto tipoQuarto = new TipoQuarto(request.getTipoQuartoId());
			
			Quarto quarto = new Quarto(
						request.getnQuarto(),
						request.getAndar(),
						request.getSituacao(),
						tipoQuarto
					
					);
						repository.save(quarto);	
			
			Long idQuarto = repository.findBynQuarto(request.getnQuarto()).get().getId();
			
			if(request.getComodidade() != null && request.getComodidade().size() >0) {
				for(ComodidadeRequest item : request.getComodidade()) {
					QuartoComodidade quartoComodidade = new QuartoComodidade(
							new Quarto(idQuarto),
							new Comodidade(item.getId())
							);
					
					quartoComodidadeRepository.save(quartoComodidade);
							
				}
			}
			
			return new BaseResponse(201, "Quarto inserido com sucesso");
		}
		
}






