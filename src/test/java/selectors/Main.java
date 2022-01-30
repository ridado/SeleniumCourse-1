package selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://hotel-testlab.coderslab.pl/en/");

        // Zadanie1 - za pomoca id
        // (pole tekstowe) Hotel Location
        // (przycisk) Search Now
        // (pole tekstowe) Enter your e-mail (pole na dole stron)

        //WebElement hotelLocationInput = driver.findElement(By.id("hotel_location"));
        //hotelLocationInput.sendKeys("Warsaw");

//        driver.findElement(By.id("hotel_location")).sendKeys("Warsaw");
//        WebElement searchNowButton = driver.findElement(By.id("search_room_submit"));
//        WebElement newsletterEmailInput = driver.findElement(By.id("newsletter-input"));
//        newsletterEmailInput.sendKeys("test@test.com");

        // Zadanie2 - za pomoca name
        // (pole tekstowe) Hotel Location
        // (przycisk) Search Now
        // (pole tekstowe) Enter your e-mail (pole na dole stron)
        // (przycisk) Subscribe

        driver.findElement(By.name("hotel_location")).sendKeys("Warsaw");
        WebElement searchNowButton = driver.findElement(By.name("search_room_submit"));
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        WebElement subscribeButton = driver.findElement(By.name("submitNewsletter"));

        searchNowButton.click();

        // Zadanie3 - za pomoca className
        // (przycisk) Sign In
        // (pole tekstowe) Email address
        String email = "dadajohndoe312@mail.com";

        driver.findElement(By.className("hide_xs")).click();
        driver.findElement(
                By.cssSelector(
                        ".is_required.validate.account_input.form-control"
                )).sendKeys(email);
        driver.findElement(By.id("SubmitCreate")).click();

        // Zadanie4 - za pomoca xpath
        WebElement firstNameInput = driver.findElement(By.xpath("//input[@id='customer_firstname']"));
        if (firstNameInput.isDisplayed()) {
            firstNameInput.clear();
            firstNameInput.sendKeys("John");
        } else {
            throw new ElementNotVisibleException("Element firstNameInput nie jest wyswietlony!");
        }

        driver.findElement(By.xpath("//input[@name='customer_lastname']")).sendKeys("Doe");

        WebElement userEmail = driver.findElement(By.xpath("//input[@id='email']"));
        if (userEmail.isDisplayed()) {
            userEmail.clear();
            userEmail.sendKeys(email);
        } else {
            throw new ElementNotVisibleException("Element userEmail nie jest wyswietlony!");
        }

        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("qwerty");

        //driver.findElement(By.xpath("//*[@id='submitAccount']")).click();

        //driver.quit();
    }
}
