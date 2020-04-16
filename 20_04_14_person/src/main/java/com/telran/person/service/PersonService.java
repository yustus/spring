package com.telran.person.service;

import com.telran.person.dto.PersonDto;
import com.telran.person.model.Person;
import com.telran.person.persistence.IPersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    final IPersonRepository personRepository;


    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void addPerson(PersonDto personDto) {
        Person person = new Person(personDto.firstName, personDto.lastName, personDto.age);
        personRepository.save(person);
    }

    public List<PersonDto> getAll() {
        Iterable<Person> persons = personRepository.findAll();
        List<PersonDto> personsOut = new ArrayList<>();

        for (Person person : persons) {
            personsOut.add(
                    new PersonDto(person.getId(),
                            person.getName(),
                            person.getLastName(),
                            person.getAge()));
        }
        return personsOut;
    }

    public List<PersonDto> getAllByName(String name) {
        Iterable<Person> persons = personRepository.findByName(name);
        List<PersonDto> personsOut = new ArrayList<>();

        for (Person person : persons) {
            personsOut.add(
                    new PersonDto(person.getId(),
                            person.getName(),
                            person.getLastName(),
                            person.getAge()));
        }
        return personsOut;
    }


    public List<PersonDto> getAllById(int id) {
        Iterable<Person> persons = personRepository.findById(id);
        List<PersonDto> personsOut = new ArrayList<>();

        for (Person person : persons) {
            personsOut.add(
                    new PersonDto(person.getId(),
                            person.getName(),
                            person.getLastName(),
                            person.getAge()));
        }
        return personsOut;
    }


    public void deleteById(int id) {
       personRepository.deleteById(id);
    }


    public List<PersonDto> getByAge(int age) {
        Iterable<Person> persons = personRepository.findByAge(age);
        List<PersonDto> personsOut = new ArrayList<>();

        for (Person person : persons) {
            personsOut.add(
                    new PersonDto(person.getId(),
                            person.getName(),
                            person.getLastName(),
                            person.getAge()));
        }
        return personsOut;
    }

    public List<PersonDto> getByAgeLess(int age) {
        Iterable<Person> persons = personRepository.findByAgeLessThan(age);
        List<PersonDto> personsOut = new ArrayList<>();

        for (Person person : persons) {
            personsOut.add(
                    new PersonDto(person.getId(),
                            person.getName(),
                            person.getLastName(),
                            person.getAge()));
        }
        return personsOut;
    }

    public List<PersonDto> getByAgeGreater(int age) {
        Iterable<Person> persons = personRepository.findByAgeGreaterThan(age);
        List<PersonDto> personsOut = new ArrayList<>();

        for (Person person : persons) {
            personsOut.add(
                    new PersonDto(person.getId(),
                            person.getName(),
                            person.getLastName(),
                            person.getAge()));
        }
        return personsOut;
    }


    public List<PersonDto> getByAgeGreaterAndLess(int ageStart, int ageEnd) {
        Iterable<Person> persons = personRepository.findByAgeGreaterThanAndAgeLessThan(ageStart, ageEnd);
        List<PersonDto> personsOut = new ArrayList<>();

        for (Person person : persons) {
            personsOut.add(
                    new PersonDto(person.getId(),
                            person.getName(),
                            person.getLastName(),
                            person.getAge()));
        }
        return personsOut;
    }

}
