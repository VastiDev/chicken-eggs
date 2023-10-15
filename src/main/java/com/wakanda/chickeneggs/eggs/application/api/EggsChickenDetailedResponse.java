package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class EggsChickenDetailedResponse {
    private UUID idEggs;
    private String nameChicken;
    private Integer eggsQuantity;
    private LocalDate hourDateRegistration;


    public EggsChickenDetailedResponse(Eggs eggs) {
        this.idEggs = eggs.getIdEggs();
        this.nameChicken = eggs.getChicken().getNameChicken();
        this.eggsQuantity =eggs.getEggsQuantity();
        this.hourDateRegistration = eggs.getHourDateRegistration();
    }

}

