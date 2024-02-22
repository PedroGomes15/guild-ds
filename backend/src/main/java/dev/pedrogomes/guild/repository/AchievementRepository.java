package dev.pedrogomes.guild.repository;

import dev.pedrogomes.guild.entity.Achievement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
}
