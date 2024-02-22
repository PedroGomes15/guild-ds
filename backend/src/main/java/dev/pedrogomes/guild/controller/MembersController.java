package dev.pedrogomes.guild.controller;

import dev.pedrogomes.guild.dto.MembersDTO;
import dev.pedrogomes.guild.entity.Members;
import dev.pedrogomes.guild.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("members")
public class MembersController {

    @Autowired
    private MembersRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MembersDTO> getAll(){
        return repository.findAll().stream().map(MembersDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createMember(@RequestBody MembersDTO data){
        Members memberData = new Members(data);
        repository.save(memberData);
    }
}
