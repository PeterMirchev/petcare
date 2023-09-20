package com.petcare.petcare.petowner.service;
import com.petcare.petcare.petowner.model.PetOwner;
import com.petcare.petcare.petowner.model.PetOwnerExpose;
import com.petcare.petcare.petowner.model.PetOwnerSeed;
import com.petcare.petcare.petowner.repository.PetOwnerRepository;
import com.petcare.petcare.petowner.utilities.PetOwnerMapper;
import org.springframework.stereotype.Service;
import java.util.Collection;

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
    public PetOwnerExpose findById(Long id) {
        return null;
    }

    @Override
    public Collection<PetOwnerExpose> findAll() {
        return null;
    }

    @Override
    public PetOwnerExpose create(PetOwnerSeed petOwnerSeed) {
        PetOwner petOwner = PetOwnerMapper.toPetOwner(petOwnerSeed);
        petOwnerRepository.save(petOwner);
        return PetOwnerMapper.toPetOwnerExpose(petOwner);
    }

    @Override
    public void deleteById(Long id) {

    }
}
