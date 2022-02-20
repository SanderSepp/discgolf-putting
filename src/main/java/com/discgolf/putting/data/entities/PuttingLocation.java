package com.discgolf.putting.data.entities;

import javax.persistence.*;

@Entity
@Table(name = "putting_location", uniqueConstraints = {@UniqueConstraint(name = "location_name_unique", columnNames = "name")})
public class PuttingLocation {
    @Id
    @SequenceGenerator(name = "location_sequence", sequenceName = "location_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "location_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
}
