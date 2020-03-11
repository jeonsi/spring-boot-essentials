package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UUID insertPerson(UUID id, Person person) {
		return null;
	}

	@Override
	public List<Person> selectAllPersons() {
		final String sql = "SELECT id, name, age FROM person";
		return jdbcTemplate.query(sql, (resultSet, i) -> {
			UUID id = UUID.fromString(resultSet.getString("id"));
			String name = resultSet.getString("name");
			int age = resultSet.getInt("age");
			return new Person(id, name, age);
		});
	}

	@Override
	public Optional<Person> selectPerson(UUID id) {
		final String sql = "SELECT id, name, age FROM person WHERE id = ?";

		Person person = jdbcTemplate.queryForObject(
			sql,
			new Object[] {id},
			(resultSet, i) -> {
				UUID personId = UUID.fromString(resultSet.getString("id"));
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				return new Person(personId, name, age);
			});

		return Optional.ofNullable(person);
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
