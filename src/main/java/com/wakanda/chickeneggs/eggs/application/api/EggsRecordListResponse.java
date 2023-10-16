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
    private Integer eggsQuantity;


    public static List<EggsRecordListResponse> convert(List<Eggs> eggsPerChicken) {
        return eggsPerChicken.stream()
                .map(EggsRecordListResponse::new)
                .collect(Collectors.toList());
    }

    public EggsRecordListResponse(Eggs eggs) {
        this.eggsQuantity = eggs.getEggsQuantity();

    }
}
