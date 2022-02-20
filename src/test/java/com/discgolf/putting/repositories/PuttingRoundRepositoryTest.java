package com.discgolf.putting.repositories;

import com.discgolf.putting.data.entities.Player;
import com.discgolf.putting.data.entities.PuttingRound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class PuttingRoundRepositoryTest {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PuttingRoundRepository repository;

    @Test
    //@Transactional
    public void savePuttingRound() {

        Optional<Player> player = playerRepository.findById(1L);

        PuttingRound puttingRound = PuttingRound.builder()
                .distance(10.0)
                .madePutts(5)
                .missedPutts(0)
                .totalPutts(5)
                .player(player.orElse(null))
                //.puttingGame(null)
                .build();

        repository.save(puttingRound);
    }
    
    @Test
    public void printAllPuttingRounds() {
        List<PuttingRound> rounds = repository.findAll();
        System.out.println(rounds);
    }
}