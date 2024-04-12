package ru.evgenii.zaikin.MyJavaApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evgenii.zaikin.MyJavaApp.entities.ProfessionEntity;
import ru.evgenii.zaikin.MyJavaApp.entities.StatisticEntity;
import ru.evgenii.zaikin.MyJavaApp.entities.TypeEntity;
import ru.evgenii.zaikin.MyJavaApp.modules.CareerHabrVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.modules.HeadHunterVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.modules.TrudVsemVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.modules.ZarplataRuVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.repositories.ProfessionRepository;
import ru.evgenii.zaikin.MyJavaApp.repositories.StatisticRepository;
import ru.evgenii.zaikin.MyJavaApp.repositories.TypeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final HeadHunterVacancyModule headHunterVacancyModule;
    private final CareerHabrVacancyModule careerHabrVacancyModule;
    private final TrudVsemVacancyModule trudVsemVacancyModule;
    private final ZarplataRuVacancyModule zarplataRuVacancyModule;

    private final ProfessionRepository professionRepository;
    private final StatisticRepository statisticRepository;
    private final TypeRepository typeRepository;

    public Map<String, Integer> parseVacancy() {
        Map<String, Integer> result = new HashMap<>();

        List<ProfessionEntity> professions = professionRepository.findAll();

        for (ProfessionEntity item : professions) {
            Integer total = 0;

            total += headHunterVacancyModule.parse(item.getParseValue());
            total += careerHabrVacancyModule.parse(item.getParseValue());
            total += trudVsemVacancyModule.parse(item.getParseValue());
            total += zarplataRuVacancyModule.parse(item.getParseValue());

            TypeEntity type = typeRepository.findByType("vacancy").orElseThrow();
            ProfessionEntity profession = professionRepository.findByTitle(item.getTitle()).orElseThrow();

            StatisticEntity statistic = new StatisticEntity();
            statistic.setType(type);
            statistic.setProfession(profession);
            statistic.setValue(total);

            StatisticEntity savedStatistic = statisticRepository.save(statistic);
            result.put(savedStatistic.getProfession().getTitle(), savedStatistic.getValue());
        }

        return result;
    }
}
