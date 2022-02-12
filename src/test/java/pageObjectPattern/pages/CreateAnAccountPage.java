package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

    private WebDriver driver;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;

    @FindBy(id = "passwd")
    private WebElement passwordInput;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    @FindBy(css = "p.alert.alert-success")
    private WebElement alertMessage;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void registerUser(String firstName, String lastName, String password) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        passwordInput.sendKeys(password);
        registerButton.click();
    }

    public String getRegistrationConfirmationText() {
        return alertMessage.getText();
    }
}
