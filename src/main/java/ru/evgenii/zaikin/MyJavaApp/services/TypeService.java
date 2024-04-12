package ru.evgenii.zaikin.MyJavaApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evgenii.zaikin.MyJavaApp.entities.TypeEntity;
import ru.evgenii.zaikin.MyJavaApp.repositories.TypeRepository;

@Service
@RequiredArgsConstructor
public class TypeService {
    private final TypeRepository typeRepository;

    public TypeEntity addType(TypeEntity type) {
        return typeRepository.save(type);
    }
}
