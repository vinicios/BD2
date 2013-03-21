package br.com.bd2.hibernate.model;
import static javax.persistence.GenerationType.SEQUENCE;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;

@Entity
@SequenceGenerator(name = "Pessoa_Seq")
public class Pessoa {
	
	@Id
	@GeneratedValue(generator = "Pessoa_Seq")
	@Column(name = "ID")
	private Long id;
	
	
    @Column(length=50, nullable=false)	
	private String nome;

    @OneToMany(mappedBy="pessoa")
    private List<Dependente> dependentes;
    
    public Pessoa(String nome) { this.nome = nome; }
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public List<Dependente> getDependentes() {
		return dependentes;
	}
	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
}
