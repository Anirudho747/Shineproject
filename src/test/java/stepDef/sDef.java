package stepDef;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Base;
import page.HomePage;
import page.LoggedInPage;

public class sDef {
	
	public static WebDriver driver;
	Logger log = Logger.getLogger(sDef.class);
	
	
	
	@Before
	public void before()
	{
		Base b = new Base();
		driver = b.driverInit();
	}
	
	@After
	public void after()
	{
		driver.close();
	}
	
	
	@Given("User is on homepage")
	public void user_is_on_homepage() {
	
		HomePage hp = new HomePage(driver);
		hp.go_To_HomePage();
	}

	@When("User clicks on Login Button")
	public void user_clicks_on_Login_Button() {
	 
		HomePage hp = new HomePage(driver);
		hp.click_SignIn();
	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String uname, String psswrd) {
    	HomePage hp = new HomePage(driver);
		hp.sign_In(uname, psswrd);
   
	}
	@Then("User should be able to Login to his\\/her Naukri Account")
	public void user_should_be_able_to_Login_to_his_her_Naukri_Account() {
	  	LoggedInPage lp = new LoggedInPage(driver);
		lp.verifyLogIn();
	}
	
	@When("User's mouse hovers over My Name Option")
	public void user_s_mouse_hovers_over_My_Naukri_Option() {
		 /*WebElement My_Acc = driver.findElement(By.xpath("//li[@class='dropdown posRel infomenu carrerInfo lgout']"));
		 Actions act = new Actions(driver);
		 act.moveToElement(My_Acc).perform();
		 */
		LoggedInPage lp = new LoggedInPage(driver);
		lp.hover_over();
	}

	@When("User clicks on Logout Option")
	public void user_clicks_on_Logout_Option() {
	   //driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		LoggedInPage lp = new LoggedInPage(driver);
	   lp.logOut();
	}
	@Then("User should be logged out of Shine portal")
	public void user_should_be_logged_out_of_Naukri_portal() {
	  //  System.out.println(driver.getCurrentUrl());
		/*log.info(driver.getCurrentUrl());
	    Assert.assertEquals("https://www.shine.com/myshine/logout/", driver.getCurrentUrl());
	    */
		LoggedInPage lp = new LoggedInPage(driver);
		lp.verifyLogOut();
	}

}
