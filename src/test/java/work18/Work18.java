package work18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Work18 {

    private WebDriver webDriver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://savkk.github.io/selenium-practice/ ");
    }

    @Test(enabled = false)
    public void sestWork18Task1() {
        webDriver.findElement(By.id("alerts")).click();
        webDriver.findElement(By.xpath("//button[.='Get password']")).click();
        String alertGetPassword = webDriver.switchTo().alert().getText().replaceAll("Your password: ", "");
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.xpath("//button[.='Enter password']")).click();
        webDriver.switchTo().alert().sendKeys(alertGetPassword);
        webDriver.switchTo().alert().accept();
        String returnTextGreat = webDriver.findElement(By.xpath("//label")).getText();
        Assert.assertEquals(returnTextGreat, "Great!");
        webDriver.findElement(By.xpath("//button[3]")).click();
        webDriver.switchTo().alert().accept();
        // Выполняю дз 19, проверяю куки
        Cookie checkCookieAlerts = webDriver.manage().getCookieNamed("alerts");
        Assert.assertEquals(checkCookieAlerts.getValue(),"done");
    }

    @Test(enabled = true)
    public void testWork18Task2IsNegativeTest() {
        webDriver.findElement(By.id("alerts")).click();
        webDriver.findElement(By.xpath("//button[.='Get password']")).click();
        String alertGetPassword = webDriver.switchTo().alert().getText();
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.xpath("//button[.='Enter password']")).click();
        webDriver.switchTo().alert().sendKeys(alertGetPassword);
        webDriver.switchTo().alert().accept();
        List <WebElement> labels = webDriver.findElements(By.xpath("//label"));
        Assert.assertEquals(labels.size(), 0);
    }

    @Test(enabled = false)
    public void testWork18Task3() {
        webDriver.findElement(By.id("table")).click();
        webDriver.findElement(By.xpath("//tbody/tr[4]/td/input")).click();
        webDriver.findElement(By.xpath("//tbody/tr[5]/td/input")).click();
        webDriver.findElement(By.xpath("//input[@value='Delete']")).click();
        webDriver.findElement(By.xpath("//form/div[1]/input")).sendKeys("sdsd");
        webDriver.findElement(By.xpath("//form/div[2]/input")).sendKeys("нет контакта");
        webDriver.findElement(By.xpath("//form/div[3]/input")).sendKeys("Наша Раша");
        webDriver.findElement(By.xpath("//input[@value='Add']")).click();
        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();
        // Выполняю дз 19, проверяю куки
        Cookie checkCookieTable = webDriver.manage().getCookieNamed("table");
        Assert.assertEquals(checkCookieTable.getValue(),"done");
    }


    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }

}
