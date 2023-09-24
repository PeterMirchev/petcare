package com.petcare.petcare.pet.controller;
import com.petcare.petcare.pet.model.Pet;
import com.petcare.petcare.pet.model.dto.PetExpose;
import com.petcare.petcare.pet.model.dto.PetSeed;
import com.petcare.petcare.pet.service.PetService;
import com.petcare.petcare.pet.utilities.PetMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public PetExpose create(@Valid @RequestBody PetSeed petSeed) {
        Pet pet = petService.create(petSeed);
        return PetMapper.toPetExpose(pet);
    }

    @GetMapping("/{id}")
    public PetExpose getById(@PathVariable("id") UUID id) {
       Pet pet = petService.getById(id);
       return PetMapper.toPetExpose(pet);
    }
}
