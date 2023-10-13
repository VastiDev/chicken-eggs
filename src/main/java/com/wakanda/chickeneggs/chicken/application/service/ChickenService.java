package com.wakanda.chickeneggs.chicken.application.service;

import com.wakanda.chickeneggs.chicken.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ChickenService {
    ChickenResponse createChicken(ChickenRequest chickenrequest);

    List<ChickenListResponse> getAllChickens();

    ChickenDetailedResponse getChickenPerId(UUID idChicken);

    void deleteChickenPerId(UUID idChicken);

    void updateChickenPerId(UUID idChicken, ChickenUpdateRequest chickenUpdateRequest);
}
