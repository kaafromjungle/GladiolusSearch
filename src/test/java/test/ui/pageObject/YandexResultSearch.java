package test.ui.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class YandexResultSearch {

    private String selectorSearchItem = "//h2[@class=\"organic__title-wrapper typo typo_text_l typo_line_m\"]";
    private String selectorUrl = "./a[@href]";

    private WebDriver driver;
    private List<WebElement> webSearchItem = new ArrayList();
    private List<Map<String, Object>> collectResult = new ArrayList<>();

    public YandexResultSearch(WebDriver driver, String search){
        this.driver = driver;
        driver.get("https://www.yandex.ru/search/?text="+search);
        webSearchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public YandexResultSearch(WebDriver driver){
        this.driver = driver;
        webSearchItem = driver.findElements(By.xpath(selectorSearchItem));
    }

    public List<Map<String, Object>> getCollectResult() {
        for(WebElement result : webSearchItem){
            collectResult.add(Map.of(
                    "WEB_ELEMENT", result,
                    "URL", result.findElement(By.xpath(selectorUrl)).getAttribute("href")
            ));
        }
        return collectResult;
    }

}
