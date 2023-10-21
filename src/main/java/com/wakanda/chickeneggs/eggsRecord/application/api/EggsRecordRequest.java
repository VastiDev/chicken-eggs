package com.wakanda.chickeneggs.eggsRecord.application.api;

import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Value
public class EggsRecordRequest {
    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;

}