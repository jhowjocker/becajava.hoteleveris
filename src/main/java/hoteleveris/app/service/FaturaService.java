package hoteleveris.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import hoteleveris.app.model.Ocupacao;
import hoteleveris.app.repository.ClienteRepository;
import hoteleveris.app.repository.OcupacaoRepository;
import hoteleveris.app.repository.QuartoRepository;
import hoteleveris.app.repository.TipoQuartoRepository;
import hoteleveris.app.request.TransferenciaRequest;
import hoteleveris.app.response.BaseResponse;

@Service
public class FaturaService {

		@Autowired
		private OcupacaoRepository ocupacaoRepository;
		
		@Autowired
		private ClienteRepository clienteRepository;
		
		@Autowired
		private TipoQuartoRepository TipoQuartoRepository;
		
		@Autowired
		private QuartoRepository quartoRepository;
		
		private String hashContaHotel  = "11111111";
		
		public void inserir() {
			
			RestTemplate restTemplate = new RestTemplate();
			String uri = "http://localhost:8081/operacao/transferencia";
			
			List<Ocupacao> lista = ocupacaoRepository.findBySituacaoPagamento("N");
			
			for (Ocupacao ocupacao : lista) {
				double valor = ocupacao.getQuarto().getTipoQuarto().getValor() * ocupacao.getDiarias();
						
				TransferenciaRequest transferencia = new TransferenciaRequest();
				transferencia.setHashDestino(hashContaHotel);
				transferencia.setHashOrigem(ocupacao.getCliente().getHash());
				transferencia.setValor(valor);
				
				BaseResponse response = restTemplate.postForObject(uri, transferencia, BaseResponse.class);
				
				ocupacao.setSituacaoPagamento("P");
				ocupacaoRepository.save(ocupacao);
				
			}
			
			
		}
	
	
	
	
	
	
	
	
	
	
}
