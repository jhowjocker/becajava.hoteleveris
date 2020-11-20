package hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoteleveris.app.request.OcupacaoRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.service.imp.OcupacaoServiceImp;

@RestController
@RequestMapping("/ocupacoes")
public class OcupacaoController extends BaseController {
	
	
	@Autowired
	OcupacaoServiceImp service;
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody OcupacaoRequest request){
		
		try {
				BaseResponse response = service.criar(request);
				return ResponseEntity.status(response.statusCode).body(response);
		}catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@GetMapping
	public ResponseEntity<BaseResponse> listar(){
			
		try {
				BaseResponse response = service.listar();
				return ResponseEntity.status(response.statusCode).body(response);
		}catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}

}









