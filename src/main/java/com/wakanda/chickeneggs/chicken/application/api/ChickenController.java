package com.wakanda.chickeneggs.chicken.application.api;

import com.wakanda.chickeneggs.chicken.application.service.ChickenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


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

    @Override
    public List<ChickenListResponse> getAllChickens() {
        log.info("[start] ChickenController - getAllChickens");
        List<ChickenListResponse> chickens = chickenService.getAllChickens();
        log.info("[finish] ChickenController - getAllChickens");
        return chickens;
    }

    @Override
    public ChickenDetailedResponse getChickenPerId(UUID idChicken) {
        log.info("[start] ChickenController - getChickenPerId");
        ChickenDetailedResponse detailedResponse = chickenService.getChickenPerId(idChicken);
        log.info("[finish] ChickenController - getChickenPerId");
        return detailedResponse ;
    }

    @Override
    public void deleteChickenPerId(UUID idChicken) {
        log.info("[start] ChickenController - deleteChickenPerId");
        log.info("[finish] ChickenController - deleteChickenPerId");

    }
}
