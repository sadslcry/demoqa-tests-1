import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithCommentsTest {

    @BeforeAll()
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.pageLoadStrategy = "eager";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest() {
        String userName = "Oleg";

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(userName);
        $("#lastName").setValue("Olegov");
        $("#userEmail").setValue("olegolegovich@gmail.com");
        $("#userNumber").setValue("1234567890");
//        $("#gender-radio-3").click(); // wrong
//        $("#gender-radio-3").parent().click(); // good
//        $("label[for=gender-radio-3]").click(); // good
        $("#genterWrapper").$(byText("Other")).click(); // best
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
//        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__year-select").selectOption("2010");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("img/1.png");
//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
        $("#currentAddress").setValue("Some adrdress 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(userName), text("Olegov"),
                text("olegolegovich@gmail.com"), text("1234567890"), text("Music"));


    }
}
