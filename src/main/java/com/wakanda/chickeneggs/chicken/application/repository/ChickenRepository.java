package com.wakanda.chickeneggs.chicken.application.repository;

import com.wakanda.chickeneggs.chicken.domain.Chicken;

public interface ChickenRepository {
    Chicken save(Chicken chicken);
}
