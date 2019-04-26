import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.CreateAcctPage;

@Test()
public class LoginTest {
    public String baseURL = "http://localhost:8000";
    public FirefoxDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "/Users/gauthier/Documents/Development/Selenium/drivers/geckodriver");
        driver = new FirefoxDriver();
//        visit login page
        driver.get(baseURL);
    }

    @Test
    public void testLoginSucceed() throws InterruptedException {
//        Happy path login succeeds
//        Perform actions with Locators
        LoginPage.userName(driver).sendKeys("registeredUser");
        LoginPage.password(driver).sendKeys("1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);

//        Check result
        String message = LoginPage.message(driver).getText();
        String expectedMessage = "Welcome back,\n" + "registeredUser";
        Assert.assertEquals(message, expectedMessage);
    }

    @Test
    public void testLoginFail() throws InterruptedException {
//        Perform actions with Locators
        LoginPage.userName(driver).sendKeys("otherUser");
        LoginPage.password(driver).sendKeys("qwerty1234");
        LoginPage.submit(driver).click();
        Thread.sleep(5000);

//        Check result
        String message = LoginPage.message(driver).getText();
        String expectedMessage = "Account not found. Please sign up by clicking the link below";
        Assert.assertEquals(message, expectedMessage);

//        Perform create account actions
        LoginPage.createAccountLink(driver).click();
        Thread.sleep(5000);

//        Check result
        String header = CreateAcctPage.header(driver).getText();
        String expectedHeader = "Create an Account";
        Assert.assertEquals(header, expectedHeader);

    }


    @AfterTest
     public void endSession(){ driver.quit(); }
}
