package br.com.anisioaleixo.restwithspringboot.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Greeting {	
	@Id
	private final long id;
	private final String content;

	public Greeting(long id, String content) {
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
