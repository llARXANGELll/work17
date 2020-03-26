package work17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class Work17 {

    private WebDriver webDriver;

    @BeforeSuite
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://savkk.github.io/selenium-practice/ ");
    }

    @Test
    public void testWork17() {
        webDriver.findElement(By.id("select")).click();
        WebElement heroElement = webDriver.findElement(By.name("hero"));
        Select heroSelect = new Select(heroElement);
        heroSelect.selectByIndex(2);
        WebElement languagesElement = webDriver.findElement(By.name("languages"));
        Select languagesSelect = new Select(languagesElement);
        languagesSelect.selectByIndex(3);
        languagesSelect.selectByIndex(2);
        languagesSelect.selectByIndex(4);
        webDriver.findElement(By.id("go")).click();
        String getSelectText = webDriver.findElement(By.xpath("//label[.='C++, C#, Pascal']")).getText();
        Assert.assertEquals(getSelectText, "C++, C#, Pascal");
        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();

        webDriver.findElement(By.id("form")).click();
        WebElement inputFirstName = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[1]/input"));
        inputFirstName.sendKeys("Aram");
        WebElement inputLastName = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[2]/input"));
        inputLastName.sendKeys("Хачатурян");
        WebElement inputEmail = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[3]/input"));
        inputEmail.sendKeys("ololo@box.ru");
        webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[4]/input[2]")).click();
        WebElement inputAddress = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[5]/input"));
        inputAddress.sendKeys("ул.Пушкина, дом. Колотушкина где проживают тянки");
        webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[6]/input")).sendKeys("C:/Users/Aram/Desktop/Git/Work17/.gitignore.");  //Загружаю файл. Указать относительный путь не получилось, по этому указал полный
        WebElement inputTellMe = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[7]/textarea"));
        inputTellMe.sendKeys("Я изучаю автоматизацию");
        webDriver.findElement(By.xpath("//form[@id=\"testform\"]/input")).click();
        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();

        webDriver.findElement(By.id("iframe")).click();
        webDriver.findElements(By.id("code-frame")).size();
        webDriver.switchTo().frame(0);
        String textCode = webDriver.findElement(By.xpath("//form/label[@id=\"code\"]")).getText().replaceAll("Your code is: ", "");
        webDriver.switchTo().parentFrame();
        webDriver.findElement(By.xpath("//input[@name='code']")).sendKeys(textCode);
        webDriver.findElement(By.xpath("//input[@name='ok']")).click();
        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();
    }

    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}