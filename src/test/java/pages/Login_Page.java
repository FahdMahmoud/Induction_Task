package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static step_Defintions.Setup.driver;

public class Login_Page {

    public WebElement UserName_TextBox(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
    }

    public WebElement Password_TextBox(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
    }

    public WebElement LoginPageTitleTxt_LOGIN(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5"));

    }

    public WebElement Login_Button(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
    }

    public WebElement LoginPage_IMG(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]"));
    }

    public WebElement User_Err_MSG_Required(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span"));
    }

    public WebElement Pass_Err_MSG_Required(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span"));
    }

    public WebElement Invalid_Credentials_ErrMsg(){
        return driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p"));
    }

}

