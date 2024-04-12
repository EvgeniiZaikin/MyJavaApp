package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgenii.zaikin.MyJavaApp.entities.TypeEntity;
import ru.evgenii.zaikin.MyJavaApp.services.TypeService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/type")
public class TypeController {
    private final TypeService typeService;

    @PostMapping
    public TypeEntity addType(@RequestBody TypeEntity type) {
        return typeService.addType(type);
    }
}
