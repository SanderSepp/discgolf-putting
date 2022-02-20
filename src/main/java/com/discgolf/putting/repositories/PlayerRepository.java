package com.discgolf.putting.repositories;

import com.discgolf.putting.data.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByFirstName(String firstName);
    List<Player> findByFirstNameContaining(String firstName);
    List<Player> findByPdgaDataPdgaNumber(Integer pdgaNumber);

    @Query("select p from Player p where p.email = ?1")
    Player getPlayerByEmailAddress(String email);

    @Query(value = "select * from player p where p.email = :email", nativeQuery = true)
    Player getPlayerByEmailAddressNativeNamedParam(@Param("email") String email);

    @Modifying
    @Transactional
    @Query(value = "update player set first_name = ?1 where email = ?2", nativeQuery = true)
    int updatePlayerFirstNameByEmail(String firstName, String email);
}
