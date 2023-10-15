package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.application.api.EggsChickenDetailedResponse;
import com.wakanda.chickeneggs.eggs.application.api.EggsChickenDetailsResponse;
import com.wakanda.chickeneggs.eggs.application.api.EggsRequest;
import com.wakanda.chickeneggs.eggs.application.api.EggsResponse;

import java.util.List;
import java.util.UUID;


public interface EggsService {
    EggsResponse createEggs(UUID idChicken, EggsRequest eggsRequest);

    EggsChickenDetailsResponse bringEggsPerChickenWithId(UUID idChicken);

    EggsChickenDetailedResponse bringEggsAndChickenName(UUID idChicken);
}
