package dev.pedrogomes.guild.dto;

import dev.pedrogomes.guild.entity.Members;

public record MembersDTO(String name, String img, String description) {
    public MembersDTO(Members members){
        this( members.getName(), members.getImg(), members.getDescription());
    }
}
