import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxesTest {

    @Test
    public void checkboxFilling() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement firstCheckbox = browser.findElements(By.cssSelector("[type=checkbox]")).get(0);
        // проверить, что первый чекбокс unchecked
        assertFalse(firstCheckbox.isSelected());
        //отметить первый чекбоксc
        firstCheckbox.click();
        // проверить что первый чекбокс checked
        assertTrue(firstCheckbox.isSelected());
        //Проверить, что второй чекбокс checked
        WebElement secondCheckbox = browser.findElements(By.cssSelector("[type=checkbox]")).get(1);
        assertTrue(secondCheckbox.isSelected());
        //сделать unheck
        secondCheckbox.click();
        //проверить, что он unchecked
        assertFalse(secondCheckbox.isSelected());
        browser.quit();
    }
}
