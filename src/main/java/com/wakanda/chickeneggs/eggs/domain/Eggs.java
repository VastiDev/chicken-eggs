package com.wakanda.chickeneggs.eggs.domain;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import com.wakanda.chickeneggs.eggs.application.api.EggsRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor (access = AccessLevel.PUBLIC)
public class Eggs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idEggs", updatable = false, unique = true, nullable = false)
    private UUID idEggs;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idChickenLay", referencedColumnName = "idChicken", nullable = false, insertable = false, updatable = false)
    private Chicken chicken;

    @NotNull
    @Column(columnDefinition = "uuid", name = "idChickenLay", updatable = false, unique = true, nullable = false)
    private UUID idChickenLay;

    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;


    public Eggs(UUID idChicken, EggsRequest eggsRequest) {
        this.idChickenLay = idChicken;
        this.eggsQuantity = eggsRequest.getEggsQuantity();
        this.hourDateRegistration = eggsRequest.getHourDateRegistration();
    }


    public void addEggs(int additionalEggs) {
        if(additionalEggs < 0) {
            throw new IllegalArgumentException("Cannot add negative number of eggs");
        }
        this.eggsQuantity += additionalEggs;
    }

}
