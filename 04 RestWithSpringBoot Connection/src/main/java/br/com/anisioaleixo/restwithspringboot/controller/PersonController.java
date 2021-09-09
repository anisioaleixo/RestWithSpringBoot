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

import br.com.anisioaleixo.restwithspringboot.model.Person;
import br.com.anisioaleixo.restwithspringboot.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonServices services;
	

	@GetMapping("/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id) {
		Person person = services.findById(id);
		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Person>> findAll() {
		List<Person> persons = services.findAll();
		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Person> create(@RequestBody Person person) {
		Person updeted = services.create(person);
		return new ResponseEntity<Person>(updeted, HttpStatus.CREATED);
	}

	@PutMapping()
	public ResponseEntity<Person> update(@RequestBody Person person) {		
		Person entity = services.update(person);
		return ResponseEntity.ok(entity);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Person> delete(@PathVariable Long id) {
		services.delete(id);
		return ResponseEntity.noContent().build();
	}

}
