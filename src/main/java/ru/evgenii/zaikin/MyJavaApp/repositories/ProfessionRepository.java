package ru.evgenii.zaikin.MyJavaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgenii.zaikin.MyJavaApp.entities.ProfessionEntity;

import java.util.Optional;

@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Long> {
    public Optional<ProfessionEntity> findByTitle(String title);
}
