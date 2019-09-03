package com.person.api;

import java.util.Collection;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.person.model.Person;
import com.person.service.PersonService;

@RequestMapping("api/person")
@RestController
public class PersonController {
	
	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}
	
	@PostMapping
	public void addPerson(@Valid @NotNull @RequestBody Person person){
		this.personService.addPerson(person);
	}
	
	@GetMapping
	public Collection<Person> getPersons(){
		return this.personService.getPersons();
	}
	
	@GetMapping(path = "{id}")
	public Person getPersonById(@PathVariable("id") UUID id){
		return this.personService.getPersonById(id)
				.orElse(null);
	}
	
	@DeleteMapping(path = "{id}")
	public void deletePersonById(@PathVariable("id") UUID id){
		personService.deletePerson(id);
	}
	
	@PutMapping(path = "{id}")
	public void updatePersonById(@PathVariable("id") UUID id, @Valid @NotNull @RequestBody Person person){
		this.personService.updatePerson(id, person);
	}
}
