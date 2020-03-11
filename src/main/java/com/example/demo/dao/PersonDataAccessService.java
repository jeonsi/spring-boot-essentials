package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public class PersonDataAccessService implements PersonDao {

	@Override
	public UUID addPerson(UUID id, Person person) {
		return null;
	}

	@Override
	public List<Person> getPeople() {
		return null;
	}

	@Override
	public Optional<Person> getPerson(UUID id) {
		return Optional.empty();
	}

	@Override
	public int deletePerson(UUID id) {
		return 0;
	}

	@Override
	public int updatePerson(UUID id, Person person) {
		return 0;
	}
}
