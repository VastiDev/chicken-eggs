package com.wakanda.chickeneggs.chicken.application.service;

import com.wakanda.chickeneggs.chicken.application.api.*;
import com.wakanda.chickeneggs.chicken.application.repository.ChickenRepository;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@Log4j2
@RequiredArgsConstructor
public class ChickenApplicationService implements ChickenService {
    private final ChickenRepository chickenRepository;

    @Override
    public ChickenResponse createChicken(ChickenRequest chickenrequest) {
        log.info("[start] ChickenApplicationService - createChicken");
        Chicken chicken = chickenRepository.save(new Chicken(chickenrequest));
        log.info("[finish] ChickenApplicationService - createChicken");
        return ChickenResponse.builder().idChicken(chicken.getIdChicken())
                .build();
    }

    @Override
    public List<ChickenListResponse> getAllChickens() {
        log.info("[start] ChickenApplicationService - getAllChickens");
        List<Chicken> chickens = chickenRepository.getAllChickens();
        log.info("[finish] ChickenApplicationService - getAllChickens");
        return ChickenListResponse.convert(chickens);
    }


    @Override
    public ChickenDetailedResponse getChickenPerId(UUID idChicken) {
        log.info("[start] ChickenApplicationService - getChickenPerId");
        Chicken chicken = chickenRepository.getChickenPerId(idChicken);
        log.info("[finish] ChickenApplicationService - getChickenPerId");
        return new ChickenDetailedResponse(chicken);

    }

    @Override
    public void deleteChickenPerId(UUID idChicken) {
        log.info("[start] ChickenApplicationService - deleteChickenPerId");
        Chicken chicken = chickenRepository.getChickenPerId(idChicken);
        chickenRepository.deleteChickenPerId(chicken);
        log.info("[finish] ChickenApplicationService - deleteChickenPerId");
    }

    @Override
    public void updateChickenPerId(UUID idChicken, ChickenUpdateRequest chickenUpdateRequest) {
        log.info("[start] ChickenApplicationService - updateChickenPerId");
        Chicken chicken = chickenRepository.getChickenPerId(idChicken);
        chicken.update(chickenUpdateRequest);
        chickenRepository.save(chicken);
        log.info("[finish] ChickenApplicationService - updateChickenPerId");

    }
}