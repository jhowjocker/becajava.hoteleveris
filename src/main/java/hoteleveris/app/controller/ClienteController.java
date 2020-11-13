package hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import hoteleveris.app.request.ClienteRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends BaseController {
	
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity inserir(@RequestBody ClienteRequest clienteRequest) {
		try {
			BaseResponse response = service.inserir(clienteRequest);
			return ResponseEntity.status(response.statusCode).body(response);
		
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro: Cliente não encontrado!");
		}
	}

}
