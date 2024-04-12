package ru.evgenii.zaikin.MyJavaApp.modules;

import org.springframework.stereotype.Component;
import ru.evgenii.zaikin.MyJavaApp.core.NewsCore;

@Component
public class RiaNewsModule extends NewsCore {
    public RiaNewsModule() {
        super(
            new String[]{"https://ria.ru/keyword_IT_kompanii/", "https://ria.ru/organization_Ministerstvo_svjazi_i_massovykh_kommunikacijj_RF/"},
            "a.list-item__title",
            ""
        );
    }
}
