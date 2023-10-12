package com.wakanda.chickeneggs.chicken.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/chicken")
public interface ChickenAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ChickenResponse postChicken(@RequestBody ChickenRequest chickenrequest);
}
