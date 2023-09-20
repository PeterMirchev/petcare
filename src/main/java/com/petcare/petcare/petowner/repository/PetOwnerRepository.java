package com.petcare.petcare.petowner.repository;
import com.petcare.petcare.petowner.model.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, UUID> {


}
