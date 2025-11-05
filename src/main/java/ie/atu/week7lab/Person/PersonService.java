package ie.atu.week7lab.Person;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRespository repo;
    public PersonService(PersonRespository repo){this.repo = repo;}

    public Person create(Person p) {return repo.save(p);}
    public List<Person> findAll() {return repo.findAll();}

    public Person findByEmployeeId(String id){
        return repo.findByEmployeeId(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found"));
    }
}
