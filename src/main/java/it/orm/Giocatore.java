package it.orm;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//@Table(name="giocatore_table")
//@Entity
public class Giocatore implements Serializable {
	private int id;
	private String nome;
	private String cognome;
	
	public Giocatore(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Giocatore() {
	}
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name="id_calciatore")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_squadra")
	public Squadra getSquadraDiGioco() {
		return squadraDiGioco;
	}
	public void setSquadraDiGioco(Squadra squadraDiGioco) {
		this.squadraDiGioco = squadraDiGioco;
	}

	private Squadra squadraDiGioco;
	
}
