package br.edu.ifpi.principal;

import java.util.List;

import br.edu.ifpi.dao.GenericDAO;
import br.edu.ifpi.dao.GenericJPADAO;
import br.edu.ifpi.dao.ParticipanteRepository;
import br.edu.ifpi.entity.Participante;

public class Teste {

	public static void main(String[] args) {
		
		ParticipanteRepository repository = new ParticipanteRepository();
		
	//	Participante p = new Participante("0001", "Matheus", "0000-0000", "User");
		//Participante p = dao.find(1);
	//	dao.save(p);
		//dao.save(p);
		//dao.delete(p);
		
		List<Participante> lista = repository.findByNome("Lucas");
		for (Participante participante : lista) {
			System.out.println(participante);
		}
	//	System.out.println(dao.findByCPF(p.getCpf()));
	}
}
