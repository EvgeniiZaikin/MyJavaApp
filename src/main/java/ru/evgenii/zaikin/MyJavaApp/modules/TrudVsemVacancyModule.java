package ru.evgenii.zaikin.MyJavaApp.modules;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.evgenii.zaikin.MyJavaApp.dto.TrudVsemDto;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class TrudVsemVacancyModule {
    private final RestTemplate restTemplate;

    public Integer parse(String profession) {
        String url = "http://opendata.trudvsem.ru/api/v1/vacancies?text=";
        ResponseEntity<TrudVsemDto> response = restTemplate.getForEntity(url + profession, TrudVsemDto.class);

        try {
            return Objects.requireNonNull(response.getBody()).getMeta().getTotal();
        } catch (Exception exception) {
            return 0;
        }
    }
}
