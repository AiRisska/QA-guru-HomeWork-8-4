package wikiSelenide;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class homeWork2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void wikiShouldHaveSoftAssertions() {
        open("/selenide/selenide");
        // Найти вкладку Wiki, перейти на нее
        $("#wiki-tab").click();
        //в списке Pages проверить наличие Soft Assertions
        $("#wiki-pages-filter").setValue("Soft");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        //Перейти на страницу Soft Assertions
        $("#wiki-body").$(byText("Soft assertions")).click();
        //Проверить наличие кода для JUnit5
        $("#wiki-body").shouldHave(text("JUnit5 extend test"));

        sleep(10000);
    }
}
