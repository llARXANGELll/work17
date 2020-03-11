package work17;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MainTest {

    private WebDriver webDriver;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @Test
    public void savkk() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://savkk.github.io/selenium-practice/ ");
        webDriver.findElement(By.id("button")).click();
        webDriver.findElement(By.id("first")).click();
        String excellent = webDriver.findElement(By.xpath("//label[.=\"Excellent!\"]")).getText();
        Assert.assertEquals("Excellent!", excellent);
        webDriver.findElement(By.className("button-primary")).click();
        webDriver.findElement(By.linkText("Great! Return to menu")).click();
        webDriver.findElement(By.id("checkbox")).click();
        webDriver.findElement(By.id("two")).click();
        webDriver.findElement(By.id("go")).click();
        String result = webDriver.findElement(By.xpath("//label[.=\" two\"]")).getText();
        Assert.assertEquals("two", result);
        webDriver.findElement(By.id("radio_one")).click();
        webDriver.findElement(By.id("radio_go")).click();
        String radio_result = webDriver.findElement(By.xpath("//label[.=\"one\"]")).getText();
        Assert.assertEquals("one", radio_result);
        String text = webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]")).getText();
        Assert.assertEquals("Great! Return to menu", text);
        webDriver.findElement(By.id("back")).click();

    }

    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}