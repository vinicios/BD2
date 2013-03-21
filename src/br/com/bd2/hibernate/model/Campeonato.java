package br.com.bd2.hibernate.model;
import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

@Entity
@SequenceGenerator(name = "Campeonato_Seq")
public class Campeonato {

	@Id
	@GeneratedValue(generator = "Campeonato_Seq")
	@Column(name = "idCampeonato", nullable=false)
	private Long id;
	
	@Column(name="Nome", nullable=false, length=50)
	private String nome;
	
	@Column(name = "Ano")
	private Integer ano;
	
	@Column(name = "NroClubes")
	private Integer nroClubes;

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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getNroClubes() {
		return nroClubes;
	}

	public void setNroClubes(Integer nroClubes) {
		this.nroClubes = nroClubes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ano == null) ? 0 : ano.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result
				+ ((nroClubes == null) ? 0 : nroClubes.hashCode());
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
		Campeonato other = (Campeonato) obj;
		if (ano == null) {
			if (other.ano != null)
				return false;
		} else if (!ano.equals(other.ano))
			return false;
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
		if (nroClubes == null) {
			if (other.nroClubes != null)
				return false;
		} else if (!nroClubes.equals(other.nroClubes))
			return false;
		return true;
	}
	
		
}
