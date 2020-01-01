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
import com.gestaoprotese.sigpro.domain.Paciente;
import com.gestaoprotese.sigpro.domain.Protese;
import com.gestaoprotese.sigpro.domain.Usuario;
import com.gestaoprotese.sigpro.dto.ProteseDTO;
import com.gestaoprotese.sigpro.repositories.ProteseRepository;
import com.gestaoprotese.sigpro.services.exceptions.DataIntegrityException;
import com.gestaoprotese.sigpro.services.exceptions.ObjectNotFoundException;

@Service
public class ProteseService {
	
	@Autowired
	private ProteseRepository repo;
	
	public Protese find(Integer id) {
		Optional<Protese> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Protese.class.getName()));
	}
	
	public List<Protese> findAll() {
		return repo.findAll();
	}
	
	public Protese insert(Protese obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Protese update(Protese obj) {
		Protese newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir prótese com vínculos.");
		}
	}
	
	public Page<Protese> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Protese fromDTO(ProteseDTO objDto) {
		return new Protese(
				objDto.getId(),
				new Paciente(objDto.getPacienteId(), null, null),
				objDto.getCodRastreio(),
				objDto.getObservacao(),
				objDto.getTotalSuperior(),
				objDto.getTotalInferior(),
				objDto.getParcialSuperior(),
				objDto.getParcialInferior(),
				new Usuario(objDto.getSolicitanteId(), null, null),
				new Instituicao(objDto.getLaboratorioId(), null, null));
	}
	
	private void updateData(Protese newObj, Protese obj) {
		newObj.setPaciente(obj.getPaciente());
		newObj.setCodRastreio(obj.getCodRastreio());
		newObj.setObservacao(obj.getObservacao());
		newObj.setTotalSuperior(obj.getTotalSuperior());
		newObj.setTotalInferior(obj.getTotalInferior());
		newObj.setParcialSuperior(obj.getParcialSuperior());
		newObj.setParcialInferior(obj.getParcialInferior());
		newObj.setSolicitante(obj.getSolicitante());
		newObj.setLaboratorio(obj.getLaboratorio());
	}
}
