package com.wakanda.chickeneggs.eggs.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EggsRecordResponse {
    private UUID idDailyEggsRecord;
}
