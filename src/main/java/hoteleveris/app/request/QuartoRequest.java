package hoteleveris.app.request;

import java.util.List;

public class QuartoRequest {
	
	private int nQuarto;
	private int andar;
	private String situacao;
	private Long tipoQuartoId;
	
	private List<ComodidadeRequest> comodidade;

	public int getnQuarto() {
		return nQuarto;
	}

	public void setnQuarto(int nQuarto) {
		this.nQuarto = nQuarto;
	}

	public int getAndar() {
		return andar;
	}

	public void setAndar(int andar) {
		this.andar = andar;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getTipoQuartoId() {
		return tipoQuartoId;
	}

	public void setTipoQuartoId(Long tipoQuartoId) {
		this.tipoQuartoId = tipoQuartoId;
	}

	public List<ComodidadeRequest> getComodidade() {
		return comodidade;
	}

	public void setComodidade(List<ComodidadeRequest> comodidade) {
		this.comodidade = comodidade;
	}
	
	
	

}
