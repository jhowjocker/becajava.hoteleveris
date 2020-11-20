package hoteleveris.app.request;

public class OcupacaoRequest {
	
	private String data;
	private int diarias;
	private String situacaoPagamento;
	private Long clienteId;
	private Long quartoId;
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getDiarias() {
		return diarias;
	}
	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	public String getSituacaoPagamento() {
		return situacaoPagamento;
	}
	public void setSituacaoPagamento(String situacaoPagamento) {
		this.situacaoPagamento = situacaoPagamento;
	}
	public Long getClienteId() {
		return clienteId;
	}
	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	public Long getQuartoId() {
		return quartoId;
	}
	public void setQuartoId(Long quartoId) {
		this.quartoId = quartoId;
	}
	
	
	
}
