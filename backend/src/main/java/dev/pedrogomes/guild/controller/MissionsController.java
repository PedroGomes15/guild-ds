package dev.pedrogomes.guild.controller;

import dev.pedrogomes.guild.dto.MembersDTO;
import dev.pedrogomes.guild.dto.MissionsDTO;
import dev.pedrogomes.guild.entity.Members;
import dev.pedrogomes.guild.entity.Missions;
import dev.pedrogomes.guild.repository.MissionsRepository;
import dev.pedrogomes.guild.utils.enums.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("missions")
public class MissionsController {

    @Autowired
    private MissionsRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MissionsDTO> getAll(){
        return repository.findAll().stream().map(MissionsDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/done")
    public List<MissionsDTO> getDone(){
        return repository.findByStatusAndFeedbackIsNotNull(StatusEnum.DONE).stream().map(MissionsDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createMissions(@RequestBody MissionsDTO data){
        Missions missionData = new Missions(data);
        repository.save(missionData);
    }
}
