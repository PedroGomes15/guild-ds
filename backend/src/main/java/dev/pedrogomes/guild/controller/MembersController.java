package dev.pedrogomes.guild.controller;

import dev.pedrogomes.guild.dto.MembersDTO;
import dev.pedrogomes.guild.entity.Members;
import dev.pedrogomes.guild.repository.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Long createMember(@RequestBody MembersDTO data){
        Members memberData = repository.save(new Members(data));
        return memberData.getId();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping
    public void deleteMember(@RequestParam String id){
        repository.deleteById(Long.parseLong(id));
    }
}
