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

	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable("id") String id) {
		Person person = services.findById(id);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<List<Person>> findAll() {
		List<Person> persons = services.findAll();
		return new ResponseEntity<>(persons, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<Person> create(@RequestBody Person person) {
		Person personCreate = services.create(person);
		return new ResponseEntity<>(personCreate, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Person> update(@RequestBody Person person) {
		services.update(person);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Person> delete(@PathVariable("id") String id) {
		services.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
