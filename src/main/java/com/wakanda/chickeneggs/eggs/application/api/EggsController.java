package com.wakanda.chickeneggs.eggs.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@Log4j2
public class EggsController implements EggsAPI {



    @Override
    public EggsResponse postEggs(UUID idChicken, EggsRequest eggsRecordRequest) {
        log.info("[start] EggsController - postEggs");
        log.info("[idChicken] {}", idChicken);
        log.info("[finish] EggsController - postEggs");
        return null;
    }
}
