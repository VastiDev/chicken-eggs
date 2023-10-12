package com.wakanda.chickeneggs.chicken.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@EntityListeners({Chicken.class})
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Chicken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name= "id", updatable = false, unique = true, nullable = false)
    private UUID idChicken;
    @NotBlank
    private String name;
    @NotNull
    private LocalDate birthDate;


    private LocalDateTime hourDateRegistration;
    private LocalDateTime hourDateLastChange;

    public Chicken( String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.hourDateRegistration = LocalDateTime.now();

    }
}
