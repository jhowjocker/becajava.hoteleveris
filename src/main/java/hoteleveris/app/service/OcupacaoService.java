package hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoteleveris.app.model.Cliente;
import hoteleveris.app.model.Ocupacao;
import hoteleveris.app.model.Quarto;
import hoteleveris.app.repository.OcupacaoRepository;
import hoteleveris.app.request.OcupacaoRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.response.ListOcupacaoResponse;


public interface OcupacaoService {
	
	BaseResponse criar(OcupacaoRequest request);
		
	
	ListOcupacaoResponse listar();


	
}










