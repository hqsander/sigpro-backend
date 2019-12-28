package com.gestaoprotese.sigpro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoprotese.sigpro.domain.Protese;
import com.gestaoprotese.sigpro.repositories.ProteseRepository;
import com.gestaoprotese.sigpro.services.exceptions.ObjectNotFoundException;

@Service
public class ProteseService {
	
	@Autowired
	private ProteseRepository repo;
	
	public Protese find(Integer id) {
		Optional<Protese> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Protese.class.getName()));
	}
}
