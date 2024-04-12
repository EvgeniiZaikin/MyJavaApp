package ru.evgenii.zaikin.MyJavaApp.modules;

import org.springframework.stereotype.Component;
import ru.evgenii.zaikin.MyJavaApp.core.NewsCore;

@Component
public class HabrNewsModule extends NewsCore {
    public HabrNewsModule() {
        super(new String[]{"https://habr.com/ru/news/"}, "a.tm-title__link", "https://habr.com");
    }
}