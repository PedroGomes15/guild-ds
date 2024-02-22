package dev.pedrogomes.guild.dto;

import dev.pedrogomes.guild.entity.Missions;
import dev.pedrogomes.guild.utils.enums.DifficultEnum;
import dev.pedrogomes.guild.utils.enums.StatusEnum;

public record MissionsDTO(String name, float reward, DifficultEnum difficult, String requestBy, StatusEnum status,
                          String feedback) {

    public MissionsDTO(Missions missions) {
        this(missions.getName(), missions.getReward(), missions.getDifficult(), missions.getRequestBy(), missions.getStatus(), missions.getFeedback());
    }
}
