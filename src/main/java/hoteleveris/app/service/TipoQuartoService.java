package hoteleveris.app.service;

import hoteleveris.app.request.TipoQuartoRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ListTipoQuartoResponse;
import hoteleveris.app.response.TipoQuartoResponse;

public interface TipoQuartoService {
	
	BaseResponse criar(TipoQuartoRequest request); 
		
		TipoQuartoResponse obter(Long id); 
		
		ListTipoQuartoResponse listar();
		
}













