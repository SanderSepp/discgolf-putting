package com.discgolf.putting.data.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Player")
@Table(name = "player", uniqueConstraints = {@UniqueConstraint(name = "customer_email_unique", columnNames = "email")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    @Column(name = "id", updatable = false)
    private Long id;
    @Column(name = "first_name", columnDefinition = "TEXT", nullable = false)
    private String firstName;
    @Column(name = "last_name", columnDefinition = "TEXT", nullable = false)
    private String lastName;
    @Column(name = "email", columnDefinition = "TEXT", nullable = false)
    private String email;
    @Column(name = "age")
    private Integer age;
    @Embedded
    private PdgaData pdgaData;

    public Player(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
}
