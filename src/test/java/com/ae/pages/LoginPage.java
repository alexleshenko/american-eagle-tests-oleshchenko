package com.ae.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//*[@data-testid='icon-account']")
    private WebElement accountIcon;

    @FindBy(xpath = "//button[@data-test-btn='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@data-test='form-control-input' and @type='email']")
    private WebElement emailInput;

    @FindBy(xpath = "//div[@data-test-form-input='password']//input[@type='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@data-test-btn='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//button[@data-test-btn='sign-out']")
    private WebElement signOutButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @Step("Click account icon")
    public LoginPage openLoginForm() {
        wait.until(ExpectedConditions.elementToBeClickable(accountIcon)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return this;
    }

    @Step("Enter email: {email}")
    public LoginPage enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        return this;
    }

    @Step("Click Sign In")
    public LoginPage submitLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        return this;
    }

    @Step("Check if 'Sign Out' is visible")
    public boolean isSignOutVisible() {
        return wait.until(ExpectedConditions.visibilityOf(signOutButton)).isDisplayed();
    }
}
