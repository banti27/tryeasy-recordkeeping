package in.tryeasy.recordkeeping.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tryeasy_authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID authorityId;
    private String authorityName;

    @ManyToMany(mappedBy = "authorities")
    @Builder.Default
    private List<User> users = new ArrayList<>();
}
