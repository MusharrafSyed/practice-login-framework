package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SuccessPage {

    private WebDriver driver;

    private By successMessage = By.tagName("h1");
    private By logoutButton = By.linkText("Log out");

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public boolean isLogoutDisplayed() {
        return driver.findElement(logoutButton).isDisplayed();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}