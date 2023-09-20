package com.petcare.petcare.petowner.controller;
import com.petcare.petcare.petowner.model.PetOwnerExpose;
import com.petcare.petcare.petowner.model.PetOwnerSeed;
import com.petcare.petcare.petowner.service.PetOwnerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
