package com.wakanda.chickeneggs.chicken.application.repository;

import com.wakanda.chickeneggs.chicken.application.api.ChickenListResponse;
import com.wakanda.chickeneggs.chicken.domain.Chicken;

import java.util.List;

public interface ChickenRepository {
    Chicken save(Chicken chicken);

    List<Chicken> getAllChickens();
}
