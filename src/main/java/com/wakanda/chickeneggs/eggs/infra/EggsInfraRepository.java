package com.wakanda.chickeneggs.eggs.infra;

import com.wakanda.chickeneggs.eggs.application.service.EggsRepository;
import com.wakanda.chickeneggs.eggs.domain.Eggs;
import com.wakanda.chickeneggs.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
    public List<Eggs> getEggsPerChickenWithId(UUID idChicken) {
        log.info("[start] EggsInfraRepository - getEggsPerChickenWithId");
        var eggs = eggsSpringDataJPARepository.findAllById(Collections.singleton((idChicken)));
        log.info("[finish] EggsInfraRepository - getEggsPerChickenWithId");
        return eggs;
    }

    @Override
    public Eggs getEggsPerId(UUID idEggs) {
        log.info("[start] EggsInfraRepository - getEggsPerId");
        var eggs = eggsSpringDataJPARepository.findById(idEggs)
                        .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND,
                                "Registro não encontrado para este idEggs=" + idEggs));
        log.info("[finish] EggsInfraRepository - getEggsPerId");
        return eggs;
    }

    @Override
    public void deleteEggs(Eggs eggs) {
        log.info("[start] EggsInfraRepository - deleteEggs");
        eggsSpringDataJPARepository.delete(eggs);
        log.info("[finish] EggsInfraRepository - deleteEggs");

    }


    /*@Override
    public void deleteEggs(Eggs eggs) {
        log.info("[start] EggsInfraRepository - deleteEggs");
        eggsSpringDataJPARepository.delete(eggs);
        log.info("[finish] EggsInfraRepository - deleteEggs");

    }*/
}
