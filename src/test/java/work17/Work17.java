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

    @Test(enabled = true)
    public void testWork17() {
        webDriver.findElement(By.id("button")).click();
        webDriver.findElement(By.id("first")).click();
        String webElementExcellent = webDriver.findElement(By.xpath("//label[.=\"Excellent!\"]")).getText();
        Assert.assertEquals("Excellent!", webElementExcellent);
        webDriver.findElement(By.className("button-primary")).click();
        webDriver.findElement(By.linkText("Great! Return to menu")).click();
        webDriver.findElement(By.id("checkbox")).click();
        webDriver.findElement(By.id("two")).click();
        webDriver.findElement(By.id("go")).click();
        String webElementResult = webDriver.findElement(By.xpath("//label[.=\" two\"]")).getText();
        Assert.assertEquals("two", webElementResult);
        webDriver.findElement(By.id("radio_one")).click();
        webDriver.findElement(By.id("radio_go")).click();
        String webElementRadioResult = webDriver.findElement(By.xpath("//label[.=\"one\"]")).getText();
        Assert.assertEquals("one", webElementRadioResult);
        String elementGetText = webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]")).getText();
        Assert.assertEquals("Great! Return to menu", elementGetText);
        webDriver.findElement(By.xpath("//label[.=\"Great! Return to menu\"]/a")).click();
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
        // Выполняю дз 19, проверяю куки
        Cookie checkCookieButton = webDriver.manage().getCookieNamed("button");
        Assert.assertEquals(checkCookieButton.getValue(),"done");
        Cookie checkCookieCheckbox = webDriver.manage().getCookieNamed("checkboxes");
        Assert.assertEquals(checkCookieCheckbox.getValue(),"done");
        Cookie checkCookieForm = webDriver.manage().getCookieNamed("form");
        Assert.assertEquals(checkCookieForm.getValue(),"done");
        Cookie checkCookieIframe = webDriver.manage().getCookieNamed("iframe");
        Assert.assertEquals(checkCookieIframe.getValue(),"done");
        Cookie checkCookieSelect = webDriver.manage().getCookieNamed("select");
        Assert.assertEquals(checkCookieSelect.getValue(),"done");
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
    // Конец 18 задания первой части
    //18 Задание, негативный тест
    @Test(enabled = true)
    public void testWork18Task2IsNegativeTest() {
        webDriver.findElement(By.id("alerts")).click();
        webDriver.findElement(By.xpath("//button[.='Get password']")).click();
        String alertGetPassword = webDriver.switchTo().alert().getText();
        webDriver.switchTo().alert().accept();
        webDriver.findElement(By.xpath("//button[.='Enter password']")).click();
        webDriver.switchTo().alert().sendKeys(alertGetPassword);
        webDriver.switchTo().alert().accept();

        Assert.assertEquals(isCheckElemeinGreat(), false);
    }
    // Конец 18 задания с негативным тестом
    // Задание 18, третья часть
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

    //

    public boolean isCheckElemeinGreat() {
        try {
            webDriver.findElement(By.xpath("//label"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @AfterTest
    public void driverOut() {
        webDriver.quit();
    }
}