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

    public Person updatePerson(Long id, Person updatedPerson) {
        Person existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + id));

        existing.setName(updatedPerson.getName());
        existing.setEmail(updatedPerson.getEmail());
        existing.setEmployeeId(updatedPerson.getEmployeeId());
        existing.setPosition(updatedPerson.getPosition());
        existing.setDepartment(updatedPerson.getDepartment());

        return repo.save(existing);
    }

    public void deletePerson(Long id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Person not found with id: " + id);
        }
        repo.deleteById(id);
    }

}
