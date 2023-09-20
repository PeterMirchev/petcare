package com.petcare.petcare.pet.model;
import com.petcare.petcare.cashreceipt.model.CashReceipt;
import com.petcare.petcare.pet.enums.PetType;
import com.petcare.petcare.petowner.model.PetOwner;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pets")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Size(min = 2)
    @NonNull
    private String name;
    @NonNull
    @Enumerated
    private PetType petType;
    @NonNull
    @ManyToOne
    private PetOwner petOwner;
    @OneToMany
    private List<CashReceipt> cashReceipList;


}
