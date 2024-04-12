package ru.evgenii.zaikin.MyJavaApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evgenii.zaikin.MyJavaApp.entities.ProfessionEntity;
import ru.evgenii.zaikin.MyJavaApp.repositories.ProfessionRepository;

@Service
@RequiredArgsConstructor
public class ProfessionService {
    private final ProfessionRepository professionRepository;

    public ProfessionEntity addProfession(ProfessionEntity profession) {
        return professionRepository.save(profession);
    }
}
