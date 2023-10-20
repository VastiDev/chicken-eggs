package com.wakanda.chickeneggs.eggsRecord.application.api;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class EggsChickenDetailsResponse {
    private String nameChicken;
    private UUID idEggs;
    private Integer eggsQuantity;
    private LocalDate hourDateRegistration;


    public EggsChickenDetailsResponse(EggsRecord eggsRecord) {
        this.idEggs = eggsRecord.getIdEggsRecord();
        this.nameChicken = eggsRecord.getChicken().getNameChicken();
        this.eggsQuantity = eggsRecord.getEggsQuantity();
        this.hourDateRegistration = eggsRecord.getHourDateRegistration();
    }
}
