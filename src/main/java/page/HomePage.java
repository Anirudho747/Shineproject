package page;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

	  public WebDriver driver;
	  Logger log = Logger.getLogger(HomePage.class);
	
	    @FindBy(xpath="//a[@title='Jobseeker Login']")
		WebElement Login;
		
		@FindBy(id="id_email_login")
		WebElement EmailID;
		
		@FindBy(id="id_password")
		WebElement Password;
		
		@FindBy(xpath="//button[@name='login_popup']")
		WebElement Login_Btn;
	   
		
		public HomePage(WebDriver driver)
		{
			this.driver= driver;
			PageFactory.initElements(driver, this);
		}
		
		public void go_To_HomePage()
		{
			 driver.navigate().to("https://www.shine.com/");
		}
		
		public void click_SignIn()
		{
			Login.click();
		}
		
		public void sign_In(String usr, String psswrd)
		{
			EmailID.sendKeys("");
			EmailID.sendKeys(usr);
			
			Password.sendKeys("");
			Password.sendKeys(psswrd);
			
			Login_Btn.click();
		}
}
