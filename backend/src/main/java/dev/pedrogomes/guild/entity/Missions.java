package dev.pedrogomes.guild.entity;

import dev.pedrogomes.guild.dto.MissionsDTO;
import dev.pedrogomes.guild.utils.enums.DifficultEnum;
import dev.pedrogomes.guild.utils.enums.StatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "missions")
@Entity(name = "missions")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Missions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float reward;
    private DifficultEnum difficult = DifficultEnum.EASY;
    private String requestBy;
    private StatusEnum status = StatusEnum.CREATED;
    private String feedback;

    public Missions(MissionsDTO data) {
        this.name = data.name();
        this.reward = data.reward();
        this.difficult = data.difficult();
        this.requestBy = data.requestBy();
        this.status = data.status();
        this.feedback = data.feedback();
    }
}

