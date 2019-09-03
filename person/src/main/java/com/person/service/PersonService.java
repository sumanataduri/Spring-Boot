package com.person.service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.person.dao.PersonDao;
import com.person.model.Person;

@Service
public class PersonService {

	
	private final PersonDao personDao;
	@Autowired
	public PersonService(@Qualifier("postgressDao") PersonDao personDao) {
		this.personDao = personDao;
	}
	
	public int addPerson(Person person){
		return personDao.insertPerson(person);
	}

	public Collection<Person> getPersons() {
		return this.personDao.getPersons();
		
	}
	
	public Optional<Person> getPersonById(UUID id){
		return this.personDao.selectPersonById(id);
	}
	
	public int deletePerson(UUID id){
		return personDao.deletePersonById(id);
	}
	
	public int updatePerson(UUID id, Person newperson){
		return personDao.updatePersonById(id,newperson);
	}
	
}
