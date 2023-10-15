package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.chicken.application.service.ChickenService;
import com.wakanda.chickeneggs.eggs.application.api.EggsChickenDetailedResponse;
import com.wakanda.chickeneggs.eggs.application.api.EggsChickenListResponse;
import com.wakanda.chickeneggs.eggs.application.api.EggsRequest;
import com.wakanda.chickeneggs.eggs.application.api.EggsResponse;
import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
@Log4j2
@RequiredArgsConstructor
public class EggsApplicationService implements EggsService {
    private final ChickenService chickenService;
    private final EggsRepository eggsRepository;

    @Override
    public EggsResponse createEggs(UUID idChicken, EggsRequest eggsRequest) {
        log.info("[start] EggsApplicationService - createEggs");
        log.info("[idChicken] {}", idChicken);
        chickenService.getChickenPerId(idChicken);
        Eggs eggs = eggsRepository.saveEggs(new Eggs(idChicken, eggsRequest));
        log.info("[finish] EggsApplicationService - createEggs");
        return new EggsResponse(eggs.getIdEggs());
    }

    @Override
    public List<EggsChickenListResponse> bringEggsPerChickenWithId(UUID idChicken) {
        log.info("[start] EggsApplicationService - bringEggsPerChickenWithId");
        chickenService.getChickenPerId(idChicken);
        List<Eggs> eggsPerChicken = eggsRepository.bringEggsPerChickenWithId(idChicken);
        log.info("[finish] EggsApplicationService - bringEggsPerChickenWithId");
        return EggsChickenListResponse.convert(eggsPerChicken);
    }

    @Override
    public EggsChickenDetailedResponse bringEggsAndChickenName(UUID idChicken) {
        log.info("[start] EggsApplicationService - bringEggsAndChickenName");
        log.info("[start] EggsApplicationService - bringEggsAndChickenName");
        return null;
    }
}
