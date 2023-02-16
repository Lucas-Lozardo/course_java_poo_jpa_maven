package apllication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Person;

public class Program {

	public static void main(String[] args) {

		Person p1 = new Person(null, "Carlos da Silva", "carlos@gmail.com");
		Person p2 = new Person(null, "Joaquim Torres", "joaquim@gmail.com");
		Person p3 = new Person(null, "Ana Maria", "ana@gmail.com");
		
		
		///Para realizar toda a conexao com o banco de dados.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
	
		///Para iniciar uma transacao com o banco de dados.
		em.getTransaction().begin();
		///persist que pega o objeto e insere no banco de dados.
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		///Para confirmar as transacoes feitas.
		em.getTransaction().commit();
		
		System.out.println("Done!");
		
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	
		
		///Para buscar uma pessoa no banco de dados, nao ha necessidade de transacao para consulta.
		Person p4 = em.find(Person.class, 2);
		
		System.out.println("Finded Person: " + p4);
		/*
		///Para remover uma pessoa do banco de dados.
		Person p5 = em.find(Person.class, 3);
		
		em.getTransaction().begin();
		em.remove(p5);
		em.getTransaction().commit();
		
		System.out.println("Removed Person: " + p5);
		*/
		em.close();
		emf.close();
	}

}
