package hoteleveris.app.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hoteleveris.app.model.Ocupacao;
import hoteleveris.app.repository.OcupacaoRepository;
import hoteleveris.app.request.TransferenciaRequest;
import hoteleveris.app.response.BaseResponse;
import hoteleveris.app.service.FaturaService;

@Service
public class FaturaServiceImp implements FaturaService{

		@Autowired
		private OcupacaoRepository ocupacaoRepository;
		
	
		private String hashContaHotel  = "lhbvq1c2kutlcgokbb0pc39q58";
		
		public BaseResponse transferencia() {
			BaseResponse response = new BaseResponse();
			
			RestTemplate restTemplate = new RestTemplate();
			String uri = "http://localhost:8081/operacoes/transferencia";
			
			List<Ocupacao> lista = ocupacaoRepository.findBySituacaoPagamento("N");
			
			for (Ocupacao ocupacao : lista) {
				double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getDiarias();
						
				TransferenciaRequest transferencia = new TransferenciaRequest();
				transferencia.setHashDestino(hashContaHotel);
				transferencia.setHashOrigem(ocupacao.getCliente().getHash());
				transferencia.setValor(valor);
				
				BaseResponse response1 = restTemplate.postForObject(uri, transferencia, BaseResponse.class);
				
				ocupacao.setSituacaoPagamento("P");
				ocupacaoRepository.save(ocupacao);
				
			}
			
			response.statusCode = 200;
			response.setMessage("Transação feita com sucesso");
			return response;
			
			
		}
	
	
}
