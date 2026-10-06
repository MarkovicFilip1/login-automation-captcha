import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class SeleniumTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orangehrm.com/contact-sales");
    }

    @AfterClass
    public void tearDown() {
      //  driver.quit();
    }

    @Test
    public void testLogginfIntoApplication() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")));
        acceptCookies.click();


        WebElement username = driver.findElement(By.name("FullName"));
        username.sendKeys("Admin");

        var email = driver.findElement(By.name("Email"));
        email.sendKeys("PeraPeric@gmail.com");

        var phoneNumber = driver.findElement(By.name("Contact"));
        phoneNumber.sendKeys("+381 641234567");

        var Job = driver.findElement(By.name("JobTitle"));
        Job.sendKeys("QA");

        var companyMail = driver.findElement(By.name("CompanyName"));
        companyMail.sendKeys("Flex");

        var Message = driver.findElement(By.name("Comment"));
        Message.sendKeys("I love to Test");

        var country = driver.findElement(By.name("Country"));
        country.sendKeys("Serbia");

        var Employees = driver.findElement(By.name("NoOfEmployees"));
        Employees.sendKeys("200 - 1,000");



        WebElement recaptchaFrame = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("iframe[title='reCAPTCHA']")));
        driver.switchTo().frame(recaptchaFrame);

        wait.until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-anchor"))).click();

        System.out.println("Reši captcha ručno u browseru...");
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(120));
        longWait.until(ExpectedConditions.attributeToBe(
                By.id("recaptcha-anchor"), "aria-checked", "true"));

        driver.switchTo().defaultContent();



        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.cssSelector("iframe[title='reCAPTCHA']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("recaptcha-anchor"))).click();
        driver.switchTo().defaultContent();

        driver.findElement(By.name("action_submitForm")).click();




    }


}
