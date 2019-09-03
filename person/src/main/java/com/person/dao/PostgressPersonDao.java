package com.person.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.person.model.Person;

@Repository("postgressDao")
public class PostgressPersonDao implements PersonDao{

	@Override
	public int insertPerson(UUID id, Person person) {
		return 0;
	}

	@Override
	public List<Person> getPersons() {
		return new ArrayList(){{
			add(new Person(UUID.randomUUID(),"1.From Postgress DB"));
			add(new Person(UUID.randomUUID(),"2.From Postgress DB"));
			}};
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
