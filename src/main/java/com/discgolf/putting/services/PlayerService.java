package com.discgolf.putting.services;

import com.discgolf.putting.data.dtos.PlayerDto;
import com.discgolf.putting.data.entities.Player;
import com.discgolf.putting.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player savePlayer(PlayerDto playerDto) {
        Player player = Player.builder()
                .firstName(playerDto.getFirstName())
                .lastName(playerDto.getLastName())
                .email(playerDto.getEmail())
                .age(playerDto.getAge())
                .build();
        return playerRepository.save(player);
    }
}
