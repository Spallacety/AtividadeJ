package br.edu.ifpi.dao;

import java.util.List;

import br.edu.ifpi.entity.Participante;

public interface GenericDAO<T> {

	T save(T p);
	void delete(T p);
	T find(int id);
	List<T> findAll();
	
}
