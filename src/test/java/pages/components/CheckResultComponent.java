package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckResultComponent {
    public void checkKeyValue(String key, String value) {
        String selector = String.format("//td[text()='%s']/following::td[text()='%s']", key, value);
        $x(selector).shouldBe(visible);
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

