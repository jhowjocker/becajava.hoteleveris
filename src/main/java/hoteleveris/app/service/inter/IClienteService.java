package hoteleveris.app.service.inter;

import hoteleveris.app.request.ClienteRequest;
import hoteleveris.app.response.BaseResponse;

public interface IClienteService {
		BaseResponse inserir(ClienteRequest request);
	
}
