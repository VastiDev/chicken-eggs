package com.wakanda.chickeneggs.chicken.application.api;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ChickenListResponse {
    private UUID idChicken;
    private String name;
    private LocalDate birthDate;
    private LocalDateTime hourDateRegistration;

    public static List<ChickenListResponse> convert(List<Chicken> chickens) {
        return chickens.stream()
                .map(ChickenListResponse::new)
                .collect(Collectors.toList());
    }

    public ChickenListResponse(Chicken chicken) {
        this.idChicken = chicken.getIdChicken();
        this.name = chicken.getName();
        this.birthDate = chicken.getBirthDate();
        this.hourDateRegistration = chicken.getHourDateRegistration();
    }
}
