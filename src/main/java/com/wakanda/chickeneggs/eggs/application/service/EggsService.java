package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.application.api.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


public interface EggsService {
    EggsResponse createEggs(UUID idChicken, @Valid EggsRequest eggsRequest);

    /*EggsChickenDetailsResponse bringEggsPerChickenWithId(UUID idChicken);

    List<EggsRecordListResponse> bringAllRecords(UUID idChicken);

    void addEggsPerChicken(UUID idChicken, UUID idEggs, EggsRecordRequest eggsRecordRequest);

    void deleteEggsRecordPerChicken(UUID idChicken, UUID idEggs);*/
}
