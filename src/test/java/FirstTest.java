import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @Test
    public void demoTest(){
        open("http://duckduckgo.com/");
        $("#search_form_input_homepage").setValue("Kraków").pressEnter();
        $(byText("Oficjalny serwis miejski - Magiczny Kraków")).click();
        $("div[class='navigation__container']").shouldHave(Condition.text("Nasze miasto"));
    }
}
