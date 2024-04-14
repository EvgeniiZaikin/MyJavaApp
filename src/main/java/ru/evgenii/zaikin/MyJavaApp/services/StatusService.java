package ru.evgenii.zaikin.MyJavaApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evgenii.zaikin.MyJavaApp.entities.StatusEntity;
import ru.evgenii.zaikin.MyJavaApp.repositories.StatusRepository;

@Service
@RequiredArgsConstructor
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusEntity addStatus(StatusEntity status) {
        return statusRepository.save(status);
    }
}
