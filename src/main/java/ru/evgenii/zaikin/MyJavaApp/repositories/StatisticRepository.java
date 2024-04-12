package ru.evgenii.zaikin.MyJavaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgenii.zaikin.MyJavaApp.entities.StatisticEntity;

@Repository
public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {
}
