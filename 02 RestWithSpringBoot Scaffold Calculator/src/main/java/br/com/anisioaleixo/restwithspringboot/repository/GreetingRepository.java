package br.com.anisioaleixo.restwithspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anisioaleixo.restwithspringboot.model.Greeting;

public interface GreetingRepository extends JpaRepository<Greeting, Long> {

}
