package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.evgenii.zaikin.MyJavaApp.entities.NewsEntity;
import ru.evgenii.zaikin.MyJavaApp.services.NewsService;

import java.util.List;

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/parse")
    public ResponseEntity<List<NewsEntity>> parse() {
        return ResponseEntity.ok(newsService.parse());
    }

    @GetMapping("/all")
    public ResponseEntity<List<NewsEntity>> getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());
    }
}
