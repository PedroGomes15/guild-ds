package dev.pedrogomes.guild.controller;

import dev.pedrogomes.guild.dto.AchievementDTO;
import dev.pedrogomes.guild.dto.MembersDTO;
import dev.pedrogomes.guild.entity.Achievement;
import dev.pedrogomes.guild.entity.Members;
import dev.pedrogomes.guild.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("achievement")
public class AchievementController {

    @Autowired
    private AchievementRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<AchievementDTO> getAll(){
        return repository.findAll().stream().map(AchievementDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void createAchievement(@RequestBody AchievementDTO data){
        Achievement achievementData = new Achievement(data);
        repository.save(achievementData);
    }
}
