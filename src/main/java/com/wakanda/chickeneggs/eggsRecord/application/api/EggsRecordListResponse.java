package com.wakanda.chickeneggs.eggsRecord.application.api;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
@Value
public class EggsRecordListResponse {
    private String nameChicken;
    private Integer eggsQuantity;
    private LocalDate hourDateRegistration;



    public static List<EggsRecordListResponse> convert(List<EggsRecord> eggsRecordPerChicken) {
        return eggsRecordPerChicken.stream()
                .map(EggsRecordListResponse::new)
                .collect(Collectors.toList());
    }

    public EggsRecordListResponse(EggsRecord eggsRecord) {
        this.nameChicken = eggsRecord.getChicken().getNameChicken();
        this.eggsQuantity = eggsRecord.getEggsQuantity();
        this.hourDateRegistration = eggsRecord.getHourDateRegistration();

    }
}
