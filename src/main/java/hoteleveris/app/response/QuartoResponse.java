package hoteleveris.app.response;

import java.util.List;

import hoteleveris.app.request.ComodidadeRequest;

public class QuartoResponse extends BaseResponse {
	
		private Long id;
		private int andar;
		private int nQuarto;
		private String situacao;
		private Long idTipoQuarto;
		private Long idComodidade;
		
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getIdComodidade() {
			return idComodidade;
		}

		public void setIdComodidade(Long idComodidade) {
			this.idComodidade = idComodidade;
		}

		private List<ComodidadeRequest> comodidades;

		public int getAndar() {
			return andar;
		}

		public void setAndar(int andar) {
			this.andar = andar;
		}

		public int getnQuarto() {
			return nQuarto;
		}

		public void setnQuarto(int nQuarto) {
			this.nQuarto = nQuarto;
		}

		public String getSituacao() {
			return situacao;
		}

		public void setSituacao(String situacao) {
			this.situacao = situacao;
		}

		public Long getIdTipoQuarto() {
			return idTipoQuarto;
		}

		public void setIdTipoQuarto(Long idTipoQuarto) {
			this.idTipoQuarto = idTipoQuarto;
		}

		public List<ComodidadeRequest> getComodidades() {
			return comodidades;
		}

		public void setComodidades(List<ComodidadeRequest> comodidades) {
			this.comodidades = comodidades;
		}

}
