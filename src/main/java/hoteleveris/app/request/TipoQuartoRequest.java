package hoteleveris.app.request;

import hoteleveris.app.response.BaseResponse;

public class TipoQuartoRequest extends BaseResponse {
	
	public Long id;
	public String descricao;
	public Double valor;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
