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
import com.gestaoprotese.sigpro.domain.Usuario;
import com.gestaoprotese.sigpro.dto.UsuarioDTO;
import com.gestaoprotese.sigpro.repositories.UsuarioRepository;
import com.gestaoprotese.sigpro.services.exceptions.DataIntegrityException;
import com.gestaoprotese.sigpro.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public List<Usuario> findAll() {
		return repo.findAll();
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Usuario update(Usuario obj) {
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir usuário com vínculos.");
		}
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getNome(), new Instituicao(objDto.getInstituicaoId(), null, null));
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setNome(obj.getNome());
		newObj.setInstituicao(obj.getInstituicao());
	}
}
