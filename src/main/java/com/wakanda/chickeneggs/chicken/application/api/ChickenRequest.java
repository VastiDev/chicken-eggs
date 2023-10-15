package com.wakanda.chickeneggs.chicken.application.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Value
public class ChickenRequest {
    @NotBlank
    private String nameChicken;
    @NotNull
    private LocalDate birthDate;

}
