package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.eggs.application.service.EggsService;
import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
@RestController
@Log4j2
@RequiredArgsConstructor
public class EggsController implements EggsAPI {
    private final EggsService eggsService;

    @Override
    public EggsResponse postEggs(UUID idChicken, EggsRequest eggsRequest) {
        log.info("[start] EggsController - postEggs");
        log.info("[idChicken] {}", idChicken);
        EggsResponse eggs = eggsService.createEggs(idChicken, eggsRequest);
        log.info("[finish] EggsController - postEggs");
        return eggs;
    }

    @Override
    public EggsChickenDetailsResponse getAllEggsFromChicken(UUID idChicken, UUID idEggs) {
        log.info("[start] EggsController - getAllEggsFromChicken");
        log.info("[idChicken] {} - [idEggs] {}", idChicken, idEggs);
        EggsChickenDetailsResponse eggsPerChicken = eggsService.bringEggsPerChickenWithId(idChicken,idEggs);
        log.info("[finish] EggsController - postEggs");
        return eggsPerChicken;
    }

    @Override
    public List<EggsRecordListResponse> getAllEggsRecords() {
        log.info("[start] EggsController - getAllEggsRecords");
        List<EggsRecordListResponse> listAll = eggsService.bringAllRecords();
        log.info("[finish] EggsController - getAllEggsRecords");
        return listAll;
    }

    @Override
    public void patchEggsDaily(UUID idChicken, UUID idEggs, @Valid EggsRecordRequest eggsRecordRequest) {
        log.info("[start] EggsController - sumEggsDaily");
        log.info("[idChicken] {} - [idEggs] {}", idChicken, idEggs);
        eggsService.addEggsPerChicken(idChicken, idEggs, eggsRecordRequest);
        log.info("[finish] EggsController - sumEggsDaily");
    }


    @Override
    public void deleteEggsRecord(UUID idChicken, UUID idEggs) {
        log.info("[start] EggsController - deleteEggsRecord");
        log.info("[idChicken] {}", idChicken);
        eggsService.deleteEggsRecordPerChicken(idChicken,idEggs);
        log.info("[finish] EggsController - deleteEggsRecord");
    }

}
