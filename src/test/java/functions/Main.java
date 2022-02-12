package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://pl.wikipedia.org/");

//        WebElement element = driver.findElement(By.id("main-page-column1"));
//        System.out.println(element.getText());

//        String atrybut = driver.findElement(By.id("main-page-content")).getAttribute("class");
//        System.out.println(atrybut);
//
//        String tag = driver.findElement(By.id("main-page-content")).getTagName();
//        System.out.println(tag);

        WebElement search = driver.findElement(By.id("searchInput"));

//        if(search.isEnabled()) {
//            search.sendKeys("Selenium");
//            search.submit();
//        }else {
//            throw new NoSuchElementException("Nie ma takiego elementu!");
//        }

        if(search.isDisplayed()) {
            search.sendKeys("Selenium");
            search.submit();
        }else {
            throw new ElementNotVisibleException("Element nie jest wyswietlony!");
        }

        //driver.quit();
    }
}
