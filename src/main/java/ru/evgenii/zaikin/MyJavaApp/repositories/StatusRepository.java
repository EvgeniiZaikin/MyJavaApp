package ru.evgenii.zaikin.MyJavaApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.evgenii.zaikin.MyJavaApp.entities.StatusEntity;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long> {
    @Query(value="SELECT * FROM statuses WHERE status_value = 'idle'", nativeQuery = true)
    public Optional<StatusEntity> findIdleStatus();

    public Optional<StatusEntity> findStatusByValue(String status);
}
