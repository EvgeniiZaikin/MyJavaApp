package ru.evgenii.zaikin.MyJavaApp.modules;

import org.springframework.stereotype.Component;
import ru.evgenii.zaikin.MyJavaApp.core.NewsCore;

@Component
public class KommersantNewsModule extends NewsCore {
    public KommersantNewsModule() {
        super(new String[]{"https://www.kommersant.ru/theme/1225"}, "a.uho__link", "https://www.kommersant.ru");
    }
}
