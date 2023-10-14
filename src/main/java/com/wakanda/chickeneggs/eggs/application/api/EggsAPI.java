package com.wakanda.chickeneggs.eggs.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/chicken/{idChicken}/eggs")
public interface EggsAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    EggsResponse postEggs(@PathVariable UUID idChicken,
                                      @Valid @RequestBody EggsRequest eggsRequest);


}
