package hoteleveris.app.service;

import hoteleveris.app.request.ClienteRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ClienteResponse;

public interface ClienteService{
	
		BaseResponse inserir (ClienteRequest request);
		
		ClienteResponse obter(Long id);
}