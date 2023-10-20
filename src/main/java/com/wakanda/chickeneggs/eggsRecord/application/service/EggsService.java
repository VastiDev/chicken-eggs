package com.wakanda.chickeneggs.eggsRecord.application.service;

import com.wakanda.chickeneggs.eggsRecord.application.api.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


public interface EggsService {
    EggsRecordResponse createEggs(UUID idChicken, @Valid EggsRecordRequest eggsRequest);

    List<EggsRecordListResponse> getEggsPerChickenWithId(UUID idChicken);



    /*EggsChickenDetailsResponse getDetailsEggsPerChickenWithId(UUID idChicken, UUID idEggs);

    void deleteEggsWithId(UUID idChicken, UUID idEggs);

    void patchEggsFromChicken(UUID idChicken, UUID idEggs, PatchEggsRequest patchEggsRequest);*/

}
