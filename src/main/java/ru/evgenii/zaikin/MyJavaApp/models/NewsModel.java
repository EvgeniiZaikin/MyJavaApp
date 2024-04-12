package ru.evgenii.zaikin.MyJavaApp.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class NewsModel {
    String title;
    String url;
}
