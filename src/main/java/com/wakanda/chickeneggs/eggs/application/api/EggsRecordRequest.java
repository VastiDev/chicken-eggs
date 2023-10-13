package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EggsRecordRequest {
    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;

}
