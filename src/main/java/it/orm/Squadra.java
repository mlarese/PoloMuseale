package it.orm;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

//@Table(name="squadra_table")
//@Entity
public class Squadra{
	private Integer id;
	private String nome;
	private List<Giocatore> elencoGiocatori;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id_squadra")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column
	public String getNome() {
		return nome;
	}
	public Squadra() {
	}
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "squadraDiGioco")
	public List<Giocatore> getElencoGiocatori() {
		return elencoGiocatori;
	}
	public void setElencoGiocatori(List<Giocatore> elencoGiocatori) {
		this.elencoGiocatori = elencoGiocatori;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Squadra(String nome) {
		this.nome = nome;
		this.elencoGiocatori = new ArrayList<Giocatore>();
	}
	
	public void printGiocatori(){
		System.out.println(" sq: " + getNome());
		for(Giocatore g: elencoGiocatori) {
			System.out.println(g.getNome() + " sq: " + g.getSquadraDiGioco().getNome());
		}
	}	
	

}
