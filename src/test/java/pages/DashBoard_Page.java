package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static step_Defintions.Setup.driver;


public class DashBoard_Page {

    public WebElement User_Profile_DropDown(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
    }

    public WebElement DashBoard_Header_TXT(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6"));
    }

}
