package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EggsChickenDetailsResponse {
    private String nameChicken;
    private UUID idEggs;
    private Integer eggsQuantity;
    private LocalDate hourDateRegistration;


    public EggsChickenDetailsResponse(Eggs eggs) {
        this.idEggs = eggs.getIdEggs();
        this.nameChicken = eggs.getChicken().getNameChicken();
        this.eggsQuantity = eggs.getEggsQuantity();
        this.hourDateRegistration = eggs.getHourDateRegistration();
    }
}
