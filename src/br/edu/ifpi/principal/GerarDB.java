package br.edu.ifpi.principal;

import java.util.Properties;

import javax.persistence.*;

public class GerarDB {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("hibernate.hbm2ddl.auto", "update");
		
		try {
		
		EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("j-local-mysql", prop);
		EntityManager em = emf.createEntityManager();		
		em.close();
		emf.close();
		
		System.out.println("BD atualizado.");
		
		} catch (Exception e) {
		
		e.printStackTrace();
		System.out.println("Erro ao atualizar o DB.");
		}
	}
}
