package br.edu.ifpi.dao;

import java.util.List;

import javax.persistence.*;

import br.edu.ifpi.entity.Participante;

public class ParticipanteJPADAO implements ParticipanteDAO{

	@Override
	public void save(Participante p) {
		JPAUtil.getCurrentEntityManager().getTransaction().begin();
		JPAUtil.getCurrentEntityManager().merge(p);
		JPAUtil.getCurrentEntityManager().getTransaction().commit();
		JPAUtil.closeCurrentEntityManager();
	}
	
	@Override
	public void delete(Participante p) {
		JPAUtil.getCurrentEntityManager().getTransaction().begin();
		JPAUtil.getCurrentEntityManager().remove(p);;
		JPAUtil.getCurrentEntityManager().getTransaction().commit();
		JPAUtil.closeCurrentEntityManager();
	}

	@Override
	public Participante find(int id) {
		return JPAUtil.getCurrentEntityManager().find(Participante.class, id);
	}

	@Override
	public List<Participante> findAll() {
		TypedQuery<Participante> query = JPAUtil.getCurrentEntityManager().createQuery("select c from " + Participante.class.getSimpleName() + " c", Participante.class);
		return query.getResultList();
	}

	@Override
	public Participante findByCPF(String cpf) {
		TypedQuery<Participante> query = JPAUtil.getCurrentEntityManager().createQuery("select c from " + Participante.class.getSimpleName() + " c where cpf = '" + cpf + "'", Participante.class);
		return query.getSingleResult();
	}

	@Override
	public List<Participante> findByNome(String nome) {
		TypedQuery<Participante> query = JPAUtil.getCurrentEntityManager().createQuery("select c from " + Participante.class.getSimpleName() + " c where nome = '" + nome + "'", Participante.class);
		return query.getResultList();
	}

}
