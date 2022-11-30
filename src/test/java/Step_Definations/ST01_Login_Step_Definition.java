package Step_Definations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.concurrent.TimeUnit;
import static Step_Definations.Setup.*;


public class ST01_Login_Step_Definition {

    @Given("User open the browser and navigate to Login Page")
    public void Open_Driver_And_navigate(){
        Pages_Setup();
        }

    @When("Leave Email and Password Fields Empty")
    public void Empty_Fields(){
        driver.manage().timeouts().implicitlyWait( WaitTime , TimeUnit.SECONDS);
        Login.UserName_TextBox().sendKeys("");
        Login.Password_TextBox().sendKeys("");
    }

    @Then("User click on Login Button")
    public void Click_On_LoginBTN(){
        driver.manage().timeouts().implicitlyWait(WaitTime, TimeUnit.SECONDS);
        Login.Login_Button().click();
    }

    @And("User Still on Login Page")
    public void User_On_LoginPage(){
        driver.manage().timeouts().implicitlyWait(WaitTime, TimeUnit.SECONDS);
        // soft assert that user on Login page and LOGIN title (Login) is appeared
        String Actual_result = Login.LoginPageTitleTxt_LOGIN().getText();
        String Expected_result = "Login";
        soft.assertTrue(Expected_result.equals(Actual_result), "Assertion on the Login title in Login Page");

        soft.assertTrue(Login.LoginPage_IMG().isDisplayed());

        soft.assertAll();
    }

    @And("Login Fail with error message Field required user pass")
    public void Login_Fail_FieldRequired() {
        String Expected_result = "Required";
        String Actual_result_User = Login.User_Err_MSG_Required().getText();
        String Actual_result_Pass = Login.Pass_Err_MSG_Required().getText();

        soft.assertEquals(Actual_result_User,Expected_result,"Assert on (Required) User_err_msg is appeared");
        soft.assertEquals(Actual_result_Pass,Expected_result,"Assert on (Required) Pass_err_msg is appeared");

        soft.assertAll();

    }

    @When("^Enter valid user_name which is \"(.*)\" with Wrong Password which is \"(.*)\"$")
    public void Valid_UserName(String user , String Pass){

    driver.manage().timeouts().implicitlyWait(WaitTime,TimeUnit.SECONDS);
    Login.UserName_TextBox().sendKeys(user);
    Login.Password_TextBox().sendKeys(Pass);
    }

    @And("Login Fail with error message Invalid credentials")
    public void Invalid_Credentials(){
        String Expected_result = "Invalid credentials";
        String Actual_result = Login.Invalid_Credentials_ErrMsg().getText();
        soft.assertEquals(Actual_result,Expected_result,"Assert on (Invalid Credentials) keyword is appeared");

    }

    @When("^Enter Invalid user_name which is \"(.*)\" with Valid Password which is \"(.*)\"$")
    public void Valid_Pass(String user , String Pass){
        driver.manage().timeouts().implicitlyWait(WaitTime,TimeUnit.SECONDS);
        Login.UserName_TextBox().sendKeys(user);
        Login.Password_TextBox().sendKeys(Pass);
    }

    @When("^Enter Valid user_name which is \"(.*)\" with Empty Password$")
    public void Valid_UserName(String UserName){

        driver.manage().timeouts().implicitlyWait(WaitTime,TimeUnit.SECONDS);
        Login.UserName_TextBox().sendKeys(UserName);
        Login.Password_TextBox().sendKeys("");
    }

    @And("Login Fail with error message Field required pass")
    public void Login_Fail_Pass_Required(){
        String Expected_result = "Required";
        String Actual_result = Login.Pass_Err_MSG_Required().getText();
        // assert on the (required) keyword is appeared under password field
        soft.assertEquals(Expected_result,Actual_result,"assert on the (required) keyword is appeared under password field");

    }

    @When("^Enter Valid Password which is \"(.*)\" with Empty UserName$")
    public void Login_Fail_UserName_Required(String Pass){
        driver.manage().timeouts().implicitlyWait(WaitTime,TimeUnit.SECONDS);
        Login.UserName_TextBox().sendKeys("");
        Login.Password_TextBox().sendKeys(Pass);
    }

    @And("Login Fail with error message Field required user")
    public void Login_Fail_UserName_Required(){
        String Expected_result = "Required";
        String Actual_result = Login.User_Err_MSG_Required().getText();
        // assert on the (required) keyword is appeared under UserName field
        soft.assertEquals(Expected_result,Actual_result,"assert on the (required) keyword is appeared under UserName field");

    }

    @When("^Enter Valid user_name which is \"(.*)\" with Valid Password which is \"(.*)\"$")
    public void Valid_UserName_Pass(String UserName , String Pass){
        driver.manage().timeouts().implicitlyWait(WaitTime,TimeUnit.SECONDS);
        Login.UserName_TextBox().sendKeys(UserName);
        Login.Password_TextBox().sendKeys(Pass);
    }

    @Then("Login Success and User directed to Dashboard Page")
    public void Login_Success(){
        // use implicit wait till URL changed
        driver.manage().timeouts().implicitlyWait(WaitTime,TimeUnit.SECONDS);

        // Assert that user on Login successfully and user directed to dashboard page and Dashboard title is appeared
        String Actual_result = Dashboard.DashBoard_Header_TXT().getText();
        String Expected_result = "Dashboard";
        soft.assertTrue(Expected_result.equals(Actual_result), "Assertion on the dashboard title on the dashboard Page");

        // Assert that user is Login successfully and directed to dashboard page and Dashboard dropdown is appeared
        //wait.until(ExpectedConditions.elementToBeClickable(Dashboard.User_Profile_DropDown()));
        soft.assertTrue(Dashboard.User_Profile_DropDown().isDisplayed(), "Assertion for user dropdown in dashboard");

        // Assert that the URL is changed to dashboard URL
        String URL_Actual_result = driver.getCurrentUrl();
        String URL_Expected_result = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        soft.assertEquals(URL_Expected_result,URL_Actual_result,"assert on URL is changed");

        soft.assertAll();

    }
    }



