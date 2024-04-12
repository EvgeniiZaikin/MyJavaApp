package ru.evgenii.zaikin.MyJavaApp.modules;

import org.springframework.stereotype.Component;
import ru.evgenii.zaikin.MyJavaApp.core.NewsCore;

@Component
public class CNewsModule extends NewsCore {
    public CNewsModule() {
        super(new String[]{"https://www.cnews.ru/"}, ".tabs_item li a:first-child", "");
    }
}
