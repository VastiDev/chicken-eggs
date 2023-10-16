package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.chicken.application.api.ChickenListResponse;
import com.wakanda.chickeneggs.chicken.application.api.ChickenUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/chicken/{idChicken}/eggs")
public interface EggsAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EggsResponse postEggs(@PathVariable UUID idChicken,
                          @Valid @RequestBody EggsRequest eggsRequest);
    @GetMapping(value = "/{idEggs}")
    @ResponseStatus(code = HttpStatus.OK)
    EggsChickenDetailsResponse getAllEggsFromChicken(@PathVariable UUID idChicken, @PathVariable UUID idEggs);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<EggsRecordListResponse> getAllEggsRecords ();

    @PatchMapping(value = "/{idEggs}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchEggsDaily(@PathVariable UUID idChicken, @PathVariable UUID idEggs,
                            @Valid @RequestBody EggsRecordRequest eggsRecordRequest);

    @DeleteMapping(value = "/{idEggs}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteEggsRecord(@PathVariable UUID idChicken, @PathVariable UUID idEggs);
}
