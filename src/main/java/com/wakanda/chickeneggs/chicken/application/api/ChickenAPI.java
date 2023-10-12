package com.wakanda.chickeneggs.chicken.application.api;

import com.wakanda.chickeneggs.chicken.domain.Chicken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/chicken")
public interface ChickenAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ChickenResponse postChicken(@Valid @RequestBody ChickenRequest chickenrequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<ChickenListResponse> getAllChickens ();
}
