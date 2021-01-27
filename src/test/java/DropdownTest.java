import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DropdownTest {

    @Test
    public void DropdownFilling() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/dropdown");
        Select dropdown = new Select(browser.findElement(By.id("dropdown")));
        List allOptions = dropdown.getOptions();
        assertFalse(allOptions.isEmpty());
        dropdown.selectByVisibleText("Option 1");
        WebElement firstSelectedOption = dropdown.getFirstSelectedOption();//выбор элемента в дропдауне
        assertTrue(firstSelectedOption.isSelected()); // проверка наличия элемента в дропдауне
        browser.quit();
    }
}
