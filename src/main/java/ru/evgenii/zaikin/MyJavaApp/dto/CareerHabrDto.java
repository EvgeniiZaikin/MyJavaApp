package ru.evgenii.zaikin.MyJavaApp.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CareerHabrDto implements Serializable {
    CareerHabrMetaDto meta;

    @Data
    public static class CareerHabrMetaDto {
        Integer totalResults;
    }
}