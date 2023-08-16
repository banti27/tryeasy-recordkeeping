package in.tryeasy.recordkeeping.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TRYEASY_ORGANIZATION")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID orgId;

    private String orgName;
    private String street1;
    private String street2;
    private String street3;
    private String city;
    private String zipcode;
    private String state;
    private String country;
}
