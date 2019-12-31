package com.gestaoprotese.sigpro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoprotese.sigpro.domain.Instituicao;
import com.gestaoprotese.sigpro.domain.enums.TipoInstituicao;
import com.gestaoprotese.sigpro.dto.InstituicaoDTO;
import com.gestaoprotese.sigpro.repositories.InstituicaoRepository;
import com.gestaoprotese.sigpro.services.exceptions.ObjectNotFoundException;

@Service
public class InstituicaoService {
	
	@Autowired
	private InstituicaoRepository repo;
	
	public Instituicao find(Integer id) {
		Optional<Instituicao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Instituicao.class.getName()));
	}
	
	public Instituicao insert(Instituicao obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Instituicao fromDTO(InstituicaoDTO objDto) {
		return new Instituicao(objDto.getId(), objDto.getNome(), TipoInstituicao.toEnum(objDto.getTipo()));
	}
}
