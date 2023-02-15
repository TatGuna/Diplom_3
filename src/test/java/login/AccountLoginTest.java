package login;

import org.example.pom.LoginPage;
import org.example.pom.MainPage;
import org.example.pom.ProfilePage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountLoginTest extends annotations.BaseTest {
    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void accountLogin() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.elementToBeClickable(By.xpath(".//p[text()='Конструктор']")));
        profilePage.checkLogoutButton();
    }
}
