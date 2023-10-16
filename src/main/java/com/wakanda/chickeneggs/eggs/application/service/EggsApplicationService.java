package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.chicken.application.service.ChickenService;
import com.wakanda.chickeneggs.eggs.application.api.*;
import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@Log4j2
@RequiredArgsConstructor
public class EggsApplicationService implements EggsService {
    private final ChickenService chickenService;
    private final EggsRepository eggsRepository;

    @Override
    public EggsResponse createEggs(UUID idChicken, @Valid EggsRequest eggsRequest) {
        log.info("[start] EggsApplicationService - createEggs");
        log.info("[idChicken] {}", idChicken);
        chickenService.getChickenPerId(idChicken);
        Eggs eggs = eggsRepository.saveEggs(new Eggs(idChicken, eggsRequest));
        log.info("[finish] EggsApplicationService - createEggs");
        return new EggsResponse(eggs.getIdEggs());
    }

    @Override
    public List<EggsRecordListResponse> getEggsPerChickenWithId(UUID idChicken) {
        log.info("[start] EggsApplicationService - getEggsPerChickenWithId");
        chickenService.getChickenPerId(idChicken);
        List<Eggs> eggsPerChicken = eggsRepository.getEggsPerChickenWithId(idChicken);
        log.info("[finish] EggsApplicationService - getEggsPerChickenWithId");
        return EggsRecordListResponse.convert(eggsPerChicken);
    }

    @Override
    public EggsChickenDetailsResponse getDetailsEggsPerChickenWithId(UUID idChicken, UUID idEggs) {
        log.info("[start] EggsApplicationService - getDetailsEggsPerChickenWithId");
        chickenService.getChickenPerId(idChicken);
        Eggs eggs = eggsRepository.getEggsPerId(idEggs);
        log.info("[finish] EggsApplicationService - getDetailsEggsPerChickenWithId");
        return new EggsChickenDetailsResponse(eggs);
    }

    @Override
    public void deleteEggsWithId(UUID idChicken, UUID idEggs) {
        log.info("[start] EggsApplicationService - deleteEggsWithId");
        chickenService.getChickenPerId(idChicken);
        Eggs eggs = eggsRepository.getEggsPerId(idEggs);
        eggsRepository.deleteEggs(eggs);
        log.info("[finish] EggsApplicationService - deleteEggsWithId");
    }

    @Override
    public void patchEggsFromChicken(UUID idChicken, UUID idEggs, PatchEggsRequest patchEggsRequest) {
        log.info("[start] EggsApplicationService - patchEggsFromChicken");
        chickenService.getChickenPerId(idChicken);
        Eggs eggs = eggsRepository.getEggsPerId(idEggs);
        eggs.patchEggs(patchEggsRequest);
        eggsRepository.saveEggs(eggs);
        log.info("[start] EggsApplicationService - patchEggsFromChicken");
    }

}

