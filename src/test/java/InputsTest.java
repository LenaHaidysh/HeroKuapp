import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class InputsTest {

    @Test
    public void inputFillingUP() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экранн;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = browser.findElement(By.tagName("input"));
        inputField.sendKeys("123");
        int result = 123;
        inputField.sendKeys(Keys.ARROW_UP);
        //*Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN
        assertEquals(result + 1, 124);
        browser.quit();
    }

    @Test
    public void inputFillingDown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = browser.findElement(By.tagName("input"));
        inputField.sendKeys("123");
        int result = 123;
        inputField.sendKeys(Keys.ARROW_DOWN);
        //*Проверить на возможность ввести различные цифровые и нецифровые значения, используя Keys.ARROW_UP  И Keys.ARROW_DOWN
        assertEquals(result - 1, 122);
        browser.quit();
    }
}