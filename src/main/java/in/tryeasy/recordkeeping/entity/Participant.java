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
@Table(name = "TRYEASY_PARTICIPANT")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID participantId;

    private String orgName;

    private String participantName;

    @Enumerated(EnumType.STRING)
    private Gender gender;
}
