package com.gestaoprotese.sigpro.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestaoprotese.sigpro.domain.Instituicao;
import com.gestaoprotese.sigpro.domain.Movimentacao;
import com.gestaoprotese.sigpro.domain.Protese;
import com.gestaoprotese.sigpro.dto.MovimentacaoDTO;
import com.gestaoprotese.sigpro.repositories.MovimentacaoRepository;
import com.gestaoprotese.sigpro.repositories.ProteseRepository;
import com.gestaoprotese.sigpro.services.exceptions.ObjectNotFoundException;

@Service
public class MovimentacaoService {
	
	@Autowired
	MovimentacaoRepository repo;
	@Autowired
	ProteseRepository proteseRepo;
	
	public Movimentacao find(Integer id) {
		Optional<Movimentacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Movimentacao.class.getName()));
	}
	
	public List<Movimentacao> findAll() {
		return repo.findAll();
	}
	
	public Movimentacao insert(Movimentacao obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Movimentacao fromDTO(MovimentacaoDTO objDto) {
		Protese protese;
		try {
			protese = proteseRepo.findById(objDto.getProteseId()).get();
		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Objeto não encontrado! Id: " + objDto.getProteseId() + ", Tipo: " + Protese.class.getName());
		}
		
		
		return new Movimentacao(
				objDto.getId(),
				objDto.getDataMovimentacao(),
				objDto.getSituacao(),
				new Instituicao(objDto.getRemetenteId(), null, null),
				new Instituicao(objDto.getDestinatarioId(), null, null),
				protese);
	}
}
