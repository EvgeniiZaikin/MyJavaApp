package ru.evgenii.zaikin.MyJavaApp.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

@Data
public class HeadHunterDto implements Serializable {
    Integer found;
    ArrayList<HeadHunterVacancyDto> items;

    @Data
    public static class HeadHunterVacancyDto {
        HeadHunterVacancySalaryDto salary;

        @Data
        public static class HeadHunterVacancySalaryDto {
            Integer from;
            Integer to;
            String currency;
        }
    }
}
