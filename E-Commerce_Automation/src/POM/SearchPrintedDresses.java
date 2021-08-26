package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class SearchPrintedDresses {
	WebDriver driver;
	public SearchPrintedDresses(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	@FindBy(id="search_query_top")
	WebElement searchBox;
	
	@FindBy(name="submit_search")
	WebElement ClickSearch;
	
	//@FindBy(how=How.XPATH,using ="//a[.='List']")
	@FindBy(className="icon-th-list")
	//@FindBy(id="list")
	WebElement listc;
	
	@FindBy(how=How.XPATH,using ="(//span[contains(.,'More')])[2]")
	WebElement more_btn;
	
	@FindBy(id="send_friend_button")
	WebElement SendFrnd;
	
	@FindBy(id="friend_name")
	WebElement frndName;
	
	@FindBy(id="friend_email")
	WebElement friendemail;
	
	@FindBy(id="sendEmail")
	WebElement sendKey;
	
	@FindBy(how=How.XPATH,using="//input[@type='button']")
	WebElement okbutton;

	
	
	public void scrollBy()
	{
		JavascriptExecutor js =(JavascriptExecutor) driver;
		for(int i=1;i<=5;i++)
		{
		js.executeScript("window.scrollBy(0, 1000)");
		}
	
	}
	
	public void searchBox(String options)
	{
		searchBox.sendKeys(options);
	}
	
	public void ClickSearch()
	{
		ClickSearch.click();
	}
	
	
		public void listclick()
		{
			try {
			//Wait.until(ExpectedConditions.presenceOfElementLocated(By.id("list")));
			Thread.sleep(2000);
				System.out.println("list start");
			listc.click();
			System.out.println("list end");
		}
			catch(Exception ex)
			{
				System.out.println("LIst not clicked");
				
			}
	}
	
	
	
	public void ClickMore()
	{
		more_btn.click();
	}
	
	public void SendFrnd_click()
	{
		SendFrnd.click();
	}
	
	public void frndName_Enter(String name) 
	{
		frndName.sendKeys(name);
	}
	
	public void friend_email(String email)
	{
		friendemail.sendKeys(email);
	}
	
	public void sendKey_click()
	{
		sendKey.click();
	}
	
	public void button()
	{
		okbutton.click();
	}
}
