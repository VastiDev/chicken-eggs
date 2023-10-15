package com.wakanda.chickeneggs.eggs.infra;

import com.wakanda.chickeneggs.eggs.application.service.EggsRepository;
import com.wakanda.chickeneggs.eggs.domain.Eggs;
import com.wakanda.chickeneggs.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EggsInfraRepository implements EggsRepository {
    private final EggsSpringDataJPARepository eggsSpringDataJPARepository;
    @Override
    public Eggs saveEggs(Eggs eggs) {
        log.info("[start] EggsInfraRepository - saveEggs");
        eggsSpringDataJPARepository.save(eggs);
        log.info("[finish] EggsInfraRepository - saveEggs");
        return eggs;
    }

    @Override
    public Eggs bringEggsPerChickenWithId(UUID idChicken) {
        log.info("[start] EggsInfraRepository - bringEggsPerChickenWithId");
        var eggs = eggsSpringDataJPARepository.findByIdChickenLay(idChicken);
        log.info("[finish] EggsInfraRepository - bringEggsPerChickenWithId");
        return eggs;
    }

    @Override
    public Eggs bringEggsAndChicken(UUID idChicken) {
        log.info("[start] EggsInfraRepository - bringEggsAndChicken");
        var eggs = eggsSpringDataJPARepository.findById(idChicken)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,
                        "Nâo foi encontrado registro de ovos para essa galinha"));
        log.info("[finish] EggsInfraRepository - bringEggsAndChicken");
        return eggs;
    }

    @Override
    public List<Eggs> bringAllRecords() {
        log.info("[start] EggsInfraRepository - bringAllRecords");
        var eggs = eggsSpringDataJPARepository.findAll();
        log.info("[finish] EggsInfraRepository - bringAllRecords");
        return eggs;
    }
}
