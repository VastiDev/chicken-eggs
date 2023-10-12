package com.wakanda.chickeneggs.chicken.application.api;

import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class ChickenDetailedResponse {
    private UUID idChicken;
    private String name;
    private LocalDate birthDate;
    private LocalDateTime hourDateRegistration;
}
