package com.wakanda.chickeneggs.chicken.application.repository;

import com.wakanda.chickeneggs.chicken.domain.Chicken;

import java.util.List;
import java.util.UUID;

public interface ChickenRepository {
    Chicken save(Chicken chicken);

    List<Chicken> getAllChickens();

    Chicken getChickenPerId(UUID idChicken);
}
