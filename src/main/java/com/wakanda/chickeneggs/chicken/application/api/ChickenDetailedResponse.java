package com.wakanda.chickeneggs.chicken.application.api;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ChickenDetailedResponse {
    private UUID idChicken;
    private String nameChicken;
    private LocalDate birthDate;

    private int eggsTotalQuantity;

    public ChickenDetailedResponse(Chicken chicken, int eggsTotal) {
        this.idChicken = chicken.getIdChicken();
        this.nameChicken = chicken.getNameChicken();
        this.birthDate =chicken.getBirthDate();

        this.eggsTotalQuantity = eggsTotal;
    }
}
