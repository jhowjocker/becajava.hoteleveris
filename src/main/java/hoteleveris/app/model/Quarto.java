package hoteleveris.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class Quarto {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		private int nQuarto;
		private int andar;
		private String situacao;
		
		@ManyToOne
		@JoinColumn(name = "tipoQuartoId")
		private TipoQuarto tipoQuarto;
		
		@ManyToMany(mappedBy = "quarto")
		Set<Comodidade> comodidade;

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

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

		public TipoQuarto getTipoQuarto() {
			return tipoQuarto;
		}

		public void setTipoQuarto(TipoQuarto tipoQuarto) {
			this.tipoQuarto = tipoQuarto;
		}

		public Set<Comodidade> getComodidade() {
			return comodidade;
		}

		public void setComodidade(Set<Comodidade> comodidade) {
			this.comodidade = comodidade;
		}
		
		
	
}
