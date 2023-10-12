package com.wakanda.chickeneggs.chicken.application.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class ChickenListResponse {
    private UUID idChicken;
    private String name;
    private LocalDate birthDate;
    private LocalDateTime hourDateRegistration;
}
