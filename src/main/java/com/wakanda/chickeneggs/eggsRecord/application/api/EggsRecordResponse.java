package com.wakanda.chickeneggs.eggsRecord.application.api;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EggsRecordResponse {
    @NotNull
    private UUID idEggsRecord;
    public EggsRecordResponse(UUID idEggsRecord) {
        this.idEggsRecord = idEggsRecord;
    }
}
