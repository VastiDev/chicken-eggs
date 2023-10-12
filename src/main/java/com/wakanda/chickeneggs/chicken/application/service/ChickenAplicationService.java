package com.wakanda.chickeneggs.chicken.application.service;

import com.wakanda.chickeneggs.chicken.application.api.ChickenListResponse;
import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.chicken.application.api.ChickenResponse;
import com.wakanda.chickeneggs.chicken.application.repository.ChickenRepository;
import com.wakanda.chickeneggs.chicken.domain.Chicken;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Log4j2
@RequiredArgsConstructor
public class ChickenAplicationService implements ChickenService {
    private final ChickenRepository chickenRepository;

    @Override
    public ChickenResponse createChicken(ChickenRequest chickenrequest) {
        log.info("[start] ChickenAplicationService - createChicken");
        Chicken chicken = chickenRepository.save(new Chicken(chickenrequest));
        log.info("[finish] ChickenAplicationService - createChicken");
        return ChickenResponse.builder().idChicken(chicken.getIdChicken())
                .build();
    }

    @Override
    public List<ChickenListResponse> getAllChickens() {
        log.info("[start] ChickenAplicationService - getAllChickens");
        List<Chicken> chickens = chickenRepository.getAllChickens();
        log.info("[finish] ChickenAplicationService - getAllChickens");
        return ChickenListResponse.convert(chickens);
    }
}
