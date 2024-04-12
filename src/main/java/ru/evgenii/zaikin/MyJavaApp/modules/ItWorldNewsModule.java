package ru.evgenii.zaikin.MyJavaApp.modules;

import org.springframework.stereotype.Component;
import ru.evgenii.zaikin.MyJavaApp.core.NewsCore;

@Component
public class ItWorldNewsModule extends NewsCore {
    public ItWorldNewsModule() {
        super(new String[]{"https://www.it-world.ru/news/"}, ".news__content > a", "https://www.it-world.ru");
    }
}
