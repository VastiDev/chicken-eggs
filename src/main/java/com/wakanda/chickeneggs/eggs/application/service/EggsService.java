package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.application.api.EggsChickenDetailedResponse;
import com.wakanda.chickeneggs.eggs.application.api.EggsChickenListResponse;
import com.wakanda.chickeneggs.eggs.application.api.EggsRequest;
import com.wakanda.chickeneggs.eggs.application.api.EggsResponse;

import java.util.List;
import java.util.UUID;


public interface EggsService {
    EggsResponse createEggs(UUID idChicken, EggsRequest eggsRequest);

    List<EggsChickenListResponse> bringEggsPerChickenWithId(UUID idChicken);

    EggsChickenDetailedResponse bringEggsAndChickenName(UUID idChicken);
}
