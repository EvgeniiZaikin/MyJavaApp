package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evgenii.zaikin.MyJavaApp.entities.StatisticEntity;
import ru.evgenii.zaikin.MyJavaApp.services.StatisticService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/statistic")
@RequiredArgsConstructor
public class StatisticController {
    private final StatisticService statisticService;

    @GetMapping("/{type}")
    public String getStatisticByType(@PathVariable String type, Model model) {
        List<StatisticEntity> statistic = statisticService.getStatisticByType(type);
        model.addAttribute("statistic", statistic);
        return "statistic";
    }

    @GetMapping("/{professionId}/{type}")
    public String getStatisticByProfessionAndType(
        @PathVariable("professionId") Long professionId,
        @PathVariable("type") String type,
        Model model
    ) {
        List<StatisticEntity> statistic = statisticService.findStatisticByProfessionAndType(professionId, type);
        model.addAttribute("statistic", statistic);
        return "statistic";
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
