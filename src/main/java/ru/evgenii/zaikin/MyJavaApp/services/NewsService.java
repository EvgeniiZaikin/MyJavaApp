package ru.evgenii.zaikin.MyJavaApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evgenii.zaikin.MyJavaApp.entities.NewsEntity;
import ru.evgenii.zaikin.MyJavaApp.models.NewsModel;
import ru.evgenii.zaikin.MyJavaApp.modules.CNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.HabrNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.ItWorldNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.KommersantNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.RbRuNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.RiaNewsModule;
import ru.evgenii.zaikin.MyJavaApp.repositories.NewsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsService {
    private final RbRuNewsModule rbRuNewsModule;
    private final CNewsModule cNewsModule;
    private final HabrNewsModule habrNewsModule;
    private final ItWorldNewsModule itWorldNewsModule;
    private final KommersantNewsModule kommersantNewsModule;
    private final RiaNewsModule riaNewsModule;

    private final NewsRepository newsRepository;

    public List<NewsEntity> parse() {
        ArrayList<NewsModel> news = new ArrayList<>();

        news.addAll(rbRuNewsModule.parse());
        news.addAll(cNewsModule.parse());
        news.addAll(habrNewsModule.parse());
        news.addAll(itWorldNewsModule.parse());
        news.addAll(kommersantNewsModule.parse());
        news.addAll(riaNewsModule.parse());

        ArrayList<NewsEntity> savedNews = new ArrayList<>();
        news.forEach((NewsModel item) -> {
            savedNews.add(newsRepository.saveNewsItem(item.getTitle(), item.getUrl()));
        });

        return savedNews;
    }

    public List<NewsEntity> getAllNews() {
        return newsRepository.findAll();
    }
}
