package com.person.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import com.person.model.Person;


public interface PersonDao {

	int insertPerson(UUID id,Person person);
	
	default int insertPerson(Person person)
	{
		UUID id = UUID.randomUUID();
		return insertPerson(id,person);
	}

	Collection<Person> getPersons();
	
	Optional<Person> selectPersonById(UUID id);
	
	int deletePersonById(UUID id);
	
	int updatePersonById(UUID id, Person person);
	
	
}
