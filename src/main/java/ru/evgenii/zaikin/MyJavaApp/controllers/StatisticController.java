package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgenii.zaikin.MyJavaApp.services.StatisticService;

import java.util.Map;

@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping("/parse/vacancy")
    public ResponseEntity<Map<String, Integer>> parseVacancy() {
        return ResponseEntity.ok(statisticService.parseVacancy());
    }
}
