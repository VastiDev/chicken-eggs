package com.wakanda.chickeneggs.chicken.application.infra;

import com.wakanda.chickeneggs.chicken.application.repository.ChickenRepository;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ChickenInfraRepository implements ChickenRepository {
    private final ChickenSpringDataJpaRepository chickenSpringDataJpaRepository;

    @Override
    public Chicken save(Chicken chicken) {
        log.info("[start] ChickenInfraRepository - save");
        chickenSpringDataJpaRepository.save(chicken);
        log.info("[finish] ChickenInfraRepository - save");
        return chicken;
    }

    @Override
    public List<Chicken> getAllChickens() {
        log.info("[start] ChickenInfraRepository - getAllChickens");
        List<Chicken> allChickens = chickenSpringDataJpaRepository.findAll();
        log.info("[finish] ChickenInfraRepository - getAllChickens");
        return allChickens;
    }
}
