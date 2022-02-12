package pageObjectPattern;

import helpers.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjectPattern.pages.AuthenticationPage;
import pageObjectPattern.pages.CreateAnAccountPage;
import pageObjectPattern.pages.HotelBrowser;
import pageObjectPattern.pages.HotelsListingPage;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class HotelTestlabTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createChromeDriverWithImplicitlyWait(10);
    }

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void userRegistrationZad1() {
        // arrange
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(driver);

        String email = "Marek.Skwarek@mail.com";
        String firstName = "Marek";
        String lastName = "Skwarek";
        String password = "abc123";

        // act
        // ponizsze powinno byc w oddzielnych pages
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
        driver.findElement(By.id("email_create")).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        createAnAccountPage.registerUser(firstName, lastName, password);

        // act
        Assertions.assertEquals("Your account has been created.",
                createAnAccountPage.getRegistrationConfirmationText());
    }

    @Test
    public void findAnyHotelZad2AndZad3() {
        // arrange
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        HotelBrowser hotelBrowser = new HotelBrowser(driver);
        HotelsListingPage hotelsListingPage = new HotelsListingPage(driver);

        String email = "Marek.Skwarek@mail.com";
        String password = "abc123";
        String hotel = "The Hotel Prime";
        String checkInDate = "20-02-2022";
        String checkOutDate = "23-02-2022";
        String roomName = "Delux Rooms";

        // act
        driver.get("https://hotel-testlab.coderslab.pl/en/");
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();

        authenticationPage.loginAs(email, password);
        driver.findElement(By.id("header_logo")).click();

        hotelBrowser.searchForHotel(hotel, checkInDate, checkOutDate);

        // zadanie 3 - wyszukiwanie hotelu po nazwie
        hotelsListingPage.bookOneRoom(roomName);
    }
}
