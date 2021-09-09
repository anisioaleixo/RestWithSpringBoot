package br.com.anisioaleixo.restwithspringboot.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.anisioaleixo.restwithspringboot.model.Person;

@Service
public class PersonServices {
	private final AtomicLong counter = new AtomicLong();

	public Person create(Person person) {
		Person p = person;
		p.setId(counter.incrementAndGet());
		return p;
	}

	public Person update(Person person) {
		return person;
	}

	public void delete(String id) {

	}

	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirtName("Anisio");
		person.setLastName("Aleixo");
		person.setAdress("Marituba - Pará - Brasil");
		person.setGender("Male");
		return person;
	}

	public List<Person> findAll() {
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = findById(i + "");
			persons.add(person);
		}
		return persons;
	}
}