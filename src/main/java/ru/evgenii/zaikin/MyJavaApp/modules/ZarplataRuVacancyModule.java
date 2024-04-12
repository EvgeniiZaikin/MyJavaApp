package ru.evgenii.zaikin.MyJavaApp.modules;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.evgenii.zaikin.MyJavaApp.dto.ZarplataRuDto;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ZarplataRuVacancyModule {
    private final RestTemplate restTemplate;

    public Integer parse(String profession) {
        String url = "https://api.zarplata.ru/vacancies?text=";
        ResponseEntity<ZarplataRuDto> response = restTemplate.getForEntity(url + profession, ZarplataRuDto.class);

        try {
            return Objects.requireNonNull(response.getBody()).getFound();
        } catch (Exception exception) {
            return 0;
        }
    }
}
