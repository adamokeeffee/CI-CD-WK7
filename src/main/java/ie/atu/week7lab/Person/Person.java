package ie.atu.week7lab.Person;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "persons")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String employeeId;
    private String position;
    private String department;
}
