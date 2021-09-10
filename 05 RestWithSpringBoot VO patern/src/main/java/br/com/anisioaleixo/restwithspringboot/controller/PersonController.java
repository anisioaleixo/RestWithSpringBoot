package br.com.anisioaleixo.restwithspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.anisioaleixo.restwithspringboot.data.vo.PersonVO;
import br.com.anisioaleixo.restwithspringboot.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	

	@GetMapping("/{id}")
	public ResponseEntity<PersonVO> findById(@PathVariable Long id) {
		PersonVO person = services.findById(id);
		return new ResponseEntity<PersonVO>(person, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<PersonVO>> findAll() {
		List<PersonVO> persons = services.findAll();
		return new ResponseEntity<List<PersonVO>>(persons, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<PersonVO> create(@RequestBody PersonVO person) {
		PersonVO personVO = services.create(person);
		return new ResponseEntity<PersonVO>(personVO, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<PersonVO> update(@RequestBody PersonVO person) {		
		PersonVO entity = services.update(person);
		return ResponseEntity.ok(entity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<PersonVO> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}

}
