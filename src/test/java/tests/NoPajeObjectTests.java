package tests;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class NoPajeObjectTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000;
    }

    @Test
    void formCreateStudent() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Arseny");
        $("#lastName").setValue("Bek");
        $("#userEmail").setValue("arb@sink.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8989777777");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1996");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--015").click();
        $("#subjectsInput").val("History").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("photography.png");
        $("#currentAddress").setValue("street road");
        $("#state").scrollTo().click();
        $("#react-select-3-input").val("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Delhi").pressEnter().pressTab().pressEnter();

        $x("//td[text()='Student Name']/following::td[text()='Arseny Bek']").shouldBe(visible);
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