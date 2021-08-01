package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ContactUsPage {

    private SelenideElement subjectHeading = $("#id_contact"),
            inputEmail = $("#email"),
            textareaMessage = $("#message"),
            submitButton = $("#submitMessage"),
            alertSuccess = $("p[class='alert alert-success']");

    public ContactUsPage goTo(){
        open("http://automationpractice.com/index.php?controller=contact");
        return this;
    }

    private ElementsCollection getSubjectHeading(){
        return $$("#id_contact>option");
    }

    public ContactUsPage sendFormWithBasicData(String subjectMessage, String email, String messageContent) {
        subjectHeading.click();
        getSubjectHeading().findBy(text((subjectMessage))).click();
        inputEmail.setValue(email);
        textareaMessage.setValue(messageContent);
        submitButton.click();
        return this;
    }

    public ContactUsPage assertThatAlertSuccessContainsGivenText(String expectedAlertText) {
        alertSuccess.shouldHave(text(expectedAlertText));
        return this;
    }

}
