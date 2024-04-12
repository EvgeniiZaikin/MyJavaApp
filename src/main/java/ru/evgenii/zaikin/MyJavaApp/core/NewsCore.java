package ru.evgenii.zaikin.MyJavaApp.core;

import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.evgenii.zaikin.MyJavaApp.models.NewsModel;

import java.util.ArrayList;

@RequiredArgsConstructor
public class NewsCore {
    private final String[] urls;
    private final String selector;
    private final String prefix;

    public ArrayList<NewsModel> parse() {
        ArrayList<NewsModel> news = new ArrayList<>();

        for (String url : urls) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements elements = doc.select(selector);
                for (Element item : elements) {
                    String title = item.text();
                    String href = prefix + item.attr("href");
                    news.add(NewsModel.builder().title(title).url(href).build());
                }
            } catch (Exception exception) {
                System.out.println("Error");
            }
        }

        return news;
    }
}
