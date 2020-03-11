package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("fakeDao")	// same as @Component, "fakeDao" is the name of this instance
public class FakePersonDataAccessService implements PersonDao {

	private static final List<Person> DB = new ArrayList<>();

	@Override
	public List<Person> selectAllPersons() {
		return DB;
	}

	@Override
	public UUID insertPerson(UUID id, Person person) {
		DB.add(new Person(id, person.getName(), person.getAge()));
		return id;
	}

	@Override
	public Optional<Person> selectPerson(UUID id) {
		return DB
			.stream()
			.filter(person -> person.getId().equals(id))
			.findFirst();
	}

	@Override
	public int deletePerson(UUID id) {
		Optional<Person> personOptional = selectPerson(id);
		if (!personOptional.isPresent()) {
			return 0;
		}
		DB.remove(personOptional.get());
		return 1;
	}

	@Override
	public int updatePerson(UUID id, Person personUpdate) {
		return selectPerson(id)
			.map(person -> {
				int indexOfPersonToUpdate = DB.indexOf(person);
				if (indexOfPersonToUpdate >= 0) {
					DB.set(indexOfPersonToUpdate, new Person(id, personUpdate.getName(), personUpdate.getAge()));
					return 1;
				}
				return 0;
			})
			.orElse(0);
	}
}
