package hoteleveris.app.response;

import java.util.List;

import hoteleveris.app.model.Quarto;

public class ListQuartoResponse extends BaseResponse {

	private List<Quarto> quartos;

	public List<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<Quarto> quartos) {
		this.quartos = quartos;
	}

	
}