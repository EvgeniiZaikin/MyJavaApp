package ru.evgenii.zaikin.MyJavaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evgenii.zaikin.MyJavaApp.entities.NewsEntity;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity, Long> {
    @Query(value = "INSERT INTO news (new_title, new_url, new_status_id) VALUES (?, ?, ?) ON CONFLICT DO NOTHING RETURNING *;", nativeQuery = true)
    NewsEntity saveNewsItem(String title, String url, Long statusId);
}
