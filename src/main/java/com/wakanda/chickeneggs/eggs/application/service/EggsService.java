package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.application.api.*;

import java.util.List;
import java.util.UUID;


public interface EggsService {
    EggsResponse createEggs(UUID idChicken, EggsRequest eggsRequest);

    EggsChickenDetailsResponse bringEggsPerChickenWithId(UUID idChicken, UUID idEggs);

    List<EggsRecordListResponse> bringAllRecords();

    void addEggsPerChicken(UUID idChicken, UUID idEggs, EggsRecordRequest eggsRecordRequest);

    void deleteEggsRecordPerChicken(UUID idChicken, UUID idEggs);
}
