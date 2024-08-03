// Pacote: br.com.erudio.service
package br.com.erudio.services;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;
    public List<Person> findAll() {
        logger.info("Find one person!");
        return repository.findAll();
    }


    public Person findById(Long id) {

    logger.info("Find all persons!");
        Person person =  new Person();
        person.setFirstName("Leandro");
        person.setLastName("Silva");
        person.setAddress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");
        // END MOCK
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found"));

    }

    public Person save(Person person) {
        logger.info("Save person!");
        return repository.save(person);
    }
    public Person update(Person person) {
        logger.info("Update person!");
        Person entity = repository.findById(person.getId()).orElseThrow(()-> new ResourceNotFoundException("Person not found"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }
    public void delete(Long id) {
        logger.info("Delete person!");
        Person entity = repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found"));
        repository.delete(entity);
    }

}