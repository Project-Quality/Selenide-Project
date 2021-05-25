import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

    @Test
    public void testContentInNavigation(){
        open("http://duckduckgo.com/");
        $("#search_form_input_homepage").setValue("Kraków").pressEnter();
        $(byText("Oficjalny serwis miejski - Magiczny Kraków")).click();
        $("div[class='navigation__container']").shouldHave(Condition.text("Nasze miasto"));
    }

    @Test
    public void  testSizeItemsInArticleContainer(){
        open("https://www.krakow.pl/");
        $$("div[class='tiles-container__list']>a>h4").shouldHaveSize(16);
    }

    @Test
    public void testPageTitle(){
        open("https://www.krakow.pl/");
        Assert.assertEquals(Selenide.title(),"Oficjalny serwis miejski - Magiczny Kraków");
    }
}
