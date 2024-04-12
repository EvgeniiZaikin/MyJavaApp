package ru.evgenii.zaikin.MyJavaApp.modules;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.evgenii.zaikin.MyJavaApp.dto.HeadHunterDto;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class HeadHunterSalaryModule {
    private final RestTemplate restTemplate;

    public Integer parse(String profession) {
        String url = "https://api.hh.ru/vacancies?area=113&search_field=name&only_with_salary=true&per_page=100&text=";

        try {
            ResponseEntity<HeadHunterDto> response = restTemplate.getForEntity(url + profession, HeadHunterDto.class);
            if (response.getBody() == null) return 0;

            AtomicInteger count = new AtomicInteger();
            AtomicInteger total = new AtomicInteger();
            response.getBody().getItems().forEach(item -> {
                Integer from = item.getSalary().getFrom();
                Integer to = item.getSalary().getTo();

                if (Objects.equals(item.getSalary().getCurrency(), "RUR")) {
                    if (to == null) {
                        if (from != null) {
                            count.getAndIncrement();
                            total.addAndGet(from);
                        }
                    } else {
                        count.getAndIncrement();
                        total.addAndGet(to);
                    }
                }
            });

            if (total.get() > 0 && count.get() > 0) {
                return total.get() / count.get();
            } else {
                return 0;
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return 0;
        }
    }
}
