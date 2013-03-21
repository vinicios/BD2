package br.com.bd2.hibernate.model;

import java.util.Collection;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(name = "Clube_Seq")
public class Clube {
	
	@Id
	@GeneratedValue(generator = "Clube_Seq")
	@Column(name = "idClube", nullable=false)
	private Long id;
	
	@Column(name="Nome", nullable=false, length=50)
	private String nome;
	
	
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="ClubeJogador",
               joinColumns={@JoinColumn(name="idClube")}, 
               inverseJoinColumns={@JoinColumn(name="idJogador")}) 
	private Collection<Jogador> jogadores;

	public Clube() {
		
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

	public Collection<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(Collection<Jogador> jogadores) {
		this.jogadores = jogadores;
	}


}
