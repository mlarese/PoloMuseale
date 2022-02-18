package it.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Table(name="artista")

@Entity
public class Artista implements Serializable{
	
	@Override
	public String toString() {
		return "Artista [id=" + id + ", nome=" + nome + ", cognome="
	+ cognome +  "]";
	}



	private static final long serialVersionUID = 3L;	
	
	private Integer id;
	public Artista(Integer id, String nome, String cognome, List<Dipinto> dipinti) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dipinti = dipinti;
	}

	public Artista(Integer id, String nome, String cognome) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Artista() {
	}



	private String nome;
	private String cognome;
	
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Id
	@Column(name="id_artista")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	private List<Dipinto> dipinti;

	@ManyToMany(cascade = CascadeType.PERSIST)
	public List<Dipinto> getDipinti() {
		if(dipinti==null) dipinti = new ArrayList<Dipinto>();
		return dipinti;
	}
	public void setDipinti(List<Dipinto> dipinti) {
		this.dipinti = dipinti;
	}

	
	
}