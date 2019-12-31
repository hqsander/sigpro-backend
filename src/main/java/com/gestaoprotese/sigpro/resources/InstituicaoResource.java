package com.gestaoprotese.sigpro.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gestaoprotese.sigpro.domain.Instituicao;
import com.gestaoprotese.sigpro.dto.InstituicaoDTO;
import com.gestaoprotese.sigpro.services.InstituicaoService;

@RestController
@RequestMapping(value = "/instituicoes")
public class InstituicaoResource {
	
	@Autowired
	private InstituicaoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Instituicao obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InstituicaoDTO objDto) {
		Instituicao obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody InstituicaoDTO objDto, @PathVariable Integer id) {
		Instituicao obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Instituicao> list = service.findAll();
		List<InstituicaoDTO> listDto = list.stream().map(obj -> new InstituicaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
}
