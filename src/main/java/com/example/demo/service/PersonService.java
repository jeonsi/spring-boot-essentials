package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PersonDao;
import com.example.demo.model.Person;

@Service	// same as @Component
public class PersonService {

	private final PersonDao personDao;

	@Autowired	// Dependency Injection, @Qualifier specifies "fakeDao" bean
	public PersonService(@Qualifier("postgres") PersonDao personDao) {
		this.personDao = personDao;
	}

	public List<Person> getAllPersons() {
		return personDao.selectAllPersons();
	}

	public UUID addPerson(Person person) {
		return personDao.insertPerson(person);
	}

	public Optional<Person> getPerson(UUID personId) {
		return personDao.selectPerson(personId);
	}

	public void deletePerson(UUID personId) {
		personDao.deletePerson(personId);
	}

	public void updatePerson(UUID personId, Person person) {
		personDao.updatePerson(personId, person);
	}
}
