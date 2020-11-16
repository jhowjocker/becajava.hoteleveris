package hoteleveris.app.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Comodidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	public Comodidade() {
		
	}
	
	public Comodidade(String nome) {
		super();
		this.nome = nome;
	}
	
	
	public Comodidade(Long id) {
		super();
		this.id = id;
	}
	
	public Comodidade(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	

}








