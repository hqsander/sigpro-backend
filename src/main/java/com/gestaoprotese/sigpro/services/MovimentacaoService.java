package com.gestaoprotese.sigpro.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gestaoprotese.sigpro.domain.Instituicao;
import com.gestaoprotese.sigpro.domain.Movimentacao;
import com.gestaoprotese.sigpro.domain.Protese;
import com.gestaoprotese.sigpro.dto.MovimentacaoDTO;
import com.gestaoprotese.sigpro.repositories.MovimentacaoRepository;
import com.gestaoprotese.sigpro.repositories.ProteseRepository;
import com.gestaoprotese.sigpro.services.exceptions.DataIntegrityException;
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
	
	public Movimentacao update(Movimentacao obj) {
		Movimentacao newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir movimentações com vínculos.");
		}
	}
	
	public Page<Movimentacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
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
	
	private void updateData(Movimentacao newObj, Movimentacao obj) {
		newObj.setDataMovimentacao(obj.getDataMovimentacao());
		newObj.setSituacao(obj.getSituacao());
		newObj.setRemetente(obj.getRemetente());
		newObj.setDestinatario(obj.getDestinatario());
		newObj.setProtese(obj.getProtese());
	}
}
