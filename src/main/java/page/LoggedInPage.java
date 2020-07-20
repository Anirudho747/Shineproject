package page;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoggedInPage {
	
public WebDriver driver;
Logger log  = Logger.getLogger(LoggedInPage.class);

@FindBy(css="#ReactContainer > div:nth-child(1) > div.ffht > section.txright.rightcolumn_profile.cls_scrollerMainParent > div.updateFlowContainer > div.top_band > strong")
WebElement cpoint;

@FindBy(xpath="//li[@class='dropdown posRel infomenu carrerInfo lgout']")
WebElement myAccount;

@FindBy(xpath="//a[text()='Sign out']")
WebElement signOut;

public LoggedInPage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

public void verifyLogIn()
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(700));
	wait.until(ExpectedConditions.elementToBeClickable(cpoint));
	driver.manage().timeouts().pageLoadTimeout(430, TimeUnit.SECONDS);
    Assert.assertEquals("https://www.shine.com/myshine/home/", driver.getCurrentUrl());
}

public void hover_over()
{
	 Actions act = new Actions(driver);
	 act.moveToElement(myAccount).perform();
}

public void logOut()
{
	signOut.click();
}

public void verifyLogOut()
{
	log.info(driver.getCurrentUrl());
    Assert.assertEquals("https://www.shine.com/myshine/logout/", driver.getCurrentUrl());
}

}
