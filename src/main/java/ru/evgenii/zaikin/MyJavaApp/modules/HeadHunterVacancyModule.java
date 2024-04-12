package ru.evgenii.zaikin.MyJavaApp.modules;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.evgenii.zaikin.MyJavaApp.dto.HeadHunterDto;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class HeadHunterVacancyModule {
    private final RestTemplate restTemplate;

    public Integer parse(String profession) {
        String url = "https://api.hh.ru/vacancies?area=113&search_field=name&text=";
        ResponseEntity<HeadHunterDto> response = restTemplate.getForEntity(url + profession, HeadHunterDto.class);

        try {
            return Objects.requireNonNull(response.getBody()).getFound();
        } catch (Exception exception) {
            return 0;
        }
    }
}
