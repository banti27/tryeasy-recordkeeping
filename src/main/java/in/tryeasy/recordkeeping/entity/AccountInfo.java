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
@Table(name = "TRYEASY_ACCOUNT_INFO")
public class AccountInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID accountInfoId;

    private String cardNumber;
    private String cardHolderName;
    private String upiId;

}
