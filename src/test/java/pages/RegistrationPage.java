package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

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
            CalendarInput = $("#dateOfBirthInput"),
            SubjectsInput = $("#subjectsInput"),
            HobbiesWrapperInput = $("#hobbiesWrapper"),
            UploadPictureInput = $("#uploadPicture"),
            AdressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            CheckResultInput = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

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

    public RegistrationPage setSubject(String value) {
        SubjectsInput.val(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        HobbiesWrapperInput.$(byText(value)).click();

        return this;

    }
    public RegistrationPage  setUploadPicture(String value) {
        UploadPictureInput.uploadFromClasspath(value);

        return this;

    }
    public RegistrationPage setAddress(String value) {
        AdressInput.setValue(value);

        return this;

    }

    public RegistrationPage setStateAndCity(String state, String city) {
        stateDropdown.scrollTo().click();
        stateInput.val(state).pressEnter();
        cityDropdown.click();
        cityInput.val(city).pressEnter().pressTab().pressEnter();

        return this;

    }
    public RegistrationPage checkResult(String key, String value) {
        CheckResultInput.$(byText(key)).parent().shouldHave(text(value));
        checkResultComponent.checkKeyValue(key, value);


        return this;
    }
}
