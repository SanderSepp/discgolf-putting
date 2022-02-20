package com.discgolf.putting.repositories;

import com.discgolf.putting.data.entities.PuttingRound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuttingRoundRepository extends JpaRepository<PuttingRound, Long> {
}
