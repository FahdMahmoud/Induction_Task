package step_Defintions;

import pages.DashBoard_Page;
import pages.Login_Page;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class Setup {

    public static WebDriver driver ;
    public static Login_Page Login ;
    public static DashBoard_Page Dashboard ;
    public static WebDriverWait wait ;
    public static SoftAssert soft ;
    public static final int WaitTime = 60 ;

            public static void Pages_Setup(){
                // here we us selenium web driver manger to setup our driver automatically
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                Login = new Login_Page();
                Dashboard = new DashBoard_Page();
                soft = new SoftAssert();
                wait = new WebDriverWait(driver, Duration.ofSeconds(WaitTime));
                driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

    @After
    public static void QuitDriver() {
        driver.quit();
    }
}
