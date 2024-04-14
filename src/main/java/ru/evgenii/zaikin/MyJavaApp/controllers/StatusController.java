package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgenii.zaikin.MyJavaApp.entities.StatusEntity;
import ru.evgenii.zaikin.MyJavaApp.services.StatusService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;

    @PostMapping
    public ResponseEntity<StatusEntity> addStatus(@RequestBody StatusEntity status) {
        return ResponseEntity.ok(statusService.addStatus(status));
    }
}
