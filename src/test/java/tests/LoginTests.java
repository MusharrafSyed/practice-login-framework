package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SuccessPage;
import utils.ConfigReader;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        SuccessPage successPage = loginPage.login(
                ConfigReader.getProperty("validUsername"),
                ConfigReader.getProperty("validPassword")
        );

        Assert.assertTrue(successPage.getSuccessMessage().contains("Logged In Successfully"));
        Assert.assertTrue(successPage.isLogoutDisplayed());
    }

    @Test
    public void invalidUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("wrongUser", ConfigReader.getProperty("validPassword"));

        Assert.assertEquals(loginPage.getErrorMessage(), "Your username is invalid!");
    }

    @Test
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.getProperty("validUsername"), "wrongPassword");

        Assert.assertEquals(loginPage.getErrorMessage(), "Your password is invalid!");
    }
}