package com.wakanda.chickeneggs.eggsRecord.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/eggsRecord/")
public interface EggsAPI {
    @PostMapping("chicken/{idChicken}")
    @ResponseStatus(code = HttpStatus.CREATED)
    EggsRecordResponse postEggsRecord(@PathVariable UUID idChicken,
                          @Valid @RequestBody EggsRecordRequest eggsRecordRequest);

   @GetMapping(value = "chicken/{idChicken}")
    @ResponseStatus(code = HttpStatus.OK)
    List<EggsRecordListResponse> getAllEggsPerChicken(@PathVariable UUID idChicken);

    @GetMapping(value = "chicken/{idChicken}/eggs/{idEggsRecord}")
    @ResponseStatus(code = HttpStatus.OK)
    EggsChickenDetailsResponse getDetailedEggsFromChicken(@PathVariable UUID idChicken, @PathVariable UUID idEggsRecord);

    @DeleteMapping(value = "chicken/{idChicken}/eggs/{idEggsRecord}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteEggsRecord(@PathVariable UUID idChicken, @PathVariable UUID idEggsRecord);

    @GetMapping(value = "listAll")
    @ResponseStatus(code = HttpStatus.OK)
    List<listTotalEggsRecords> getAllEggsRecords();
}
