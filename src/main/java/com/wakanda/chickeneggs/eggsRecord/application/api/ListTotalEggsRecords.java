package com.wakanda.chickeneggs.eggsRecord.application.api;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import lombok.Value;

import java.util.List;
import java.util.stream.Collectors;

@Value
public class ListTotalEggsRecords {
    private Integer eggsQuantity;

    public ListTotalEggsRecords(EggsRecord eggsRecord) {
        this.eggsQuantity = eggsRecord.getEggsQuantity();
    }

    public static List<ListTotalEggsRecords> convert(List<EggsRecord> totalRecords) {
        return totalRecords.stream()
                .map(ListTotalEggsRecords::new)
                .collect(Collectors.toList());
    }

}
