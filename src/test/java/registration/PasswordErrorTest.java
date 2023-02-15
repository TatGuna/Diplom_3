package registration;

import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.RegisterPage;

public class PasswordErrorTest extends annotations.BaseTest{

    Faker faker = new Faker();

    @Test
    @DisplayName("Проверь ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shortPasswordError(){
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(faker.name().firstName());
        registerPage.inputEmail(faker.internet().emailAddress());
        registerPage.inputPassword(faker.internet().password(3, 5));
        registerPage.clickFinallyRegisterButton();
        registerPage.checkShortPasswordError();
    }
}
