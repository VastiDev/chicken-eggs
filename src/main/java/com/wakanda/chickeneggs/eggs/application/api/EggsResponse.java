package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.eggs.domain.Eggs;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EggsResponse {
    @NotNull
    private UUID idEggs;


    public EggsResponse(UUID idEggs) {
        this.idEggs = idEggs;
    }
}
