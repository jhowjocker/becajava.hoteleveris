package hoteleveris.app.controller;

import hoteleveris.app.response.BaseResponse;

public class BaseController {
		
	public BaseResponse errorBase = new BaseResponse();
	
	public BaseController() {
		errorBase.statusCode = 500;
		errorBase.message = "Erro inesperado. Contato o suporte tecnico!";
	}
}
