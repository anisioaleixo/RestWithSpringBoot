package br.com.anisioaleixo.restwithspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.anisioaleixo.restwithspringboot.converter.DozerConverter;
import br.com.anisioaleixo.restwithspringboot.converter.custom.PersonConverter;
import br.com.anisioaleixo.restwithspringboot.data.model.Person;
import br.com.anisioaleixo.restwithspringboot.data.vo.PersonVO;
import br.com.anisioaleixo.restwithspringboot.data.vo.v2.PersonVOV2;
import br.com.anisioaleixo.restwithspringboot.exception.ResourseNotFoundException;
import br.com.anisioaleixo.restwithspringboot.repository.PersonRepoository;

@Service
public class PersonServices {

	@Autowired
	private PersonRepoository personRepoository;
	
	@Autowired
	private PersonConverter personConverter;

	public PersonVO create(PersonVO personvo) {
		var entity = DozerConverter.parseObject(personvo, Person.class);
		var vo = DozerConverter.parseObject(personRepoository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVOV2 createV2(PersonVOV2 personvo) {
		var entity = personConverter.convertVoToEntity(personvo);
		var vo = personConverter.convertEntityToVo(personRepoository.save(entity));
		return vo;
	}

	public List<PersonVO> findAll() {
		return DozerConverter.parseListObjects(personRepoository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {
		return (PersonVO) DozerConverter.parseObject(personRepoository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("No records found for this ID")), PersonVO.class);
	}

	public PersonVO update(PersonVO person) {
		Person entity = personRepoository.findById(person.getId())
				.orElseThrow(() -> new ResourseNotFoundException("No records found for this ID"));
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return DozerConverter.parseObject(personRepoository.save(entity), PersonVO.class);

	}

	public void delete(Long id) {
		Person entity = personRepoository.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("No records found for this ID"));
		personRepoository.delete(entity);
	}
}