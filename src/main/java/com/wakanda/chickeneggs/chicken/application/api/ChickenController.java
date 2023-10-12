package com.wakanda.chickeneggs.chicken.application.api;

import com.wakanda.chickeneggs.chicken.application.service.ChickenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Log4j2
@RequiredArgsConstructor
public class ChickenController implements ChickenAPI{

    private final ChickenService chickenService;

    @Override
    public ChickenResponse postChicken(ChickenRequest chickenrequest) {
        log.info("[start] ChickenController - postChicken");
        ChickenResponse createdChicken = chickenService.createChicken(chickenrequest);
        log.info("[finish] ChickenController - postChicken");
        return createdChicken;
    }
}
