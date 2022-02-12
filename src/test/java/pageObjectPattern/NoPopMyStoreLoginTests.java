package pageObjectPattern;

import helpers.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NoPopMyStoreLoginTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createChromeDriver();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=my-account");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginWithProperCredentials() {
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("johnd@mail.com");

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("qwerty");

        WebElement signInButton = driver.findElement(By.id("submit-login"));
        signInButton.click();

        WebElement userNameLabel = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a[2]/span"));
        Assertions.assertEquals("John Doe", userNameLabel.getText());
    }
}
