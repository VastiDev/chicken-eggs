package com.wakanda.chickeneggs.chicken.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Value
@Builder
public class ChickenResponse {
    private UUID idChicken;
}
