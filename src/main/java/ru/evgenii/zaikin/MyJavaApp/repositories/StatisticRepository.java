package ru.evgenii.zaikin.MyJavaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evgenii.zaikin.MyJavaApp.entities.StatisticEntity;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface StatisticRepository extends JpaRepository<StatisticEntity, Long> {
    @Query(value = "SELECT * FROM statistic WHERE created_at BETWEEN CAST(? as Date) AND CAST(? as Date) AND statistic_type_id = ? AND statistic_profession_id = ?;", nativeQuery = true)
    public Optional<StatisticEntity> findStatisticBetweenDates(LocalDate startDate, LocalDate endDate, Long typeId, Long professionId);
}
