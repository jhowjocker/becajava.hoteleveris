package hoteleveris.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleveris.app.model.TipoQuarto;
import hoteleveris.app.repository.TipoQuartoRepository;
import hoteleveris.app.request.TipoQuartoRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ListTipoQuartoResponse;
import hoteleveris.app.response.TipoQuartoResponse;

@Service
public class TipoQuartoService {
	
	@Autowired
	TipoQuartoRepository repository;
	
	public BaseResponse criar(TipoQuartoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if(request.getDescricao().isEmpty()){
			response.message = "A descrição não pode ser vazia";
			return response;
		}else if(request.getValor() <= 0) {
			response.message = "O valor não pode ser vazio ou zero";
			return response;
		}
	
		TipoQuarto tq = new TipoQuarto(
				request.getDescricao(),
				request.getValor());
		
		repository.save(tq);
		
		response.message = "Tipo de quarto inserido com sucesso!";
		response.statusCode = 200;
		
		return response;
	}
	
	public TipoQuartoResponse obter(Long id) {
		Optional<TipoQuarto> tq = repository.findById(id);
		
		TipoQuartoResponse response = new TipoQuartoResponse();
		
		if(tq.get().getId() == 0) {
			response.statusCode = 400;
			response.message = "Id não encontrado.";
			return response;
		}
		
		response.setId(tq.get().getId());
		response.setDescricao(tq.get().getDescricao());
		response.setValor(tq.get().getValor());
		response.statusCode = 200;
		response.message = "Tipo de quarto obtido com sucesso";
		return response;
		
	}
	
	public ListTipoQuartoResponse listar() {
		
		List<TipoQuarto> lista = repository.findAll();
		
		ListTipoQuartoResponse response = new ListTipoQuartoResponse();
		response.setTipoQuarto(lista);
		response.statusCode = 200;
		response.message = "Clientes obtidos com sucesso";
		
		return response;
	}

}













