package com.telran.person.controller;

import com.telran.person.dto.PersonDto;
import com.telran.person.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/person")
    @ResponseBody
    public void newPerson(@RequestBody PersonDto personDto) {
        personService.addPerson(personDto);
    }


 @GetMapping("/person")
    @ResponseBody
    public List<PersonDto> getAllPersons(@RequestParam(required = false) String name) {
        if (name != null && !name.equals(""))
            return personService.getAllByName(name);

        return personService.getAll();
    }


    @GetMapping("/person/id")
    @ResponseBody
    public List<PersonDto> getAllById(@RequestParam(required = false) int id) {
        if (id != 0 )
            return personService.getAllById(id);

        return personService.getAll();
    }

    @RequestMapping(value="/person/delete/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete (@PathVariable int id) {
        personService.deleteById(id);
    }


    @GetMapping("/person/age")
    @ResponseBody
    public List<PersonDto> getByAge(@RequestParam(required = false) int age) {
        if (age != 0 )
            return personService.getByAge(age);
        return personService.getAll();
    }


    @GetMapping("/person/age/less")
    @ResponseBody
    public List<PersonDto> getByAgeLess(@RequestParam(required = false) int age) {
        if (age != 0 )
            return personService.getByAgeLess(age);
        return personService.getAll();
    }

    @GetMapping("/person/age/greater")
    @ResponseBody
    public List<PersonDto> getByAgeGreater(@RequestParam(required = false) int age) {
        if (age != 0 )
            return personService.getByAgeGreater(age);

        return personService.getAll();
    }

    @GetMapping("/person/age/greatandless")
    @ResponseBody
    public List<PersonDto> getByAgeLessAndGreater(@RequestParam(required = false) int ageStart, int ageEnd) {
        if (ageStart != 0 && ageEnd != 0)
            return personService.getByAgeGreaterAndLess(ageStart,ageEnd);

        return personService.getAll();
    }

}
