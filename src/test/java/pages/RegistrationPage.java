package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import java.security.PublicKey;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            UserEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            UserNumberInput = $("#userNumber"),
            CalendarInput = $("#dateOfBirthInput");

    CalendarComponent calendarComponent = new CalendarComponent();
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        UserEmailInput.setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value) {
        genderWrapperInput.$(byText(value)).click();

        return this;

    }
    public RegistrationPage setUserNumber(String value) {
        UserNumberInput.setValue(value);

        return this;

    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        CalendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}
