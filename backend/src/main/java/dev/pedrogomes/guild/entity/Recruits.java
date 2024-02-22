package dev.pedrogomes.guild.entity;


import dev.pedrogomes.guild.dto.MembersDTO;
import dev.pedrogomes.guild.dto.RecruitsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "recruits")
@Entity(name = "recruits")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Recruits {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String description;
    //todo classe

    public Recruits(RecruitsDTO data) {
        this.name = data.name();
        this.email = data.email();
        this.description = data.description();
    }
}
