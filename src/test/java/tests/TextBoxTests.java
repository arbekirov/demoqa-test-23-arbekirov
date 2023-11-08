package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void formCreateStudent() {
        registrationPage.openPage()
                .setFirstName("Arseny")
                .setLastName("Bek")
                .setEmail("arb@sink.com")
                .setGender("Male")
                .setUserNumber("8989777777")
                .setDateOfBirth("15", "May","1996")
                .setSubject("History")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("photography.png")
                .setAddress("street road")
                .setStateAndCity("NCR","Delhi");


        registrationPage.checkResult("Student Name", "Arseny Bek")
                .checkResult("Student Email", "arb@sink.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8989777777")
                .checkResult("Date of Birth", "15 May,1996")
                .checkResult("Subjects", "History")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "photography.png")
                .checkResult("Address", "street road")
                .checkResult("State and City", "NCR Delhi");
    }
}