package com.wakanda.chickeneggs.eggs.application.api;

import com.wakanda.chickeneggs.chicken.application.api.ChickenListResponse;
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
    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    EggsChickenDetailsResponse getAllEggsFromChicken(@PathVariable UUID idChicken);

    @GetMapping(value = "/details")
    @ResponseStatus(code = HttpStatus.OK)
    EggsChickenDetailedResponse getEggsAndChickenPerId(@PathVariable UUID idChicken);
    @GetMapping(value = "/list")
    @ResponseStatus(code = HttpStatus.OK)
    List<EggsRecordListResponse> getAllEggsRecords ();

}
