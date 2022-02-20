package com.discgolf.putting.repositories;

import com.discgolf.putting.data.entities.Player;
import com.discgolf.putting.data.entities.PuttingGame;
import com.discgolf.putting.data.entities.PuttingRound;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PuttingGameRepositoryTest {
    @Autowired
    private PuttingGameRepository repository;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void printPuttingGames() {
        List<PuttingGame> games = repository.findAll();
        System.out.println(games);
    }

    @Test
    public void savePuttingRound() {
        Optional<Player> player = playerRepository.findById(1L);

        PuttingRound puttingRound = PuttingRound.builder()
                .distance(10.0)
                .madePutts(5)
                .missedPutts(0)
                .totalPutts(5)
                .player(player.orElse(null))
                .build();

        PuttingRound puttingRound2 = PuttingRound.builder()
                .distance(10.0)
                .madePutts(4)
                .missedPutts(1)
                .totalPutts(5)
                //.player(player.orElse(null))
                .build();

        PuttingGame game = PuttingGame.builder()
                .name("Game 2")
                .type("BASIC")
                .rounds(List.of(puttingRound, puttingRound2))
                .build();

        repository.save(game);
    }
}