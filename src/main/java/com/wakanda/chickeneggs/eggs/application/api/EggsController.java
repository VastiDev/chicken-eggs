package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.eggs.application.service.EggsService;
import com.wakanda.chickeneggs.eggs.domain.Eggs;
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
    public EggsResponse postEggs(UUID idChicken, EggsRequest eggsRequest) {
        log.info("[start] EggsController - postEggs");
        log.info("[idChicken] {}", idChicken);
        EggsResponse eggs = eggsService.createEggs(idChicken, eggsRequest);
        log.info("[finish] EggsController - postEggs");
        return eggs;
    }

    @Override
    public List<EggsChickenListResponse> getAllEggsFromChicken(UUID idChicken) {
        log.info("[start] EggsController - getAllEggsFromChicken");
        log.info("[finish] EggsController - getAllEggsFromChicken");
        return null;
    }
}
