package hoteleveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoteleveris.app.request.ComodidadeIdRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.service.ComodidadeService;

@RestController
@RequestMapping("/comodidades")
public class ComodidadeController extends BaseController {

		@Autowired
		private ComodidadeService service;
		
		@PostMapping
		public ResponseEntity <BaseResponse>criar(@RequestBody ComodidadeIdRequest request){
			try {
				BaseResponse response = service.criar(request);
				return ResponseEntity.status(response.statusCode).body(response);
			}catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
			}
		} 
		
		@GetMapping(path = "/{id}")
		
		public ResponseEntity<BaseResponse> obter(@PathVariable Long id) {
			
			try {
					BaseResponse response = service.obter(id);
					return ResponseEntity.status(errorBase.statusCode).body(response);
					
			}catch (Exception e) {
				return ResponseEntity.status(errorBase.statusCode).body(errorBase);
				
			}
		}
		
		
}















