package dev.pedrogomes.guild.dto;

import dev.pedrogomes.guild.entity.Achievement;

public record AchievementDTO(String name, float value, String icon) {

    public AchievementDTO(Achievement achievement){this(achievement.getName(), achievement.getValue(), achievement.getIcon());}
}
