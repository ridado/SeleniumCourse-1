package pageObjectPattern.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBrowser {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"search_hotel_block_form\"]/div[2]/div/button")
    private WebElement hotelDropdown;

    @FindBy(xpath = "//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul/li")
    private WebElement firstHotel;

    @FindBy(id = "check_in_time")
    private WebElement checkInDateInput;

    @FindBy(id = "check_out_time")
    private WebElement checkOutDateInput;

    @FindBy(id = "search_room_submit")
    private WebElement submitButton;

    public HotelBrowser(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForHotel(String hotelName, String checkInDate, String checkoutDate) {
        hotelDropdown.click();
        firstHotel.click();
        checkInDateInput.sendKeys(checkInDate);
        checkOutDateInput.sendKeys(checkoutDate);
        submitButton.click();
    }
}
