package com.wakanda.chickeneggs.eggsRecord.application.api;

import com.wakanda.chickeneggs.eggsRecord.application.service.EggsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@RestController
@Log4j2
@RequiredArgsConstructor
public class EggsController implements EggsAPI {
    private final EggsService eggsService;

    @Override
    public EggsRecordResponse postEggsRecord(UUID idChicken, EggsRecordRequest eggsRecordRequest) {
        log.info("[start] EggsController - postEggs");
        log.info("[idChicken] {}", idChicken);
        EggsRecordResponse eggs = eggsService.createEggs(idChicken, eggsRecordRequest);
        log.info("[finish] EggsController - postEggs");
        return eggs;
    }

    @Override
    public List<EggsRecordListResponse> getAllEggsPerChicken(UUID idChicken) {
        log.info("[start] EggsController - getAllEggsRecords");
        log.info("[idChicken] {} ", idChicken);
        List<EggsRecordListResponse> eggsPerChicken = eggsService.getEggsPerChickenWithId(idChicken);
        log.info("[finish] EggsController - getAllEggsRecords");
        return eggsPerChicken;
    }

    @Override
    public EggsChickenDetailsResponse getDetailedEggsFromChicken(UUID idChicken, UUID idEggsRecord) {
        log.info("[start] EggsController - getDetailedEggsFromChicken");
        log.info("[idChicken] {} - [idEggsRecord] {} ", idChicken, idEggsRecord);
        EggsChickenDetailsResponse eggs = eggsService.getDetailsEggsPerChickenWithId(idChicken, idEggsRecord);
        log.info("[start] EggsController - getDetailedEggsFromChicken");
        return eggs;
    }

    @Override
    public void deleteEggsRecord(UUID idChicken, UUID idEggsRecord) {
        log.info("[start] EggsController - deleteEggsRecord");
        log.info("[idChicken] {} - [idEggsRecord] {}", idChicken, idEggsRecord);
        eggsService.deleteEggsWithId(idChicken, idEggsRecord);
        log.info("[finish] EggsController - deleteEggsRecord");

    }

    @Override
    public List<listTotalEggsRecords> getAllEggsRecords() {
        log.info("[start] EggsController - getAllEggsRecords");
        log.info("[finish] EggsController - getAllEggsRecords");
        return null;
    }
}
