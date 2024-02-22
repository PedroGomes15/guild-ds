package dev.pedrogomes.guild.entity;

import dev.pedrogomes.guild.dto.AchievementDTO;
import dev.pedrogomes.guild.dto.MembersDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "achievement")
@Entity(name = "achievement")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float value;
    private String icon;

    public Achievement(AchievementDTO data) {
        this.name = data.name();
        this.value = data.value();
        this.icon = data.icon();
    }
}
