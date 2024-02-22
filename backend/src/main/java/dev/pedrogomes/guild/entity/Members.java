package dev.pedrogomes.guild.entity;

import dev.pedrogomes.guild.dto.MembersDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "members")
@Entity(name = "members")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Members {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String img;
    private String description;

    public Members(MembersDTO data) {
        this.name = data.name();
        this.description = data.description();
        this.img = data.img();
    }
}
