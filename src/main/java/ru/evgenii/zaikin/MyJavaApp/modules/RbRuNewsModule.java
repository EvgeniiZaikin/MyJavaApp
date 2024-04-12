package ru.evgenii.zaikin.MyJavaApp.modules;

import org.springframework.stereotype.Component;
import ru.evgenii.zaikin.MyJavaApp.core.NewsCore;

@Component
public class RbRuNewsModule extends NewsCore {
    public RbRuNewsModule() {
        super(new String[]{"https://rb.ru/tag/it/", "https://rb.ru/tag/technology/"}, "a.news-item__title", "https://rb.ru");
    }
}
