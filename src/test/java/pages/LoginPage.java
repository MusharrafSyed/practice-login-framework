package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");
    private By errorMessage = By.id("error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {

        driver.findElement(usernameField).clear();

        driver.findElement(usernameField)
                .sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).clear();

        driver.findElement(passwordField)
                .sendKeys(password);
    }

    public SuccessPage clickSubmit() {

        driver.findElement(submitButton)
                .click();

        return new SuccessPage(driver);
    }

    public SuccessPage login(String username,
                             String password) {

        enterUsername(username);

        enterPassword(password);

        return clickSubmit();
    }

    public String getErrorMessage() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(5));

        wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(errorMessage));

        return driver.findElement(errorMessage)
                .getText()
                .trim();
    }
}