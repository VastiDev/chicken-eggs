package com.wakanda.chickeneggs.eggsRecord.application.service;

import com.wakanda.chickeneggs.eggsRecord.application.api.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


public interface EggsService {
    EggsRecordResponse createEggs(UUID idChicken, @Valid EggsRecordRequest eggsRequest);

    List<EggsRecordListResponse> getEggsPerChickenWithId(UUID idChicken);

    void deleteEggsWithId(UUID idChicken, UUID idEggsRecord);

    List<ListTotalEggsRecords> getTotalEggsRecords();

    AverageEggsInPeriod getAverageEggsInPeriod(LocalDate startDate, LocalDate endDate);

    /*TotalEggsperChickenperDate getTotalEggs(UUID idChicken, LocalDate startDate, LocalDate endDate);*/
}
