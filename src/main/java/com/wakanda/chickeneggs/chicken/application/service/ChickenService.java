package com.wakanda.chickeneggs.chicken.application.service;

import com.wakanda.chickeneggs.chicken.application.api.ChickenListResponse;
import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.chicken.application.api.ChickenResponse;

import java.util.List;

public interface ChickenService {
    ChickenResponse createChicken(ChickenRequest chickenrequest);

    List<ChickenListResponse> getAllChickens();
}
