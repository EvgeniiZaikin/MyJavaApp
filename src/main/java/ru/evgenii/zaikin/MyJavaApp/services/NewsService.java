package ru.evgenii.zaikin.MyJavaApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evgenii.zaikin.MyJavaApp.entities.NewsEntity;
import ru.evgenii.zaikin.MyJavaApp.entities.StatusEntity;
import ru.evgenii.zaikin.MyJavaApp.models.NewsModel;
import ru.evgenii.zaikin.MyJavaApp.modules.CNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.HabrNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.ItWorldNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.KommersantNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.RbRuNewsModule;
import ru.evgenii.zaikin.MyJavaApp.modules.RiaNewsModule;
import ru.evgenii.zaikin.MyJavaApp.repositories.NewsRepository;
import ru.evgenii.zaikin.MyJavaApp.repositories.StatusRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    private final StatusRepository statusRepository;

    public List<NewsEntity> parse() {
        StatusEntity idleStatus = statusRepository.findIdleStatus().orElseThrow();

        ArrayList<NewsModel> news = new ArrayList<>();

        news.addAll(rbRuNewsModule.parse());
        news.addAll(cNewsModule.parse());
        news.addAll(habrNewsModule.parse());
        news.addAll(itWorldNewsModule.parse());
        news.addAll(kommersantNewsModule.parse());
        news.addAll(riaNewsModule.parse());

        ArrayList<NewsEntity> savedNews = new ArrayList<>();
        news.forEach((NewsModel item) -> {
            savedNews.add(newsRepository.saveNewsItem(item.getTitle(), item.getUrl(), idleStatus.getId()));
        });

        return savedNews;
    }

    public List<NewsEntity> getAllNews() {
        return newsRepository.findAll();
    }

    public List<NewsEntity> updateNewsStatuses(List<NewsEntity> news) {
        List<StatusEntity> statuses = statusRepository.findAll();

        for (NewsEntity item : news) {
            statuses.stream()
                .filter(elem -> Objects.equals(elem.getValue(), item.getStatus().getValue()))
                .findFirst()
                .ifPresent(item::setStatus);
        }

        return newsRepository.saveAll(news);
    }

    public NewsEntity updateNewsStatus(Long newsId, String status) {
        StatusEntity statusEntity = statusRepository.findStatusByValue(status).orElseThrow();
        NewsEntity newsEntity = newsRepository.findById(newsId).orElseThrow();
        newsEntity.setStatus(statusEntity);
        return newsRepository.save(newsEntity);
    }

    public List<NewsEntity> getNewsByStatus(String status) {
        return newsRepository.findAllByStatusValueIs(status);
    }
}
