import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ActionDemoTest {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/gauthier/Documents/Development/Selenium/drivers/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
//        visit Wikipedia homepage


//          Happy path login succeeds
//        Locate elements
        driver.get("http://localhost:8000/index.html");
        WebElement username = driver.findElement(By.cssSelector("#username"));
        WebElement password = driver.findElement(By.cssSelector("#password"));
        WebElement submit = driver.findElement(By.name("submit"));

//        Perform actions
        username.sendKeys("registeredUser");
        password.sendKeys("1234");
        submit.click();
        Thread.sleep(5000);

//        Log result
        String message = driver.findElement(By.cssSelector("#auth-message")).getText();
        System.out.println(message);

//        Sad path - login fails
//        Locate elements
        driver.get("http://localhost:8000/index.html");
        WebElement username2 = driver.findElement(By.cssSelector("#username"));
        WebElement password2 = driver.findElement(By.cssSelector("#password"));
        WebElement submit2 = driver.findElement(By.name("submit"));

//        Perform actions
        username2.sendKeys("otherUser");
        password2.sendKeys("qwerty1234");
        submit2.click();
        Thread.sleep(5000);

//        Log result
        String message2 = driver.findElement(By.cssSelector("#auth-message")).getText();
        System.out.println(message2);

//        Perform create account actions
        WebElement createAccountLink = driver.findElement(By.linkText("Create an account"));
        createAccountLink.click();
        Thread.sleep(5000);

//        Log result
        String header = driver.findElement(By.cssSelector("#header")).getText();
        System.out.println(header);

        driver.quit();
    }
}
