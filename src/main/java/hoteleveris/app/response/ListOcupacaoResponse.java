package hoteleveris.app.response;

import java.util.List;

import hoteleveris.app.model.Ocupacao;

public class ListOcupacaoResponse extends BaseResponse{

	private List<Ocupacao> ocupacoes;

	public List<Ocupacao> getOcupacoes() {
		return ocupacoes;
	}

	public void setOcupacoes(List<Ocupacao> ocupacoes) {
		this.ocupacoes = ocupacoes;
	}

}