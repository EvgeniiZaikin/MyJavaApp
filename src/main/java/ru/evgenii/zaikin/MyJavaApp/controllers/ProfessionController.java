package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgenii.zaikin.MyJavaApp.entities.ProfessionEntity;
import ru.evgenii.zaikin.MyJavaApp.services.ProfessionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profession")
public class ProfessionController {
    private final ProfessionService professionService;

    @PostMapping
    public ProfessionEntity addProfession(@RequestBody ProfessionEntity profession) {
        return professionService.addProfession(profession);
    }
}
