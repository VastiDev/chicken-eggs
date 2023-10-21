package com.wakanda.chickeneggs.eggsRecord.application.service;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface EggsRepository {
    EggsRecord saveEggs(EggsRecord eggsRecord);

    List<EggsRecord> getEggsPerChickenWithId(UUID idChicken);

    void deleteEggs(EggsRecord eggsRecord);

    List<EggsRecord> getTotalEggsRecords();

    Double getAverageEggsInPeriod(LocalDate startDate, LocalDate endDate);

    EggsRecord getEggsPerId(UUID idEggsRecord);
}
