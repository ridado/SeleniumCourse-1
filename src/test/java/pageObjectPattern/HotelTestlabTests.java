package pageObjectPattern;

import helpers.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjectPattern.pages.CreateAnAccountPage;

public class HotelTestlabTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
    }

    @AfterEach
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void userRegistrationZad1() {
        // arrange
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);

        String email = "johd31231132123123@mail.com";
        String firstName = "John";
        String lastName = "Doe";
        String password = "qwerty";

        // act
        // ponizsze powinno byc w oddzielnych pages
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        createAnAccountPage.registerUser(firstName, lastName, password);

        // act
        Assertions.assertEquals("Your account has been created.", createAnAccountPage.getRegistrationConfirmationText());
    }
}
