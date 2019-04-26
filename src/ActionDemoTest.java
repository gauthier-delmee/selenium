import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ActionDemoTest {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/Users/gauthier/Documents/Development/Selenium/drivers/geckodriver");
        FirefoxDriver driver = new FirefoxDriver();
//        visit Wikipedia homepage
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

//        //*[@id="p-logo"]/a

        // locate and click on the random article link
        driver.findElement(By.cssSelector("#n-randompage")).click();
        Thread.sleep(5000);

        // locate the title of article
        System.out.println(driver.findElement(By.cssSelector(".firstHeading")).getText());

//        view page info
        driver.findElementByLinkText("Page information").click();
        Thread.sleep(5000);

//        new search
        driver.findElement(By.name("search")).sendKeys("selenium (software)" + Keys.RETURN);
        Thread.sleep(5000);

//        Xpath logo click
        String xpath = "//*[@id=\"p-logo\"]/a";
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(5000);


        driver.quit();
    }
}
