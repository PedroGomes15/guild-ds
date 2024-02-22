package dev.pedrogomes.guild.controller;

import dev.pedrogomes.guild.dto.RecruitsDTO;
import dev.pedrogomes.guild.entity.Recruits;
import dev.pedrogomes.guild.repository.RecruitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("recruits")
public class RecruitsController {

    @Autowired
    private RecruitsRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<RecruitsDTO> getAll(){
        return repository.findAll().stream().map(RecruitsDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createRecruits(@RequestBody RecruitsDTO data){
        Recruits recruitsData = new Recruits(data);
        repository.save(recruitsData);
    }
}
