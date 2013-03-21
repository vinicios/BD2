package br.com.bd2.hibernate.model;
import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Collection;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(name = "Jogador_Seq")
public class Jogador {

	@Id
	@GeneratedValue(generator = "Jogador_Seq")
	@Column(name = "idJogador", nullable=false)
	private Long id;
	
	@Column(name="Nome", nullable=false, length=50)
	private String nome;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name="idPosicao", referencedColumnName="idPosicao") 
	@Fetch(FetchMode.JOIN) 
	private Posicao posicao;
		
	@ManyToMany(mappedBy="jogadores")
	private Collection<Clube> clubes;

	public Jogador(String nome) {
		super();
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

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Collection<Clube> getClubes() {
		return clubes;
	}

	public void setClubes(Collection<Clube> clubes) {
		this.clubes = clubes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((posicao == null) ? 0 : posicao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (posicao == null) {
			if (other.posicao != null)
				return false;
		} else if (!posicao.equals(other.posicao))
			return false;
		return true;
	}
	
	
	
}
