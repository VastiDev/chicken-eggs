package com.wakanda.chickeneggs.eggsRecord.application.service;

import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;

import java.util.List;
import java.util.UUID;

public interface EggsRepository {
    EggsRecord saveEggs(EggsRecord eggsRecord);

    /*List<EggsRecord> getEggsPerChickenWithId(UUID idChicken);

    EggsRecord getEggsPerId(UUID idEggs);

    void deleteEggs(EggsRecord eggsRecord);*/

}
