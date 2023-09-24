package com.petcare.petcare.petowner.controller;
import com.petcare.petcare.petowner.model.PetOwner;
import com.petcare.petcare.petowner.model.PetOwnerExpose;
import com.petcare.petcare.petowner.model.PetOwnerSeed;
import com.petcare.petcare.petowner.service.PetOwnerService;
import com.petcare.petcare.petowner.utilities.PetOwnerMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pet-owners")
public class PetOwnerController {

    private final PetOwnerService petOwnerService;

    public PetOwnerController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @PostMapping
    public PetOwnerExpose create(@Valid @RequestBody PetOwnerSeed petOwnerSeed) {
        return petOwnerService.create(petOwnerSeed);
    }

    @GetMapping("/{id}")
    public PetOwnerExpose findById(@PathVariable("id") UUID id) {
        return petOwnerService.findById(id);
    }

    @GetMapping("/email/{email}")
    public PetOwnerExpose findPetOwnerByEmail(@PathVariable String email) {
        PetOwner petOwner = petOwnerService.findPetOwnerByEmail(email);
        return PetOwnerMapper.toPetOwnerExpose(petOwner);
    }

    @GetMapping("/names")//http://localhost:8080/pet-owners/names?firstName=Gogo&lastName=Owners
    public PetOwnerExpose findByFirstNameAndLastName(@RequestParam String firstName,
                                                     @RequestParam String lastName) {
        return petOwnerService.findByFirstNameAndLastName(firstName, lastName);
    }



}
