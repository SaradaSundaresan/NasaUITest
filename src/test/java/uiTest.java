import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;



public class uiTest {
    WebDriver driver = new ChromeDriver();
    String baseURI = "https://cneos.jpl.nasa.gov/sentry/";
// Test 1 : Drop down should display 4 options, i.e. 10, 25, 50 and 75
    @Test
    public void verifyPageDropDown() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURI);
        Thread.sleep(5000);
        WebElement mySelectElement = driver.findElement(By.name("riskTable_length"));
        Select dropdown = new Select(mySelectElement);
        List<WebElement> options = dropdown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());

        }
    }
// Test 2 : 25 entries should be selected by default
    @Test
    public void verifyCurrentOption() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURI);
        Thread.sleep(5000);
        // WebElement mySelectElement = driver.findElement(By.name("riskTable_length"));
        Select select = new Select(driver.findElement(By.name("riskTable_length")));
        WebElement option = select.getFirstSelectedOption();
        String defaultItem = option.getText();
        System.out.println(defaultItem);

    }

    // Test 3 : Clicking on any of the entries in this table should open a page similar to the link and
    // validating the des value in query parameter to this opened page
    @Test
    public void verifyLinkClick() throws Exception {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseURI);
        Thread.sleep(5000);

        List<WebElement> demovar=driver.findElements(By.xpath("/html/body/div[6]/div[5]/div/div[1]/table/tbody/tr[15]/td[1]/a"));
        System.out.println(demovar.size());

        ArrayList<String> hrefs = new ArrayList<String>(); //List for storing all href values for 'a' tag

        for (WebElement var : demovar) {
            System.out.println(var.getText()); // used to get text present between the anchor tags
            System.out.println(var.getAttribute("href"));
            hrefs.add(var.getAttribute("href"));
            System.out.println("*************************************");
        }

        //Navigating to the link and verifying the 'des' query parameter
        int i=0;
        for (String href : hrefs) {
            driver.navigate().to(href);
            System.out.println((++i)+": navigated to URL with href: "+href);
            Thread.sleep(3000); // To check if the navigation is happening properly.
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        }



            }
        }









