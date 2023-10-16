package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Value
public class EggsRecordListResponse {
    @NotNull
    private Integer eggsQuantity;
    @NotNull
    private LocalDate hourDateRegistration;



    public static List<EggsRecordListResponse> convert(Optional<Eggs> eggsRecord) {
        return eggsRecord.stream()
                .map(EggsRecordListResponse::new)
                .collect(Collectors.toList());
    }

    public EggsRecordListResponse(Eggs eggs) {
        this.eggsQuantity = eggs.getEggsQuantity();
        this.hourDateRegistration = eggs.getHourDateRegistration();

    }
}
