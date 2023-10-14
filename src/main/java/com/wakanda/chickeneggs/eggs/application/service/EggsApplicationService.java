package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.application.api.EggsRequest;
import com.wakanda.chickeneggs.eggs.application.api.EggsResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Log4j2
public class EggsApplicationService implements EggsService {
    @Override
    public EggsResponse createEggs(UUID idChicken, EggsRequest eggsRequest) {
        log.info("[start] EggsApplicationService - createEggs");
        log.info("[idChicken] {}", idChicken);
        log.info("[finish] EggsApplicationService - createEggs");
        return null;
    }
}
