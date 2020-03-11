package com.example.demo.model;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	private final UUID id;
	@NotBlank	// "" should be avoided, @NotNull is not enough
	private final String name;

	@NotNull
	@Min(0)
	private final Integer age;

	public Person(@JsonProperty("id") UUID id,
		@JsonProperty("name") String name,
		@JsonProperty("age") Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public UUID getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}
}
