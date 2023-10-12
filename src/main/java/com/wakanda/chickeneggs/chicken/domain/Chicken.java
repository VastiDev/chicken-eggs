package com.wakanda.chickeneggs.chicken.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Chicken {

    @Id
    private UUID idChicken;
    @NotBlank
    private String name;
    @NotNull
    private LocalDate birthDate;


    private LocalDateTime hourDateRegistration;
    private LocalDateTime hourDateLastChange;

    public Chicken(UUID idChicken, String name, LocalDate birthDate) {
        this.idChicken = UUID.randomUUID();
        this.name = name;
        this.birthDate = birthDate;
        this.hourDateRegistration = LocalDateTime.now();

    }
}
