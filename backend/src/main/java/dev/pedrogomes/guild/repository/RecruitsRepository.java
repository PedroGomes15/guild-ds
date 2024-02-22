package dev.pedrogomes.guild.repository;

import dev.pedrogomes.guild.entity.Members;
import dev.pedrogomes.guild.entity.Recruits;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruitsRepository extends JpaRepository<Recruits, Long> {
}
