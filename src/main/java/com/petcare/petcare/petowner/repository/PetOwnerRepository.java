package com.petcare.petcare.petowner.repository;
import com.petcare.petcare.pet.model.Pet;
import com.petcare.petcare.petowner.model.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface PetOwnerRepository extends JpaRepository<PetOwner, UUID> {

    @Query("""
            SELECT p FROM PetOwner p
            WHERE p.email = :email
            """)
    PetOwner findPetOwnerByEmail(@Param("email") String email);

    @Query("""
            SELECT p FROM PetOwner p
            WHERE p.firstName = :firstName
            AND p.lastName = :lastName
            """)
    PetOwner findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Modifying
    @Query("""
            UPDATE PetOwner p
            SET p.pets = :pet
            WHERE p.email = :petOwnerEmail
            """)
    PetOwner addPetByEmail(@Param("petOwnerEmail")String petOwnerEmail,@Param("pet") Pet pet);
}
