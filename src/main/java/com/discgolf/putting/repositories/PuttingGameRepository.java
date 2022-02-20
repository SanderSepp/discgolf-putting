package com.discgolf.putting.repositories;

import com.discgolf.putting.data.entities.PuttingGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PuttingGameRepository extends JpaRepository<PuttingGame, Long> {
}
