package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {

		delete();

	}

	public static void insert() {

		Pessoa p1 = new Pessoa(null, "Carlos", "carlos@teste.com");
		Pessoa p2 = new Pessoa(null, "Joaquim", "joaquim@teste.com");
		Pessoa p3 = new Pessoa(null, "Ana", "ana@teste.com");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		em.persist(p1);
		em.persist(p2);
		em.persist(p3);

		em.getTransaction().commit();
		em.close();

	}

	public static void select() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Pessoa p = em.find(Pessoa.class, 2);

		System.out.println(p);

		em.getTransaction().commit();
		em.close();

	}
	
	public static void delete() {
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();


		Pessoa p = em.find(Pessoa.class, 2);

		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		
	}
	

}
