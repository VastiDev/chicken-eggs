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

    /*@GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    EggsChickenDetailsResponse getAllEggsFromChicken(@PathVariable UUID idChicken);

    @PatchMapping(value = "/{idEggs}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void patchEggsDaily(@PathVariable UUID idChicken, @PathVariable UUID idEggs,
                            @Valid @RequestBody EggsRecordRequest eggsRecordRequest);

    @DeleteMapping(value = "/{idEggs}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteEggsRecord(@PathVariable UUID idChicken, chicken/{idChicken});*/
}
