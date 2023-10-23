package com.wakanda.chickeneggs.eggsRecord.application.api;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@AllArgsConstructor
@Builder
public class EggsRecordRequest {
    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;

}
