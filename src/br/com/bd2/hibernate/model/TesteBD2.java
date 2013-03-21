package br.com.bd2.hibernate.model;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TesteBD2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BD2");
		EntityManager em = emf.createEntityManager();

		ArrayList<Dependente> d = new ArrayList<Dependente>();
		Pessoa p = new Pessoa("Gilberto Müller");
		Dependente d1 = new Dependente("Jamile");
		Dependente d2 = new Dependente("Estéfane");
		
		Campeonato camp1 = new Campeonato();
		camp1.setAno(2013);
		camp1.setNome("Libertadores");
		camp1.setNroClubes(32);
		
		Jogador j1 = new Jogador("Vargas");
		Jogador j2 = new Jogador("Barcos");
		
		Posicao pos1 = new Posicao("Atacante");
		Posicao pos2 = new Posicao("Goleiro");
		
		j1.setPosicao(pos1);
		j2.setPosicao(pos1);
		
		d1.setPessoa(p);
		d2.setPessoa(p);
		d.add(d1);
		d.add(d2);
		p.setDependentes(d);
		
		
		//Copat - trabalhando.
		Collection<Jogador> jogadoresDoGremio = new ArrayList<Jogador>();
		jogadoresDoGremio.add(j1);
		jogadoresDoGremio.add(j2);
		
		Clube clubeGremio = new Clube();
		clubeGremio.setNome("Grêmio");
		
		clubeGremio.setJogadores(jogadoresDoGremio);
		
		

		em.getTransaction().begin();
		em.persist(d1);
		em.persist(d2);
		em.persist(p);
		em.persist(camp1);
		em.persist(j1);
		em.persist(j2);
		em.persist(pos1);
		em.persist(pos2);
		em.persist(clubeGremio);
		
		em.getTransaction().commit();
		
		
        
		// Observe o id 1L
		p = em.find(Pessoa.class, 1L);
		for(Dependente dependentes: p.getDependentes())
			System.out.println("Dependente: " + dependentes.getNome());		
	}
}
