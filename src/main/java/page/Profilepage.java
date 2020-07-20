package page;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profilepage {
	
	public WebDriver driver;
	Logger log  = Logger.getLogger(Profilepage.class);
	
	@FindBy(xpath="//div[@class='logo']//following::a[@href='/myshine/myprofile/'][1]")
	WebElement click1;
	
	@FindBy(xpath="//div[@class='logo']//following::a[@href='/myshine/myprofile/'][1]//following::a[text()='My Profile']")
	WebElement click2;
	
	@FindBy(id="edit-icon-personal-details-web")
	WebElement edit;
	
	@FindBy(id="id_name")
	WebElement name;
	
	@FindBy(id="id_cell_phone")
	WebElement cellnumber;
	
	@FindBy(id="id-save-personal-details-web")
	WebElement sbmtbtn;
	
	@FindBy(css="#id_myProfileNew > li:nth-child(1) > em")
	WebElement updatedName;
	
	@FindBy(css="#id_myProfileNew > li:nth-child(3) > em")
	WebElement updatedCell;
	
	public Profilepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click_EditBtn()
	{
		driver.manage().timeouts().implicitlyWait(1600,TimeUnit.SECONDS);
		click1.click();
		//click2.click();
		
	}
	
	public void updt_Name_and_cell(String C_name, String Cell)
	{
		edit.click();
		name.clear();
		name.sendKeys(C_name);
		
		cellnumber.clear();
		cellnumber.sendKeys(Cell);
		
		//driver.manage().timeouts().implicitlyWait(1600, TimeUnit.SECONDS);
		sbmtbtn.click();
	}
	
	public void verify_Name_and_cell(String C_name, String Cell)
	{
		 Assert.assertEquals(C_name, updatedName.getText());
		 Assert.assertEquals("+91-"+Cell, updatedCell.getText());
	}

}
