import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.concurrent.FastThreadLocalThread;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProjectTest {

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void testOne() {
        WebDriver driver = new ChromeDriver();
    }

    @Test
    public void testTwo() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(Helper.GOOGLEURL);
        Thread.sleep(2000);
        driver.navigate().to(Helper.DEMOBLAZEURL);
        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    public void testThree() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.DEMOBLAZEURL);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.quit();

    }

    @Test
    public void testFour() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(Helper.DEMOBLAZEURL);
        Thread.sleep(2000);
        driver.navigate().to(Helper.GOOGLEURL);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        driver.quit();
    }

    @Test
    public void testFive() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.DEMOBLAZEURL);

        WebElement loginBtn1 = driver.findElement(By.id(Helper.loginId1));
        loginBtn1.click();

        WebElement loginField =driver.findElement(By.id(Helper.USERNAMEID));
        WebElement passwordField =driver.findElement(By.id(Helper.PASSWORDID));
        WebElement loginBtn2 =driver.findElement(By.xpath(Helper.LogInBtn2ByXpath));

        Thread.sleep(10000);
        loginField.sendKeys(Helper.USERNAME);
        passwordField.sendKeys(Helper.PASSWORD);
        Thread.sleep(3000);
        loginBtn2.click();
        Thread.sleep(5000);
        WebElement loginBtn3 = driver.findElement(By.id(Helper.LogOutById));
        loginBtn3.click();
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void testSix() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.DEMOBLAZEURL);

        WebElement loginBtn1 = driver.findElement(By.id(Helper.loginId1));
        loginBtn1.click();

        File file1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file1,new File("C:\\Users\\elen7\\Desktop\\Blah\\Screenshot1.jpg"));

        WebElement loginField =driver.findElement(By.id(Helper.USERNAMEID));
        WebElement passwordField =driver.findElement(By.id(Helper.PASSWORDID));
        WebElement loginBtn2 =driver.findElement(By.xpath(Helper.LogInBtn2ByXpath));

        Thread.sleep(10000);
        loginField.sendKeys(Helper.USERNAME);
        passwordField.sendKeys(Helper.PASSWORD);
        Thread.sleep(3000);
        loginBtn2.click();

        File file2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file2,new File("C:\\Users\\elen7\\Desktop\\Blah\\Screenshot2.jpg"));

        Thread.sleep(5000);

        File file3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file3,new File("C:\\Users\\elen7\\Desktop\\Blah\\Screenshot3.jpg"));


        WebElement loginBtn3 = driver.findElement(By.id(Helper.LogOutById));
        loginBtn3.click();

        File file4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file4,new File("C:\\Users\\elen7\\Desktop\\Blah\\Screenshot4.jpg"));
        Thread.sleep(3000);
        driver.quit();

    }

    @Test
    public void testSeven() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(Helper.DEMOBLAZEURL);

        WebElement element = driver.findElement(By.id("login2"));
        Thread.sleep(3000);
        String text = element.getText();
        System.out.println(text);
        driver.quit();
    }
}