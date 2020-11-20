package hoteleveris.app.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleveris.app.model.Cliente;
import hoteleveris.app.repository.ClienteRepository;
import hoteleveris.app.request.ClienteRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ClienteResponse;
import hoteleveris.app.service.ClienteService;

@Service
public class ClienteServiceImp implements ClienteService {

	@Autowired
		private ClienteRepository repository;

	
		public BaseResponse inserir(ClienteRequest request) {
			Cliente cliente = new Cliente();
						
			if (request.getNome() == "" || request.getNome() == null) 
				return new BaseResponse(400, "Cliente não informado!");

			if (request.getCpf() == "" || request.getCpf() == null) 
				return new BaseResponse(400, "CPF não informado!");
			
					
			if (request.getHash() == "" || request.getHash() == null) 
				return new BaseResponse(400, "Hash não informado!");
			
			cliente.setNome(request.getNome());
			cliente.setCpf(request.getCpf());
			cliente.setHash(request.getHash());
			
			repository.save(cliente);
			return new BaseResponse(201, "Cliente inserido com sucesso!");
			
			}

	
	public ClienteResponse obter(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		
		ClienteResponse response = new ClienteResponse();
		
		if(cliente.get().getId() == 0) {
			response.statusCode = 400;
			response.message = "Id não encontrado";
			return response;
		}
		
		response.setId(cliente.get().getId());
		response.setNome(cliente.get().getNome());
		response.setCpf(cliente.get().getCpf());
		response.message = "Cliente obtido com sucesso";
		return response;
		
	}
	
}














