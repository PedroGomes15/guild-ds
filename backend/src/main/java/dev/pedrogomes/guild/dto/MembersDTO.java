package dev.pedrogomes.guild.dto;

import dev.pedrogomes.guild.entity.Members;

public record MembersDTO(String name, String description, String img, String id) {
    public MembersDTO(Members members) {
        this(members.getName(), members.getDescription(), members.getImg(), members.getId().toString());
    }
}
