package taskCheckConfig;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class GoogleSearch {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");

        WebElement prompt = driver.findElement(By.cssSelector("#L2AGLb > div"));
        prompt.click();

        WebElement element = driver.findElement(By.name("q"));

        element.clear();
        element.sendKeys("Coderslab");
        element.submit();
        driver.quit();
    }
}
