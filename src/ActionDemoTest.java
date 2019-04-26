import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ActionDemoTest {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/gauthier/Documents/Development/Selenium/drivers/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://google.com");

        // locate the search box element
        WebElement searchBox = driver.findElement(By.name("q"));
        Thread.sleep(5000);

        // type search query in search box
        searchBox.sendKeys("seleniumhq" + Keys.RETURN);
        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        driver.quit();
    }
}
