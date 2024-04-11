// Pacote: br.com.erudio.service
package br.com.erudio.services;

import br.com.erudio.model.Person;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());
    public Person findById(String id) {
        logger.info("Find one person!") ;
        Person person =  new Person();
        //MOCK
        person. setId(counter.incrementAndGet());
        person.setFirstName("Leandro");
        person.setLastName("Silva");
        person.setAddress("Uberlândia - Minas Gerais - Brasil");
        person.setGender("Male");
        // END MOCK
        return person;
    }
}