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

    /*@Override
    public List<EggsRecordListResponse> bringAllRecords(UUID idChicken) {
        log.info("[start] EggsApplicationService - bringAllRecords");
        chickenService.getChickenPerId(idChicken);
        List<Eggs> eggsPerChicken = eggsRepository.getEggsPerChickenPerId(idChicken);
        log.info("[finish] EggsApplicationService - bringAllRecords");
        return EggsRecordListResponse.convert(eggsPerChicken);
    }

    /*@Override
    public EggsChickenDetailsResponse bringEggsPerChickenWithId(UUID idChicken) {
        log.info("[start] EggsApplicationService - bringEggsPerChickenWithId");
        /*chickenService.getChickenPerId(idChicken);
        Optional<Eggs> eggs = eggsRepository.bringAllRecords(idChicken);
        log.info("[finish] EggsApplicationService - bringEggsPerChickenWithId");
        return new EggsChickenDetailsResponse(eggs);
        return null;
    }

    @Override
    public List<EggsRecordListResponse> bringAllRecords(UUID idChicken) {
        log.info("[start] EggsApplicationService - bringAllRecords");
        chickenService.getChickenPerId(idChicken);
        Optional<Eggs> eggsRecord = eggsRepository.bringAllRecords(idChicken);
        log.info("[finish] EggsApplicationService - bringAllRecords");
        return EggsRecordListResponse.convert(eggsRecord);
    }

    @Override
    public void addEggsPerChicken(UUID idChicken, UUID idEggs, EggsRecordRequest eggsRecordRequest) {
        log.info("[start] EggsApplicationService - addEggsPerChicken");
        chickenService.getChickenPerId(idChicken);
        Eggs eggs = eggsRepository.getEggsPerId(idEggs);
        eggs.addEggs(eggsRecordRequest.getEggsQuantity());
        log.info("[finish] EggsApplicationService - addEggsPerChicken");
    }


    @Override
    public void deleteEggsRecordPerChicken(UUID idChicken, UUID idEggs) {
        log.info("[start] EggsApplicationService - deleteEggsRecordPerChicken");
        chickenService.getChickenPerId(idChicken);
        Eggs eggs = eggsRepository.getEggsPerId(idEggs);
        eggsRepository.deleteEggs(eggs);
        log.info("[finish] EggsApplicationService - deleteEggsRecordPerChicken");
    }*/
}

