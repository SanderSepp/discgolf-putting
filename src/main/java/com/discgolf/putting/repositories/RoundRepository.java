package com.discgolf.putting.repositories;

import com.discgolf.putting.data.entities.PuttingRound;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoundRepository extends CrudRepository<PuttingRound, Long> {

}
