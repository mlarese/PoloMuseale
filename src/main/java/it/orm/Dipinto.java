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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Table(name="dipinto")

@Entity
public class Dipinto implements Serializable{
	private static final long serialVersionUID = 2L;	
	
	private Integer id;
	private String nome;
	
	
	@Id
	@Column(name="id_dipinto")
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

	
	private Museo museo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="id_museo")
	public Museo getMuseo() {
		return museo;
	}
	public void setMuseo(Museo museo) {
		this.museo = museo;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	public List<Artista> getArtisti() {
		if(artisti==null) artisti=new ArrayList<Artista>();
		return artisti;
	}
	public void setArtisti(List<Artista> artisti) {
		this.artisti = artisti;
	}


	
	private List<Artista> artisti;
	
	
}