package com.wakanda.chickeneggs.eggsRecord.application.service;

import com.wakanda.chickeneggs.chicken.application.service.ChickenService;
import com.wakanda.chickeneggs.eggsRecord.application.api.*;
import com.wakanda.chickeneggs.eggsRecord.domain.EggsRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
@Service
@Log4j2
@RequiredArgsConstructor
public class EggsApplicationService implements EggsService {
    private final ChickenService chickenService;
    private final EggsRepository eggsRepository;

    @Override
    public EggsRecordResponse createEggs(UUID idChicken, @Valid EggsRecordRequest eggsRequest) {
        log.info("[start] EggsApplicationService - createEggs");
        log.info("[idChicken] {}", idChicken);
        chickenService.getChickenPerId(idChicken);
        EggsRecord eggsRecord = eggsRepository.saveEggs(new EggsRecord(idChicken, eggsRequest));
        log.info("[finish] EggsApplicationService - createEggs");
        return new EggsRecordResponse(eggsRecord.getIdEggsRecord());
    }

    @Override
    public List<EggsRecordListResponse> getEggsPerChickenWithId(UUID idChicken) {
        log.info("[start] EggsApplicationService - getEggsPerChickenWithId");
        chickenService.getChickenPerId(idChicken);
        List<EggsRecord> eggsRecordPerChicken = eggsRepository.getEggsPerChickenWithId(idChicken);
        log.info("[finish] EggsApplicationService - getEggsPerChickenWithId");
        return EggsRecordListResponse.convert(eggsRecordPerChicken);
    }

    @Override
    public EggsChickenDetailsResponse getDetailsEggsPerChickenWithId(UUID idChicken, UUID idEggsRecord) {
        log.info("[start] EggsApplicationService - getDetailsEggsPerChickenWithId");
        chickenService.getChickenPerId(idChicken);
        EggsRecord eggsRecord = eggsRepository.getEggsPerId(idEggsRecord);
        log.info("[finish] EggsApplicationService - getDetailsEggsPerChickenWithId");
        return new EggsChickenDetailsResponse(eggsRecord);
    }

    @Override
    public void deleteEggsWithId(UUID idChicken, UUID idEggsRecord) {
        log.info("[start] EggsApplicationService - deleteEggsWithId");
        chickenService.getChickenPerId(idChicken);
        EggsRecord eggsRecord = eggsRepository.getEggsPerId(idEggsRecord);
        eggsRepository.deleteEggs(eggsRecord);
        log.info("[finish] EggsApplicationService - deleteEggsWithId");
    }

}

