package dev.pedrogomes.guild.repository;

import dev.pedrogomes.guild.entity.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long> {
}
