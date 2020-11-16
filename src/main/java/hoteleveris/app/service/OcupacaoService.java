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

@Service
public class OcupacaoService {
	
	@Autowired
	OcupacaoRepository repository;
	
	public BaseResponse criar(OcupacaoRequest request) {
		BaseResponse response = new BaseResponse();
		response.statusCode = 400;
		
		if(request.getData().isEmpty()) {
			response.message = "Data não pode ser vazia";
			return response;
			
		}else if(request.getDiarias() <= 0) {
			response.message = "Quantidade de diarias não pode ser 0 ou vazia";
			return response;
			
		}else if(request.getQuartoId() <= 0) {
			response.message = "Id do quarto precisa ser inserido";
			return response;
			
		
		}else if(request.getClienteId() <= 0) {
			response.message = "Id do cliente precisa ser inserido";
			return response;
			
		
		}
		
		Ocupacao ocupacao = new Ocupacao();
		ocupacao.setData(request.getData());
		ocupacao.setDiarias(request.getDiarias());
		
		
		ocupacao.setSituacaoPagamento(request.getSituacaoPagamento());
		if (ocupacao.getSituacaoPagamento().isEmpty()) {
			ocupacao.setSituacaoPagamento("N");
		}
		
		Cliente obj = new Cliente();
		obj.setId(request.getClienteId());
		ocupacao.setCliente(obj);
		
		Quarto obj2 = new Quarto();
		obj2.setId(request.getQuartoId());
		ocupacao.setQuarto(obj2);
		
		repository.save(ocupacao);
		
		response.message = "Tipo de quarto criado.";
		response.statusCode = 200;
		
		return response;
	}
	
	public ListOcupacaoResponse listar() {
		
		List<Ocupacao> lista = repository.findAll();

		ListOcupacaoResponse response = new ListOcupacaoResponse();
		response.setOcupacoes(lista);
		response.statusCode = 200;
		response.message = "Ocupações obtidas com sucesso";
		
		return response;

}
	
}










