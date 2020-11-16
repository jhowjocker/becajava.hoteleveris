package hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleveris.app.model.Comodidade;
import hoteleveris.app.repository.ComodidadeRepository;
import hoteleveris.app.request.ClienteRequest;
import hoteleveris.app.request.ComodidadeRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ComodidadeResponse;

@Service
public class ComodidadeService {
	
	@Autowired
	private ComodidadeRepository repository;
	
	public BaseResponse criar(ComodidadeRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if (request.getNome() == "" || request.getNome() == null) {
			return new BaseResponse(400, "Preencha o nome da comodidade");
		}
		
		Comodidade comodidade = new Comodidade(
				request.getId(),
				request.getNome());
		
		repository.save(comodidade);
		
		response.message = "Comodidade criada com sucesso.";
		response.statusCode = 200;
		
		return response;
	}
	
	
	public ComodidadeResponse obter(Long id) {
		Optional<Comodidade> comodidade = repository.findById(id);
		
		ComodidadeResponse response = new ComodidadeResponse();
		
		if(comodidade.get().getId() == 0) {
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







