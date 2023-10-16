package com.wakanda.chickeneggs.eggs.application.api;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Value
public class PatchEggsRequest {
    private Integer eggsQuantity;
}
