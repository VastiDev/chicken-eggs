package com.wakanda.chickeneggs.eggsRecord.application.api;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EggsRecordResponse {
    @NotNull
    private UUID idEggs;

    public EggsRecordResponse(UUID idEggs) {
        this.idEggs = idEggs;
    }
}
