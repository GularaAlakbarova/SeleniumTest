package July3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;


public class WarmUpTask {

           public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gular\\OneDrive\\Документы\\Eduction\\I Programmer\\Drivers\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");


            driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
            driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
            driver.findElement(By.name("ctl00$MainContent$login_button")).click();
            driver.manage().window().maximize();

            String actualTitle = driver.getTitle();
            String expectedTitle = "Web Orders";
            assertTrue(actualTitle.contains(expectedTitle));

            List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'Welcome, Tester!')]"));
            List<WebElement> list2 = driver.findElements(By.xpath("//*[contains(text(),'List of All Orders')]"));

            List<WebElement> allLinks = driver.findElements(By.tagName("a"));

            int actualNumberOfLinks = allLinks.size();
            int expectedNumberOfLinks = 6;

            assertEquals(actualNumberOfLinks, expectedNumberOfLinks);

            for (WebElement link: allLinks) {
             System.out.println(link.getText());
              }

            driver.findElement(By.id("ctl00_logout")).click();

            assertTrue(driver.getTitle().equals("Web Orders Login"));



//           driver.close();



        }
}
