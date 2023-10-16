package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.chicken.application.api.ChickenListResponse;
import com.wakanda.chickeneggs.chicken.application.api.ChickenUpdateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/eggs/")
public interface EggsAPI {
    @PostMapping("chicken/{idChicken}")
    @ResponseStatus(code = HttpStatus.CREATED)
    EggsResponse postEggs(@PathVariable UUID idChicken,
                          @Valid @RequestBody EggsRequest eggsRequest);
   @GetMapping(value = "chicken/{idChicken}")
    @ResponseStatus(code = HttpStatus.OK)
    List<EggsRecordListResponse> getAllEggsPerChicken(@PathVariable UUID idChicken);

    @GetMapping(value = "chicken/{idChicken}/eggs/{idEggs}")
    @ResponseStatus(code = HttpStatus.OK)
    EggsChickenDetailsResponse getDetailedEggsFromChicken(@PathVariable UUID idChicken, @PathVariable UUID idEggs);

    @DeleteMapping(value = "chicken/{idChicken}/eggs/{idEggs}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteEggsRecord(@PathVariable UUID idChicken, @PathVariable UUID idEggs);

    @PatchMapping(value = "chicken/{idChicken}/eggs/{idEggs}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchEggsDaily(@PathVariable UUID idChicken,@PathVariable UUID idEggs,
                            @Valid  PatchEggsRequest patchEggsRequest);


}
