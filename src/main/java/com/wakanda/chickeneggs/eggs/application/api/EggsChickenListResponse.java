package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class EggsChickenListResponse {
    private String nameChicken;
    @NotNull
    private UUID idEggs;
    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;


    public static List<EggsChickenListResponse> convert(List<Eggs> eggsPerChicken) {
        return eggsPerChicken.stream()
                .map(EggsChickenListResponse::new)
                .collect(Collectors.toList());
    }

    public EggsChickenListResponse(Eggs eggs) {
        this.idEggs = eggs.getIdEggs();
        this.nameChicken = eggs.getChicken().getNameChicken();
        this.eggsQuantity = eggs.getEggsQuantity();
        this.hourDateRegistration = eggs.getHourDateRegistration();
    }
}
