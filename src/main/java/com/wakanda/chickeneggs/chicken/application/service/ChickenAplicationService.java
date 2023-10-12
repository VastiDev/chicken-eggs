package com.wakanda.chickeneggs.chicken.application.service;

import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.chicken.application.api.ChickenResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


@Service
@Log4j2
public class ChickenAplicationService implements ChickenService {
    @Override
    public ChickenResponse createChicken(ChickenRequest chickenrequest) {
        log.info("[start] ChickenAplicationService - createChicken");
        log.info("[finish] ChickenAplicationService - createChicken");
        return null;
    }
}
