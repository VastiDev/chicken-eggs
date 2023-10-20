package com.wakanda.chickeneggs.eggsRecord.application.api;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;
@Value
public class EggsRecordListResponse {
    private Integer eggsQuantity;


    public static List<EggsRecordListResponse> convert(List<EggsRecord> eggsRecordPerChicken) {
        return eggsRecordPerChicken.stream()
                .map(EggsRecordListResponse::new)
                .collect(Collectors.toList());
    }

    public EggsRecordListResponse(EggsRecord eggsRecord) {
        this.eggsQuantity = eggsRecord.getEggsQuantity();

    }
}
