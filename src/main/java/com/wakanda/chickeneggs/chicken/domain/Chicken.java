package com.wakanda.chickeneggs.chicken.domain;

import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;



@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class Chicken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name= "idChicken", updatable = false, unique = true, nullable = false)
    private UUID idChicken;
    @NotBlank
    private String name;
    @NotNull
    private LocalDate birthDate;

    private LocalDateTime hourDateRegistration;
    private LocalDateTime hourDateLastChange;


    public Chicken(ChickenRequest chickenrequest) {
        this.name = chickenrequest.getName();
        this.birthDate = chickenrequest.getBirthDate();
        this.hourDateRegistration = LocalDateTime.now();
    }
}
