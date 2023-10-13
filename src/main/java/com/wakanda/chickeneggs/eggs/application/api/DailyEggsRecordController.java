package com.wakanda.chickeneggs.eggs.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@Log4j2
public class DailyEggsRecordController implements DailyEggsRecordAPI {



    @Override
    public EggsRecordResponse postEggsRecord(UUID idChicken, EggsRecordRequest eggsRecordRequest) {
        log.info("[start] DailyEggsRecordController - postEggsRecord");
        log.info("[idChicken] {}", idChicken);
        //EggsRecordResponse response = dailyEggsRecordService.postEggsRecord(idChicken, eggsRecordRequest);
        log.info("[finish] DailyEggsRecordController - postEggsRecord");
        return null;
    }
}
