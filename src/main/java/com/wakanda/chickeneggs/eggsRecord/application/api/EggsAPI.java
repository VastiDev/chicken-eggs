package com.wakanda.chickeneggs.eggsRecord.application.api;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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

    @DeleteMapping(value = "chicken/{idChicken}/eggs/{idEggsRecord}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteEggsRecord(@PathVariable UUID idChicken, @PathVariable UUID idEggsRecord);

    @GetMapping(value = "listAll")
    @ResponseStatus(code = HttpStatus.OK)
    List<ListTotalEggsRecords> getAllEggsRecords();

    @GetMapping(value = "averageInPeriod")
    @ResponseStatus(code = HttpStatus.OK)
    AverageEggsInPeriod getAverageEggsInPeriod
            (@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
             LocalDate startDate,
             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping(value = "totalEggsperDate/chicken/{idChicken}")
    @ResponseStatus(code = HttpStatus.OK)
    TotalEggsperChickenperDate getTotalEggs
            (@PathVariable UUID idChicken, @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate startDate,
             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);


}
