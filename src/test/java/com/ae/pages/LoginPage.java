package com.ae.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Click account icon")
    public LoginPage openLoginForm() {
        driver.findElement(By.xpath("//*[@data-testid='icon-account']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-test-btn='signin']"))).click();
        return this;
    }

    @Step("Enter email: {email}")
    public LoginPage enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@data-test='form-control-input' and @type='email']")));
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-test-form-input='password']//input[@type='password']")));
        passwordInput.sendKeys(password);
        return this;
    }

    @Step("Click Sign In")
    public LoginPage submitLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[@data-test-btn='submit']"))).click();
        return this;
    }

    @Step("Check if 'Sign Out' is visible")
    public boolean isSignOutVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[@data-test-btn='sign-out']"))).isDisplayed();
    }
}
