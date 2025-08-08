package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final String TITLE_TEXT = "Practice Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            phoneInput = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            adressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            stateSelect = $("#stateCity-wrapper"),
            cityDropdown = $("#city"),
            citySelect = $("#stateCity-wrapper"),
            submitSelect = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");


        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);


        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);


        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);


        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText("Other")).click();


        return this;
    }

    public RegistrationPage setPhone(String value) {
        phoneInput.setValue(value);


        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);


        return this;
    }

    public RegistrationPage varifyModalAppears() {
        registrationResultsModal.verifyModalAppears();


        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);


        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();


        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();


        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        pictureInput.uploadFromClasspath(value);


        return this;
    }

    public RegistrationPage setAdress(String value) {
        adressInput.setValue(value);


        return this;
    }

    public RegistrationPage setState(String value) {
        stateDropdown.click();
        stateSelect.$(byText("value")).click();


        return this;
    }

    public RegistrationPage setCity(String value) {
        cityDropdown.click();
        citySelect.$(byText("value")).click();


        return this;
    }

    public RegistrationPage setSubmit() {
        submitSelect.click();


        return this;
    }


}
