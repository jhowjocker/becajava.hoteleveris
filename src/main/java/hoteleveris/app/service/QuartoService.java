package hoteleveris.app.service;

import hoteleveris.app.request.QuartoRequest;
import hoteleveris.app.request.SituacaoQuartoRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ListQuartoResponse;
import hoteleveris.app.response.QuartoResponse;


public interface QuartoService {

		BaseResponse criar(QuartoRequest request); 
	
	QuartoResponse obter(Long id); 
	
	ListQuartoResponse listar(Long id); 

	BaseResponse atualizar(Long id, SituacaoQuartoRequest request); 

}