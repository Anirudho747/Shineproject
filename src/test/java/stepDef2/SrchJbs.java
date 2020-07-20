package stepDef2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.Base;
import page.HomePage;
import page.Profilepage;
import page.SrchPage;

public class SrchJbs {

public static WebDriver driver;
Logger log = Logger.getLogger(SrchJbs.class);


Profilepage pp = new Profilepage(driver);
SrchPage sp = new SrchPage(driver);
	
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
	   driver.navigate().to("https://www.shine.com/");
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
	@When("User searches for {string} in {string}")
	public void user_searches_for_in(String skill, String locn) {
		SrchPage sp = new SrchPage(driver);
		sp.giveSkillandLocation(skill, locn);
	}
	@When("user sets his experience range")
	public void user_sets_his_experience_range() {
		SrchPage sp = new SrchPage(driver);
		sp.giveExprnc();
	}
	@Then("User should be able to get the count of requirements")
	public void user_should_be_able_to_get_the_count_of_requirements() {
	SrchPage sp = new SrchPage(driver);
	        sp.getCount();                                                       
	  }
	
	@When("User clicks on Edit personal details")
	public void user_clicks_on_Edit_personal_details() {
		  Profilepage pp = new Profilepage(driver);
	  pp.click_EditBtn();	
	}
	@When("User updated {string} and {string}")
	public void user_updated_and(String Name, String Nmber) throws InterruptedException {
			Profilepage pp = new Profilepage(driver);
		pp.updt_Name_and_cell(Name, Nmber);
	}

	@Then("User should be able to verify {string} and {string}")
	public void user_should_be_able_to_verify_and(String Name, String Number) {
			Profilepage pp = new Profilepage(driver);
		pp.verify_Name_and_cell(Name, Number);
	}
	
	
}
