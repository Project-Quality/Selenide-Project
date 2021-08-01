package tests;

import org.testng.annotations.Test;
import pageObject.ContactUsPage;

public class ContactFormTest {

    ContactUsPage contactUsPage = new ContactUsPage();

    @Test
    public void testContactFormWithBasicData(){
        contactUsPage
                .goTo()
                .sendFormWithBasicData("Webmaster","test@test.com","Lorem ipsum")
                .assertThatAlertSuccessContainsGivenText("Your message has been successfully sent to our team.");
    }
}
