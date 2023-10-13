package com.wakanda.chickeneggs.eggs.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/chicken/{idChicken}/eggs")
public interface DailyEggsRecordAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EggsRecordResponse postEggsRecord(@PathVariable UUID idChicken,
                                      @Valid  EggsRecordRequest eggsRecordRequest);


}
