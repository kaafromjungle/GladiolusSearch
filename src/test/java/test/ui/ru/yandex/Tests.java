package test.ui.ru.yandex;

import io.qameta.allure.Description;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import test.ui.WebDriverSettings;
import test.ui.pageObject.YandexResultSearch;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings {
    @Test
    @Description(value = "Тест поиска Яндекс")
    public void checkWikiPage() {
        YandexResultSearch yandexPage = new YandexResultSearch(driver, "Гладиолус");
        List<Map<String, Object>> resultsSearch = yandexPage.getCollectResult();
        Steps.checkContainsLink(resultsSearch, "https://ru.wikipedia.org/");
    }

}
