package com.wakanda.chickeneggs.eggs.infra;

import com.wakanda.chickeneggs.eggs.application.service.EggsRepository;
import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
