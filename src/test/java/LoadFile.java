import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoadFile {

    @Test
    public void loadFileCheck() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//нужно в каждом проекте, на весь экран;
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        browser.get("http://the-internet.herokuapp.com/upload");
        WebElement addFile = browser.findElement(By.xpath("//input[@type='file']"));
        addFile.sendKeys(new File("src/test/resources/NewFile.html").getAbsolutePath());
        browser.findElement(By.id("file-submit")).click();
        Assert.assertEquals(browser.findElement(By.id("uploaded-files")).getText(), "NewFile.html",
                "Некорректное название загруженного файла");
    }
}