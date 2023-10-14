package com.wakanda.chickeneggs.eggs.application.service;

import com.wakanda.chickeneggs.eggs.application.api.EggsRequest;
import com.wakanda.chickeneggs.eggs.application.api.EggsResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class EggsApplicationService implements EggsService {
    @Override
    public EggsResponse createEggs(UUID idChicken, EggsRequest eggsRequest) {
        return null;
    }
}
