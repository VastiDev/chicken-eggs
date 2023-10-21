package com.wakanda.chickeneggs.eggsRecord.application.api;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import lombok.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ListTotalEggsRecords {
    private String nameChicken;
    private Integer eggsQuantity;
    private LocalDate hourDateRegistration;



    public ListTotalEggsRecords(EggsRecord eggsRecord) {
        this.nameChicken = eggsRecord.getChicken().getNameChicken();
        this.eggsQuantity = eggsRecord.getEggsQuantity();
        this.hourDateRegistration = eggsRecord.getHourDateRegistration();
    }

    public static List<ListTotalEggsRecords> convert(List<EggsRecord> totalRecords) {
        return totalRecords.stream()
                .map(ListTotalEggsRecords::new)
                .collect(Collectors.toList());
    }

}
