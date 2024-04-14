package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgenii.zaikin.MyJavaApp.entities.StatisticEntity;
import ru.evgenii.zaikin.MyJavaApp.services.StatisticService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping("/{professionId}/{type}")
    public ResponseEntity<List<StatisticEntity>> getStatisticByProfession(
        @PathVariable("professionId") Long professionId,
        @PathVariable("type") String type
    ) {
        return ResponseEntity.ok(statisticService.findStatisticByProfession(professionId, type));
    }

    @GetMapping("/parse/salary")
    public ResponseEntity<Map<String, Integer>> parseSalary() {
        return ResponseEntity.ok(statisticService.parseSalary());
    }

    @GetMapping("/parse/vacancy")
    public ResponseEntity<Map<String, Integer>> parseVacancy() {
        return ResponseEntity.ok(statisticService.parseVacancy());
    }
}
