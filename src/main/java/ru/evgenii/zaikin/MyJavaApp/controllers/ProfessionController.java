package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.evgenii.zaikin.MyJavaApp.entities.ProfessionEntity;
import ru.evgenii.zaikin.MyJavaApp.services.ProfessionService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profession")
public class ProfessionController {
    private final ProfessionService professionService;

    @GetMapping("/list")
    public String getProfessionList(Model model) {
        List<ProfessionEntity> professionEntityList = professionService.getProfessionList();
        model.addAttribute("data", professionEntityList);
        return "profession-list";
    }

    @PostMapping
    public ProfessionEntity addProfession(@RequestBody ProfessionEntity profession) {
        return professionService.addProfession(profession);
    }
}
