package hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

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
import hoteleveris.app.request.SituacaoQuartoRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ListQuartoResponse;
import hoteleveris.app.response.QuartoResponse;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository _repository;
	
	@Autowired
	private QuartoComodidadeRepository quartoComodidadeRepository;

	public BaseResponse criar(QuartoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;

		if (request.getAndar() <= 0) {
			response.message = "Andar não pode ser vazio ou zero";
			return response;
		} else if (request.getnQuarto() <= 0) {
			response.message = "Numero do quarto não pode ser vazio ou zero";
			return response;
		} else if (request.getSituacao().isEmpty()) {
			response.message = "Situação não pode ser vazia";
			return response;
		}
		
		TipoQuarto tipoQuarto = new TipoQuarto(request.getTipoQuartoId());
		
		Quarto quarto = new Quarto();
		quarto.setAndar(request.getAndar());
        quarto.setnQuarto(request.getnQuarto());
        quarto.setSituacao(request.getSituacao());


        TipoQuarto tq = new TipoQuarto();
        tq.setId(request.getTipoQuartoId());
        quarto.setTipoQuarto(tipoQuarto);
		
		_repository.save(quarto);
		
		Long idQuarto = _repository.findBynQuarto(request.getnQuarto()).get().getId();

		for (ComodidadeRequest objeto : request.getComodidade()) {
			
			QuartoComodidade quartoComodidade = new QuartoComodidade(
					new Quarto(idQuarto), 
					new Comodidade(objeto.getId())
					);
			
			quartoComodidadeRepository.save(quartoComodidade);
		}
		
		response.message = "Quarto criado com sucesso!";
		response.statusCode = 201;
		return response;
	}
	
	public QuartoResponse obter(Long id) {
		Optional<Quarto> quarto = _repository.findById(id);

		QuartoResponse response = new QuartoResponse();

		if (quarto.isEmpty()) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}

		response.setId(quarto.get().getId());
		response.setAndar(quarto.get().getAndar());
		response.setnQuarto(quarto.get().getnQuarto());
		response.setSituacao(quarto.get().getSituacao());
		response.setIdTipoQuarto(quarto.get().getTipoQuarto().getId());

		response.statusCode = 200;
		response.message = "Tipo de quarto obtido com sucesso.";
		return response;
		
	}
	
	public ListQuartoResponse listar(Long id) {

		ListQuartoResponse response = new ListQuartoResponse();
		List<Quarto> lista = _repository.findBuscarQuartos(id);

		response.setQuartos(lista);
		response.statusCode = 200;
		response.message = "Quartos obtidos com sucesso.";

		return response;
		
	}
	
	public BaseResponse atualizar(Long id, SituacaoQuartoRequest request) {
		BaseResponse response = new BaseResponse();

		Optional<Quarto> quarto = _repository.findById(id);
 
		if (request.getSituacao().isEmpty()) {
			response.statusCode = 400;
			response.message = "Situação do quarto não pode ser vazia";
			return response;
		} else if (quarto.isEmpty() || id <= 0) {
			response.statusCode = 400;
			response.message = "Id do quarto não pode ser zero ou vazio";
			return response;
		}

		quarto.get().setSituacao(request.getSituacao());

		_repository.save(quarto.get());

		response.message = "Situação do quarto atualizado com sucesso";
		response.statusCode = 200;

		return response;

	}

}