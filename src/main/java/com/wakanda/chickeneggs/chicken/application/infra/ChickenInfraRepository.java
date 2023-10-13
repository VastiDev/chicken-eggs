package com.wakanda.chickeneggs.chicken.application.infra;

import com.wakanda.chickeneggs.chicken.application.repository.ChickenRepository;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import com.wakanda.chickeneggs.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Chicken getChickenPerId(UUID idChicken) {
        log.info("[start] ChickenInfraRepository - getChickenPerId");
        Chicken chicken = chickenSpringDataJpaRepository.findById(idChicken)
                        .orElseThrow(()-> APIException.build(HttpStatus.NOT_FOUND,"Cchicken not found!!"));
        log.info("[finish] ChickenInfraRepository - getChickenPerId");
        return chicken;
    }

    @Override
    public void deleteChickenPerId(Chicken chicken) {
        log.info("[start] ChickenInfraRepository - deleteChickenPerId");
        chickenSpringDataJpaRepository.delete(chicken);
        log.info("[finish] ChickenInfraRepository - deleteChickenPerId");
    }
}
