package com.petcare.petcare.petowner.service;
import com.petcare.petcare.ExceptionMessages;
import com.petcare.petcare.NonExistingEntityException;
import com.petcare.petcare.petowner.model.PetOwner;
import com.petcare.petcare.petowner.model.PetOwnerExpose;
import com.petcare.petcare.petowner.model.PetOwnerSeed;
import com.petcare.petcare.petowner.repository.PetOwnerRepository;
import com.petcare.petcare.petowner.utilities.PetOwnerMapper;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PetOwnerServiceImpl implements PetOwnerService{

    private final PetOwnerRepository petOwnerRepository;

    public PetOwnerServiceImpl(PetOwnerRepository petOwnerRepository) {
        this.petOwnerRepository = petOwnerRepository;
    }

    @Override
    public long count() {
        return petOwnerRepository.count();
    }

    @Override
    public PetOwnerExpose findById(UUID id) {
        PetOwner petOwner = petOwnerRepository.findById(id)
                .orElseThrow(() -> new NonExistingEntityException(String.format(ExceptionMessages.CASH_RECEIPT_DOES_NOT_EXIST, id)));
        return PetOwnerMapper.toPetOwnerExpose(petOwner);
    }

    @Override
    public PetOwner findPetOwnerByEmail(String email) {
        return petOwnerRepository.findPetOwnerByEmail(email);
    }

    @Override
    public PetOwnerExpose findByFirstNameAndLastName(String firstName, String lastName) {
        PetOwner petOwner = petOwnerRepository.findByFirstNameAndLastName(firstName, lastName);
        return PetOwnerMapper.toPetOwnerExpose(petOwner);
    }

    @Override
    public Collection<PetOwnerExpose> findAll() {
        return petOwnerRepository.findAll()
                .stream()
                .map(PetOwnerMapper::toPetOwnerExpose)
                .collect(Collectors.toList());
    }

    @Override
    public PetOwnerExpose create(PetOwnerSeed petOwnerSeed) {
        PetOwner petOwner = PetOwnerMapper.toPetOwner(petOwnerSeed);
        petOwnerRepository.save(petOwner);
        return PetOwnerMapper.toPetOwnerExpose(petOwner);
    }

    @Override
    public PetOwnerExpose addPetByEmail(String petOwnerEmail, String petId) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
