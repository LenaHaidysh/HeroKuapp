import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContextTest {

    @Test
    public void contextClickWithAlert() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(browser);
        action.contextClick(browser.findElement(By.id("hot-spot"))).perform();
        Alert alert = browser.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu", "Некорректный текст об ошибке");
        alert.accept();
        browser.quit();
    }
}
