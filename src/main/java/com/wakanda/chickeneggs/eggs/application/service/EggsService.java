package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.application.api.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


public interface EggsService {
    EggsResponse createEggs(UUID idChicken, @Valid EggsRequest eggsRequest);

    List<EggsRecordListResponse> getEggsPerChickenWithId(UUID idChicken);

    EggsChickenDetailsResponse getDetailsEggsPerChickenWithId(UUID idChicken, UUID idEggs);

    void deleteEggsWithId(UUID idChicken, UUID idEggs);

    void patchEggsFromChicken(UUID idChicken, UUID idEggs, PatchEggsRequest patchEggsRequest);

}
