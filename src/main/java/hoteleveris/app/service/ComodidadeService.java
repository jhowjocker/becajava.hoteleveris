package hoteleveris.app.service;

import hoteleveris.app.request.ComodidadeIdRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ComodidadeResponse;

public interface ComodidadeService{

public BaseResponse criar(ComodidadeIdRequest request);

		ComodidadeResponse obter(Long id);
		

}





