package tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import pageObject.ContactUsPage;

public class ContactFormTest {

    ContactUsPage contactUsPage = new ContactUsPage();
    Faker faker = new Faker();

    @Test
    public void testContactFormWithBasicData(){
        contactUsPage
                .goTo()
                .sendFormWithBasicData("Webmaster","test@test.com",faker.lorem().paragraph())
                .assertThatAlertSuccessContainsGivenText("Your message has been successfully sent to our team.");
    }
}
