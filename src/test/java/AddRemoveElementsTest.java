
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementsTest {

    @Test
    public void siteShouldBeOpened() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        //browser.manage().window().setSize(new Dimension(1024,768));//задаем размер браузера, а не экрана
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //browser.findElement(By.id("1")).click();
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = browser.findElement(By.xpath("//button[text()='Add Element']"));//класс webelement
        addElementButton.click();//кликнуть на add element
        addElementButton.click();//кликнуть на add element
        browser.findElements(By.xpath("//button[text()='Delete']")).get(1).click();//из коллекции получили нулевую или первую кнопку
        int numberofButtons = browser.findElements(By.xpath("//button[text()='Delete']")).size();//получаем кол-во кнопок delete
        assertEquals(numberofButtons, 1, "кнопок больше 1");
        browser.quit();
    }
}