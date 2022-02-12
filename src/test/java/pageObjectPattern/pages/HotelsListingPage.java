package pageObjectPattern.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class HotelsListingPage {

    private WebDriver driver;

    public HotelsListingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void bookOneRoom(String roomName) {
        String roomSelector = "//p[text() = '" + roomName + "']/../a";
        WebElement roomBookNowButton = driver.findElement(By.xpath(roomSelector));
        roomBookNowButton.click();
    }

    private void bookOneRoomWithFor(String roomName) {
        List<WebElement> rooms = driver.findElements(By.className("room_cont"));
        boolean elementFound = false;
        for (WebElement room : rooms
        ) {
            if (room.getText().contains(roomName)) {
                room.findElement(By.cssSelector("a.ajax_add_to_cart_button")).click();
                elementFound = true;
                break;
            }
        }

        if (!elementFound)
            throw new NoSuchElementException("Pokoj o nazwie " + roomName + " nie zostal znaleziony");
    }
}
