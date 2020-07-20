package page;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SrchPage {
	
	public WebDriver driver;
	Logger log  = Logger.getLogger(LoggedInPage.class);

	@FindBy(xpath="//span[@class='js-close-noti-popup pushNotification']")
	WebElement notifier;
	
	@FindBy(xpath="//div[@class=\'search-input__inputstyle bdr-4 p-10 mb-10\']")
	WebElement srchBar;
	
	@FindBy(id="id_q")
	WebElement skillset;
	
	@FindBy(id="id_loc")
	WebElement City;
	
	@FindBy(id="searchBar_experience")
	WebElement experience;
	
	@FindBy(xpath="//label[text()='2 Yrs']")
	WebElement Yrs2;
	
	@FindBy(id="id_new_search_submit_button")
	WebElement srchBtn;
	
	@FindBy(xpath="//div[contains(@class,'SearchResult__jobs')]//following::strong[1]")
	WebElement dsply;
	
	public SrchPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void giveSkillandLocation(String skill,String cty )
	{
		driver.manage().timeouts().implicitlyWait(1600,TimeUnit.SECONDS);
		notifier.click();
		srchBar.click();
		
		skillset.clear();
		skillset.sendKeys(skill);
		
		City.clear();
		City.sendKeys(cty);
	
	}
	
	public void giveExprnc()
	{
		experience.click();
		Yrs2.click();
	}
	
	public void getCount()
	{
		srchBtn.click();
		log.info(dsply.getText());
	}
}
