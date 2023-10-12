package com.wakanda.chickeneggs.chicken.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class ChickenController implements ChickenAPI{

    @Override
    public ChickenResponse postChicken(ChickenRequest chickenrequest) {
        log.info("[start] ChickenController - postChicken");
        log.info("[finish] ChickenController - postChicken");
        return null;
    }
}
