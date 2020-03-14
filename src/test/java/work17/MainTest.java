package work17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;


public class MainTest {

    private WebDriver webDriver;

    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }
    @Test
    public void savkk() {
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://savkk.github.io/selenium-practice/ ");
//        webDriver.findElement(By.id("button")).click();
//        webDriver.findElement(By.id("first")).click();
//        String webElementExcellent = webDriver.findElement(By.xpath("//label[.=\"Excellent!\"]")).getText();
//        Assert.assertEquals("Excellent!", webElementExcellent);
//        webDriver.findElement(By.className("button-primary")).click();
//        webDriver.findElement(By.linkText("Great! Return to menu")).click();
//        webDriver.findElement(By.id("checkbox")).click();
//        webDriver.findElement(By.id("two")).click();
//        webDriver.findElement(By.id("go")).click();
//        String webElementResult = webDriver.findElement(By.xpath("//label[.=\" two\"]")).getText();
//        Assert.assertEquals("two", webElementResult);
//        webDriver.findElement(By.id("radio_one")).click();
//        webDriver.findElement(By.id("radio_go")).click();
//        String webElementRadioResult = webDriver.findElement(By.xpath("//label[.=\"one\"]")).getText();
//        Assert.assertEquals("one", webElementRadioResult);
//        String elementGetText = webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]")).getText();
//        Assert.assertEquals("Great! Return to menu", elementGetText);
//        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();
//        webDriver.findElement(By.id("select")).click();
//        WebElement heroElement = webDriver.findElement(By.name("hero"));
//        Select heroSelect = new Select(heroElement);
//        heroSelect.selectByIndex(2);
//        WebElement languagesElement = webDriver.findElement(By.name("languages"));
//        Select languagesSelect = new Select(languagesElement);
//        languagesSelect.selectByIndex(3);
//        languagesSelect.selectByIndex(2);
//        languagesSelect.selectByIndex(4);
//        webDriver.findElement(By.id("go")).click();
//        String getSelectText = webDriver.findElement(By.xpath("//label[.='C++, C#, Pascal']")).getText();
//        Assert.assertEquals(getSelectText,"C++, C#, Pascal");
//        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();
//        webDriver.findElement(By.id("form")).click();
//        WebElement inputFirstName = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[1]/input"));
//        inputFirstName.sendKeys("Aram");
//        WebElement inputLastName = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[2]/input"));
//        inputLastName.sendKeys("Хачатурян");
//        WebElement inputEmail = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[3]/input"));
//        inputEmail.sendKeys("ololo@box.ru");
//        webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[4]/input[2]")).click();
//        WebElement inputAddress = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[5]/input"));
//        inputAddress.sendKeys("ул.Пушкина, дом. Колотушкина где проживают тянки");
//        webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[6]/input")).sendKeys("C:/Users/Aram/Desktop/Git/work17/.gitignore.");  //Загружаю файл. Указать относительный путь не получилось, по этому указал полный
//        WebElement inputTellMe  = webDriver.findElement(By.xpath("//form[@id=\"testform\"]/div[7]/textarea"));
//        inputTellMe.sendKeys("Я изучаю автоматизацию");
//        webDriver.findElement(By.xpath("//form[@id=\"testform\"]/input")).click();
//        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();
//        webDriver.findElement(By.id("iframe")).click();
//        webDriver.findElements(By.id("code-frame")).size();
//        webDriver.switchTo().frame(0);
//        String textCode = webDriver.findElement(By.xpath("//form/label[@id=\"code\"]")).getText().replaceAll("Your code is: ", "");
//        webDriver.switchTo().parentFrame();
//        webDriver.findElement(By.xpath("//input[@name='code']")).sendKeys(textCode);
//        webDriver.findElement(By.xpath("//input[@name='ok']")).click();
//        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();


        // 18 задание, начало!

        webDriver.findElement(By.id("alerts")).click();
//        webDriver.findElement(By.xpath("//button[.='Enter password']")).click();
        webDriver.findElement(By.xpath("//button[.='Get password']")).click();
        String alertGetPassword = webDriver.switchTo().alert().getText().replaceAll("Your password: ", "");
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.xpath("//button[.='Enter password']")).click();
        webDriver.switchTo().alert().sendKeys(alertGetPassword);
        webDriver.switchTo().alert().accept();
        String textGreat = webDriver.findElement(By.xpath("//label")).getText();
        Assert.assertEquals(textGreat, "Great!");
        webDriver.findElement(By.xpath("//button[3]")).click();
    }


    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}
