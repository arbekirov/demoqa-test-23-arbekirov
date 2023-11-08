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
                .setDateOfBirth("15", "May","1996");
        $("#subjectsInput").val("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photography.png");
        $("#currentAddress").setValue("street road");
        $("#state").scrollTo().click();
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Delhi").pressEnter().pressTab().pressEnter();

        $x("//td[text()='Student Name']/following::td[text()='Arseny Bek']").shouldBe(visible);
        registrationPage.checkResult("Student Name", "Arseny Bek")
                .checkResult("Student Email", "arb@sink.com");
        $x("//td[text()='Student Email']/following::td[text()='arb@sink.com']").shouldBe(visible);
        $x("//td[text()='Gender']/following::td[text()='Male']").shouldBe(visible);
        $x("//td[text()='Mobile']/following::td[text()='8989777777']").shouldBe(visible);
        $x("//td[text()='Date of Birth']/following::td[text()='15 May,1996']").shouldBe(visible);
        $x("//td[text()='Subjects']/following::td[text()='History']").shouldBe(visible);
        $x("//td[text()='Hobbies']/following::td[text()='Sports']").shouldBe(visible);
        $x("//td[text()='Picture']/following::td[text()='photography.png']").shouldBe(visible);
        $x("//td[text()='Address']/following::td[text()='street road']").shouldBe(visible);
        $x("//td[text()='State and City']/following::td[text()='NCR Delhi']").shouldBe(visible);
    }
}