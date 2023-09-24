package com.petcare.petcare.pet.service;
import com.petcare.petcare.pet.model.Pet;
import com.petcare.petcare.pet.model.dto.PetSeed;
import com.petcare.petcare.pet.repository.PetRepository;
import com.petcare.petcare.pet.utilities.PetMapper;
import com.petcare.petcare.petowner.model.PetOwner;
import com.petcare.petcare.petowner.service.PetOwnerService;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {
    private final PetRepository petRepository;
    private final PetOwnerService petOwnerService;

    public PetService(PetRepository petRepository,
                      PetOwnerService petOwnerService) {
        this.petRepository = petRepository;
        this.petOwnerService = petOwnerService;
    }

    public Pet create(PetSeed petSeed) {
        PetOwner petOwner = petOwnerService.findPetOwnerByEmail(petSeed.getOwnerEmail());
        Pet pet = PetMapper.toPet(petSeed, petOwner);
        pet.setPetOwner(petOwner);
        petRepository.save(pet);
        return pet;
    }

    public Pet getById(UUID id) {
        Optional<Pet> byId = petRepository.findById(id);
        return byId.get();
    }
}
