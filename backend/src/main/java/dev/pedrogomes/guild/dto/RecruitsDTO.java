package dev.pedrogomes.guild.dto;

import dev.pedrogomes.guild.entity.Members;
import dev.pedrogomes.guild.entity.Recruits;

public record RecruitsDTO(String name, String email, String description) {
    public RecruitsDTO(Recruits members){
        this( members.getName(), members.getEmail(), members.getDescription());
    }
}
