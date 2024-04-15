package ru.evgenii.zaikin.MyJavaApp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.evgenii.zaikin.MyJavaApp.entities.NewsEntity;
import ru.evgenii.zaikin.MyJavaApp.services.NewsService;

import java.util.List;

@Controller
@RequestMapping("/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping("/{status}")
    public String news(@PathVariable String status, Model model) {
        List<NewsEntity> news = newsService.getNewsByStatus(status);
        model.addAttribute("news", news);
        return "news";
    }

    @PutMapping("/api/{newsId}/{status}")
    public ResponseEntity<NewsEntity> updateNewsStatus(
        @PathVariable("newsId") Long newsId,
        @PathVariable("status") String status
    ) {
        return ResponseEntity.ok(newsService.updateNewsStatus(newsId, status));
    }

    @PostMapping("/api/parse")
    public ResponseEntity<List<NewsEntity>> parse() {
        return ResponseEntity.ok(newsService.parse());
    }

    @GetMapping("/api/all")
    public ResponseEntity<List<NewsEntity>> getAllNews(@RequestParam(value="status", required=false) String status) {
        if (status == null) return ResponseEntity.ok(newsService.getAllNews());
        else return ResponseEntity.ok(newsService.getNewsByStatus(status));
    }

    @PutMapping("/api/all/statuses")
    public ResponseEntity<List<NewsEntity>> updateNewsStatuses(@RequestBody List<NewsEntity> news) {
        return ResponseEntity.ok(newsService.updateNewsStatuses(news));
    }
}
