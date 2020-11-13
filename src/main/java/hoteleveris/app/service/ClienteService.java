package hoteleveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleveris.app.model.Cliente;
import hoteleveris.app.repository.ClienteRepository;
import hoteleveris.app.request.ClienteRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ClienteResponse;

@Service
public class ClienteService {
	
	final ClienteRepository _repository;
		
		@Autowired
		private ClienteService (ClienteRepository repository) {
			_repository = repository;
			
		}
		
		public BaseResponse inserir(ClienteRequest clienteRequest) {
			Cliente cliente = new Cliente();
			BaseResponse base = new ClienteResponse();
			base.statusCode = 400;
			
			if (clienteRequest.getNome() == "") {
				base.message = "Cliente não informado!";
				return base;
			}
			
			if (clienteRequest.getCpf() == "") {
				base.message = "CPF não informado!";
				return base;
			}
			
			if (clienteRequest.getHash() == "") {
				base.message = "Hash não informado!";
				return base;
			}
			
			
			cliente.setNome(clienteRequest.getNome());
			cliente.setCpf(clienteRequest.getCpf());
			cliente.setHash(clienteRequest.getHash());
			
			_repository.save(cliente);
			
			base.statusCode = 201;
			base.message = "Cliente inserido com sucesso!";
			return base;
			
		}
		
		
		
}
