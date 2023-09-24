package com.petcare.petcare.pet.model.dto;
import com.petcare.petcare.cashreceipt.model.CashReceipt;
import com.petcare.petcare.pet.enums.PetType;
import com.petcare.petcare.petowner.model.PetOwner;
import lombok.Builder;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class PetExpose {
    private UUID id;
    private String name;
    private PetType petType;
    private String petOwnerFirstName;
    private String petOwnerLastName;
    private String petOwnerEmail;
    private String petOwnerId;
    private List<CashReceipt> cashReceipList;
}
