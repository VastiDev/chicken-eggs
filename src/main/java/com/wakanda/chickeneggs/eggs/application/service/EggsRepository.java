package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.domain.Eggs;

import java.util.UUID;

public interface EggsRepository {
    Eggs saveEggs(Eggs eggs);
    Eggs bringEggsPerChickenWithId(UUID idChicken);

    Eggs bringEggsAndChicken(UUID idChicken);
}
