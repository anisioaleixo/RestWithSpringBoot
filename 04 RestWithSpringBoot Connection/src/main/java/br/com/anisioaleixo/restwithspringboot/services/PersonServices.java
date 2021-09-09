package br.com.anisioaleixo.restwithspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anisioaleixo.restwithspringboot.exception.ResourseNotFoundException;
import br.com.anisioaleixo.restwithspringboot.model.Person;
import br.com.anisioaleixo.restwithspringboot.repository.PersonRepoository;

@Service
public class PersonServices {

	@Autowired
	private PersonRepoository personRepoository;

	public Person create(Person person) {
		return personRepoository.save(person);
	}

	public List<Person> findAll() {
		return personRepoository.findAll();
	}

	public Person findById(Long id) {
		return personRepoository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("No records found for this ID"));
	}

	public Person update(Person person) {
		Person entity = personRepoository.findById(person.getId())
				.orElseThrow(() -> new ResourseNotFoundException("No records found for this ID"));
		entity.setFirtName(person.getFirtName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());

		return personRepoository.save(entity);
	}

	public void delete(Long id) {
		Person entity = personRepoository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("No records found for this ID"));

		personRepoository.delete(entity);
	}
}