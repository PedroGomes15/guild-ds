package dev.pedrogomes.guild.repository;

import dev.pedrogomes.guild.entity.Missions;
import dev.pedrogomes.guild.utils.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MissionsRepository  extends JpaRepository<Missions, Long> {

    List<Missions> findByStatusAndFeedbackIsNotNull(StatusEnum status);
}
