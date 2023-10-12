package com.wakanda.chickeneggs.chicken.application.service;

import com.wakanda.chickeneggs.chicken.application.api.ChickenRequest;
import com.wakanda.chickeneggs.chicken.application.api.ChickenResponse;

public interface ChickenService {
    ChickenResponse createChicken(ChickenRequest chickenrequest);
}
