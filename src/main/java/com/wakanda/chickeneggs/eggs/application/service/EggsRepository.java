package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.domain.Eggs;

public interface EggsRepository {
    Eggs saveEggs(Eggs eggs);
}
