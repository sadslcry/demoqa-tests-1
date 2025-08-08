package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class PracticeFormTestWithPageObjectsTest extends TestBase {


    @Test
    void successfulRegistrationTest() {
        String userName = "Oleg";
        String userLastName = "Olegov";
        String userEmail = "olegolegovich@gmail.com";
        String userGender = "Other";
        String userPhone = "1234567890";
        String userBirthDay = "30";
        String userBirthMonth = "May";
        String userBirthYear = "2010";
        String userSubjects = "Math";
        String userHobbies = "Music";
        String userPicture = "img/1.png";
        String userAddress = "Some adrdress 1";
        String userState = "NCR";
        String userCity = "Delhi";


        registrationPage.openPage()
                .setFirstName(userName)
                .setLastName(userLastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDate(userBirthDay, userBirthMonth, userBirthYear)
                .setSubjects(userSubjects)
                .setHobbies(userHobbies)
                .uploadPicture(userPicture)
                .setAdress(userAddress)
                .setState(userState)
                .setCity(userCity)
                .setSubmit();

        registrationPage.varifyModalAppears()
                .verifyResult("Student Name", userName + " " + userLastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", userGender)
                .verifyResult("Mobile", userPhone)
                .verifyResult("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear);

    }
}
