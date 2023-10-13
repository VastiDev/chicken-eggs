package com.wakanda.chickeneggs.chicken.domain;

import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.chicken.application.api.ChickenUpdateRequest;
import com.wakanda.chickeneggs.eggs.domain.DailyEggsRecord;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
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

    @OneToMany(mappedBy = "chicken", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DailyEggsRecord> eggs = new ArrayList<>();

    public Chicken( ChickenRequest chickenrequest) {
        this.name = chickenrequest.getName();
        this.birthDate = chickenrequest.getBirthDate();
        this.hourDateRegistration = LocalDateTime.now();
    }

    public void update(ChickenUpdateRequest chickenUpdaterequest) {
        this.name = chickenUpdaterequest.getName();
        this.birthDate = chickenUpdaterequest.getBirthDate();
        this.hourDateLastChange = LocalDateTime.now();

    }
}
