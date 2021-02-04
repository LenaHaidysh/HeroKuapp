import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class FindElementsHtml {

    @Test
    public void findElements() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран1;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("file:///D:/wmn/test/MyHTML.html");
        WebElement firstCheckbox = browser.findElements(By.cssSelector("[type=checkbox]")).get(0);
        assertFalse(firstCheckbox.isSelected());
        Select dropdown = new Select(browser.findElement(By.id("cars")));
        dropdown.selectByVisibleText("Bmw");
        String result = "Bmw";
        assertEquals(result, "Bmw");
        WebElement submitButton = browser.findElement(By.cssSelector("[value=Submit]"));
        WebElement link = browser.findElement(By.linkText("Learn more information!"));
        String tagP = browser.findElements(By.tagName("p")).get(0).getText();
        browser.quit();
    }
}
