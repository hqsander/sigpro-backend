package com.gestaoprotese.sigpro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gestaoprotese.sigpro.domain.Instituicao;
import com.gestaoprotese.sigpro.dto.InstituicaoDTO;
import com.gestaoprotese.sigpro.repositories.InstituicaoRepository;
import com.gestaoprotese.sigpro.services.exceptions.DataIntegrityException;
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
	
	public Instituicao update(Instituicao obj) {
		Instituicao newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir instituição com vínculos.");
		}
	}
	
	public List<Instituicao> findAll() {
		return repo.findAll();
	}
	
	public Page<Instituicao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Instituicao fromDTO(InstituicaoDTO objDto) {
		return new Instituicao(objDto.getId(), objDto.getNome(), objDto.getTipo());
	}
	
	private void updateData(Instituicao newObj, Instituicao obj) {
		newObj.setNome(obj.getNome());
		newObj.setTipo(obj.getTipo());
	}
}
