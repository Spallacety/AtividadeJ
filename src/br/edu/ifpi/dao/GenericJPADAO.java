package br.edu.ifpi.dao;

import java.util.List;

import javax.persistence.*;

import br.edu.ifpi.entity.Participante;

public class GenericJPADAO<T> implements GenericDAO<T> {

	private EntityManager em;
	private Class<T> persistenceClass;

	public GenericJPADAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

	@Override
	public T save(T object) {
		em = JPAUtil.getCurrentEntityManager();
		em.getTransaction().begin();
		T mergedObject = em.merge(object);
		em.getTransaction().commit();
		JPAUtil.closeCurrentEntityManager();
		return mergedObject;
	}

	@Override
	public void delete(T object) {
		em = JPAUtil.getCurrentEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(object));
		em.getTransaction().commit();
		JPAUtil.closeCurrentEntityManager();
	}

	@Override
	public T find(int id) {
		em = JPAUtil.getCurrentEntityManager();
		return em.find(persistenceClass, id);
	}

	@Override
	public List<T> findAll() {
		em = JPAUtil.getCurrentEntityManager();
		TypedQuery<T> query = em.createQuery("select v from " + this.persistenceClass.getSimpleName() + " v", this.persistenceClass);
		return query.getResultList();
}

}
