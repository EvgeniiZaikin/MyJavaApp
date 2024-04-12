package ru.evgenii.zaikin.MyJavaApp.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TrudVsemDto implements Serializable {
    TrudVsemMetaDto meta;

    @Data
    public static class TrudVsemMetaDto {
        Integer total;
    }
}
