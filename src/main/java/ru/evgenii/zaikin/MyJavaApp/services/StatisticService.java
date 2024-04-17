package ru.evgenii.zaikin.MyJavaApp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.evgenii.zaikin.MyJavaApp.entities.ProfessionEntity;
import ru.evgenii.zaikin.MyJavaApp.entities.StatisticEntity;
import ru.evgenii.zaikin.MyJavaApp.entities.TypeEntity;
import ru.evgenii.zaikin.MyJavaApp.modules.CareerHabrVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.modules.HeadHunterSalaryModule;
import ru.evgenii.zaikin.MyJavaApp.modules.HeadHunterVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.modules.TrudVsemVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.modules.ZarplataRuVacancyModule;
import ru.evgenii.zaikin.MyJavaApp.repositories.ProfessionRepository;
import ru.evgenii.zaikin.MyJavaApp.repositories.StatisticRepository;
import ru.evgenii.zaikin.MyJavaApp.repositories.TypeRepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatisticService {
    private final HeadHunterSalaryModule headHunterSalaryModule;

    private final HeadHunterVacancyModule headHunterVacancyModule;
    private final CareerHabrVacancyModule careerHabrVacancyModule;
    private final TrudVsemVacancyModule trudVsemVacancyModule;
    private final ZarplataRuVacancyModule zarplataRuVacancyModule;

    private final ProfessionRepository professionRepository;
    private final StatisticRepository statisticRepository;
    private final TypeRepository typeRepository;

    public List<StatisticEntity> getStatisticByType(String type) {
        TypeEntity typeEntity = typeRepository.findByType(type).orElseThrow();
        Timestamp timestamp = Timestamp.valueOf(LocalDate.now().withDayOfMonth(1).atStartOfDay());
        return statisticRepository.findAllByTypeAndCreatedAtGreaterThanEqualOrderByValueDesc(typeEntity, timestamp);
    }

    public List<StatisticEntity> findStatisticByProfessionAndType(Long professionId, String type) {
        TypeEntity typeEntity = typeRepository.findByType(type).orElseThrow();
        ProfessionEntity profession = professionRepository.findById(professionId).orElseThrow();
        return statisticRepository.findAllByProfessionAndTypeOrderByCreatedAtDesc(profession, typeEntity);
    }

    public Map<String, Integer> parseSalary() {
        Map<String, Integer> result = new HashMap<>();

        List<ProfessionEntity> professions = professionRepository.findAll();

        for (ProfessionEntity item : professions) {
            if (checkStatisticExists("salary", item.getId())) {
                result.put(item.getTitle(), null);
            } else {
//                Integer salary = headHunterSalaryModule.parse(item.getParseValue());
//                StatisticEntity statistic = createStatisticEntity("salary", item, salary);
//                StatisticEntity savedStatistic = statisticRepository.save(statistic);
//                result.put(savedStatistic.getProfession().getTitle(), savedStatistic.getValue());
            }
        }

        return result;
    }

    public Map<String, Integer> parseVacancy() {
        Map<String, Integer> result = new HashMap<>();

        List<ProfessionEntity> professions = professionRepository.findAll();

        for (ProfessionEntity item : professions) {
            if (checkStatisticExists("salary", item.getId())) {
                result.put(item.getTitle(), null);
            } else {
                Integer total = 0;

//                total += headHunterVacancyModule.parse(item.getParseValue());
//                total += careerHabrVacancyModule.parse(item.getParseValue());
//                total += trudVsemVacancyModule.parse(item.getParseValue());
//                total += zarplataRuVacancyModule.parse(item.getParseValue());

                StatisticEntity statistic = createStatisticEntity("vacancy", item, total);
                StatisticEntity savedStatistic = statisticRepository.save(statistic);
                result.put(savedStatistic.getProfession().getTitle(), savedStatistic.getValue());
            }
        }

        return result;
    }

    private StatisticEntity createStatisticEntity(String type, ProfessionEntity profession, Integer value) {
        StatisticEntity statistic = new StatisticEntity();

        statistic.setType(typeRepository.findByType(type).orElseThrow());
        statistic.setProfession(professionRepository.findByTitle(profession.getTitle()).orElseThrow());
        statistic.setValue(value);

        return statistic;
    }

    private boolean checkStatisticExists(String type, Long professionId) {
        TypeEntity typeEntity = typeRepository.findByType(type).orElseThrow();

        Optional<StatisticEntity> exists = statisticRepository.findStatisticBetweenDates(
            LocalDate.now().withDayOfMonth(1),
            LocalDate.now().withDayOfMonth(1).plusMonths(1),
            typeEntity.getId(),
            professionId
        );

        return exists.isPresent();
    }
}
