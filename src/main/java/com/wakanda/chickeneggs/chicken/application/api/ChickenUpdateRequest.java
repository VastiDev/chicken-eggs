package com.wakanda.chickeneggs.chicken.application.api;

import lombok.Value;

import java.time.LocalDate;
@Value
public class ChickenUpdateRequest {
    private String nameChicken;
    private LocalDate birthDate;
}
