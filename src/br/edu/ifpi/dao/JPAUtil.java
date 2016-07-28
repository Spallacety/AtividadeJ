package br.edu.ifpi.dao;

import javax.persistence.*;

public class JPAUtil {

	private static final EntityManagerFactory emf = Persistence
		.createEntityManagerFactory("j-local-mysql");

	private static ThreadLocal<EntityManager> ems = new ThreadLocal<EntityManager>();

	// Fecha o EntityManager atrelado ah Thread atual e retira-o
	// da ThreadLocal.
	public static void closeCurrentEntityManager() {
		EntityManager em = ems.get();

		if (em != null && em.isOpen()){
		em.close();
		//em.flush();
		}
		
		ems.set(null);
	}

	// Obtem o EntityManager vinculado a Thread atual. Se ele ainda
	// nao existir, eh criado e depois, vinculado a Thread atual.
	public static EntityManager getCurrentEntityManager() {
		EntityManager em = ems.get();

		if (em == null) {
		em = emf.createEntityManager();
		ems.set(em);
		}

		return em;
	}

}
