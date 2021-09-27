package br.com.anisioaleixo.restwithspringboot.converter.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.anisioaleixo.restwithspringboot.data.model.Person;
import br.com.anisioaleixo.restwithspringboot.data.vo.v2.PersonVOV2;

@Service
public class PersonConverter {
	public PersonVOV2 convertEntityToVo(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		return vo;
	}
	
	public Person convertVoToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		entity.setAddress(person.getAddress());
		return entity;
	}
	
	
}
