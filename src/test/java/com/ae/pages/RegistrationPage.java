    package com.ae.pages;

    import org.openqa.selenium.JavascriptExecutor;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.Select;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;

    public class RegistrationPage {
        private final WebDriver driver;
        private final WebDriverWait wait;

        public RegistrationPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//*[@data-testid='icon-account']")
        private WebElement accountIcon;

        @FindBy(xpath = "//a[@data-test=\"register-button\"]")
        private WebElement registerButton;

        @FindBy(xpath = "//input[@placeholder='Email' and @name='login']")
        private WebElement emailInput;

        @FindBy(xpath = "//input[@placeholder='First Name' and @name='firstname']")
        private WebElement firstNameInput;

        @FindBy(xpath = "//input[@placeholder='Last Name' and @name='lastname']")
        private WebElement lastNameInput;

        @FindBy(xpath = "//input[@placeholder='Password' and @name='password']")
        private WebElement passwordInput;

        @FindBy(xpath = "//input[@placeholder='Confirm Password' and @name='confirm_password']")
        private WebElement confirmPasswordInput;

        @FindBy(xpath = "//input[@placeholder='Zip Code' and @name='postalCode']")
        private WebElement zipCodeInput;

        @FindBy(xpath = "//select[@name='month']")
        private WebElement birthMonthSelect;

        @FindBy(xpath = "//select[@name='day']")
        private WebElement birthDaySelect;

        @FindBy(xpath = "//input[@name='acceptTerms']")
        private WebElement acceptTermsCheckbox;

        public RegistrationPage acceptTerms() {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", acceptTermsCheckbox);
            return this;
        }

        @FindBy(xpath = "//button[@data-test-btn=\"submit\"]")
        private WebElement submitButton;


        public RegistrationPage openRegistration() {
            wait.until(ExpectedConditions.elementToBeClickable(accountIcon)).click();
            wait.until(ExpectedConditions.elementToBeClickable(registerButton)).click();
            return this;
        }

        public RegistrationPage enterEmail(String email) {
            wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
            return this;
        }

        public RegistrationPage enterFirstName(String firstName) {
            firstNameInput.sendKeys(firstName);
            return this;
        }

        public RegistrationPage enterLastName(String lastName) {
            lastNameInput.sendKeys(lastName);
            return this;
        }

        public RegistrationPage enterPassword(String password) {
            passwordInput.sendKeys(password);
            return this;
        }

        public RegistrationPage confirmPassword(String confirmPassword) {
            confirmPasswordInput.sendKeys(confirmPassword);
            return this;
        }

        public RegistrationPage enterZipCode(String zipCode) {
            zipCodeInput.sendKeys(zipCode);
            return this;
        }

        public RegistrationPage selectBirthMonth(String month) {
            new Select(birthMonthSelect).selectByVisibleText(month); // Example: "April"
            return this;
        }

        public RegistrationPage selectBirthDay(String day) {
            new Select(birthDaySelect).selectByValue(day); // Example: "15"
            return this;
        }

        public RegistrationPage submit() {
            submitButton.click();
            return this;
        }
    }
