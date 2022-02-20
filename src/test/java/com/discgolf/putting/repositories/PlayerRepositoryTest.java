package com.discgolf.putting.repositories;

import com.discgolf.putting.data.entities.PdgaData;
import com.discgolf.putting.data.entities.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PlayerRepositoryTest {
    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void savePlayer() {
        PdgaData pdgaData = PdgaData.builder()
                .pdgaNumber(123322)
                .rating(932)
                .build();

        Player player = Player.builder()
                .email("Holger.Part@gmail.com")
                .firstName("Holger")
                .lastName("Part")
                .age(30)
                .pdgaData(pdgaData)
                .build();
        playerRepository.save(player);
    }

    @Test
    public void findPlayersByFirstName() {
        List<Player> players = playerRepository.findByFirstName("Sander");
        System.out.println(players);
    }

    @Test
    public void findPlayerByEmail() {
        Player players = playerRepository.getPlayerByEmailAddress("sepp1300@gmail.com");
        System.out.println(players);
    }

    @Test
    public void findPlayerByFirstNameContaining() {
        List<Player> players = playerRepository.findByFirstNameContaining("a");
        System.out.println(players);
    }

    @Test
    public void findPlayerByPdgaNumber() {
        List<Player> players = playerRepository.findByPdgaDataPdgaNumber(123322);
        System.out.println(players);
    }

    @Test
    public void getPlayerFirstNameByEmailAddress() {
        String firstName = playerRepository.getPlayerFirstNameByEmailAddress("sepp1300@gmail.com");
        System.out.println(firstName);
    }

    @Test
    public void getPlayerByEmailAddressNative() {
        Player player = playerRepository.getPlayerByEmailAddressNative("sepp1300@gmail.com");
        System.out.println(player);
    }

    @Test
    public void getPlayerByEmailAddressNativeNamedParam() {
        Player player = playerRepository.getPlayerByEmailAddressNativeNamedParam("sepp1300@gmail.com");
        System.out.println(player);
    }

    @Test
    public void updatePlayerFirstNameByEmail() {
        int id = playerRepository.updatePlayerFirstNameByEmail("sander", "sepp1300@gmail.com");
        System.out.println(id);
    }
}