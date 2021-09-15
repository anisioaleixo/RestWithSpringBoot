package br.com.anisioaleixo.restwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anisioaleixo.restwithspringboot.data.model.Person;

public interface PersonRepoository extends JpaRepository<Person, Long>{

}
