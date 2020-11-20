package hoteleveris.app.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleveris.app.model.Comodidade;
import hoteleveris.app.repository.ComodidadeRepository;
import hoteleveris.app.request.ComodidadeIdRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ComodidadeResponse;
import hoteleveris.app.service.ComodidadeService;

@Service
public class ComodidadeServiceImp implements ComodidadeService{
	
	@Autowired
	private ComodidadeRepository repository;
	
	public BaseResponse criar(ComodidadeIdRequest request) {
		BaseResponse response = new BaseResponse();
		
		Comodidade comodidade = new Comodidade(request.getNome());
		response.statusCode = 400;
		
		if(request.getNome().isEmpty()) {
			response.message = "Favor insira uma comodidade!";
			response.statusCode = 400;
			return response;
		}
		
				
		repository.save(comodidade);
		
		response.message = "Comodidade criada com sucesso.";
		response.statusCode = 201;
		
		return response;
	}
	
	
	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = repository.findById(id);
		
		ComodidadeResponse response = new ComodidadeResponse();
		
		if(comodidade.isEmpty()) {
			response.statusCode = 400;
			response.message = "Id não encontrado";
			return response;
		}
		
		response.setId(comodidade.get().getId());
		response.setNome(comodidade.get().getNome());
		
		response.statusCode = 200;
		response.message = "Tipo de Quarto obtido com sucesso";
		return response;
	}
	

}







