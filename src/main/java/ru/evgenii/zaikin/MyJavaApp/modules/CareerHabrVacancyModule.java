package ru.evgenii.zaikin.MyJavaApp.modules;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.evgenii.zaikin.MyJavaApp.dto.CareerHabrDto;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class CareerHabrVacancyModule {
    private final RestTemplate restTemplate;

    public Integer parse(String profession) {
        String url = "https://career.habr.com/api/frontend/vacancies?q=";
        ResponseEntity<CareerHabrDto> response = restTemplate.getForEntity(url + profession, CareerHabrDto.class);

        try {
            return Objects.requireNonNull(response.getBody()).getMeta().getTotalResults();
        } catch (Exception exception) {
            return 0;
        }
    }
}
