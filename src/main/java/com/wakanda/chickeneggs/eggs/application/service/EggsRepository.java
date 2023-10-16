package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.domain.Eggs;

import java.util.Optional;
import java.util.UUID;

public interface EggsRepository {
    Eggs saveEggs(Eggs eggs);
   /* Optional<Eggs> bringAllRecords(UUID idChicken);
    Eggs getEggsPerId(UUID idEggs);
    void deleteEggs(Eggs eggs);*/
}
