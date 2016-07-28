package br.edu.ifpi.dao;

import java.util.List;

import br.edu.ifpi.entity.Participante;

public interface ParticipanteDAO {

	void save(Participante p);
	void delete(Participante p);
	Participante find(int id);
	List<Participante> findAll();
	Participante findByCPF(String cpf);
	List<Participante> findByNome(String nome);
	
}
