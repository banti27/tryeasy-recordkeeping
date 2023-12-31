package in.tryeasy.recordkeeping.entity;

import in.tryeasy.recordkeeping.constant.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRYEASY_EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID employeeId;

    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
