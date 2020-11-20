package hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoteleveris.app.request.QuartoRequest;
import hoteleveris.app.request.SituacaoQuartoRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.service.imp.QuartoServiceImp;

@RestController
@RequestMapping("/quartos")
public class QuartoController extends BaseController {
	
	@Autowired
	QuartoServiceImp service;
	
	@PostMapping
	public ResponseEntity<BaseResponse> criar(@RequestBody QuartoRequest request) {
		try {
			BaseResponse response = service.criar(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
		try {
			BaseResponse response = service.obter(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
	}
	
	@GetMapping(path = "/tipo/{id}")
	public ResponseEntity<BaseResponse> listar(@PathVariable Long id) {
		try {
			BaseResponse response = service.listar(id);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}
		
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<BaseResponse> atualizar(@Validated @PathVariable("id") Long id,
			@RequestBody SituacaoQuartoRequest request) {

		try {
			BaseResponse response = service.atualizar(id, request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(errorBase.statusCode).body(errorBase);
		}

	}
}












