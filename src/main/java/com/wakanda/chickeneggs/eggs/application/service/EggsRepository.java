package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.domain.Eggs;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EggsRepository {
    Eggs saveEggs(Eggs eggs);

    List<Eggs> getEggsPerChickenWithId(UUID idChicken);

    Eggs getEggsPerId(UUID idEggs);

    /*Eggs getEggsPerId(UUID idEggs);
    void deleteEggs(Eggs eggs);*/
}
