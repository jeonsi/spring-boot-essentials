package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Person;

public interface PersonDao {

	UUID insertPerson(UUID id, Person person);

	default UUID insertPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

	List<Person> selectAllPersons();

	Optional<Person> selectPerson(UUID id);

	int deletePerson(UUID id);

	int updatePerson(UUID id, Person person);

}
