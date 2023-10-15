package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Value
public class EggsRequest {
    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;

}
