package ru.evgenii.zaikin.MyJavaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.evgenii.zaikin.MyJavaApp.entities.TypeEntity;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
    public Optional<TypeEntity> findByType(String type);
}
