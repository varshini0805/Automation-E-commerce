package POM;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class SocialBlock extends BaseTest{

	WebDriver driver;
	public SocialBlock(WebDriver d)
	{
	driver=d;
	PageFactory.initElements(d, this);
	}
	
	
	/*@FindBy(className="facebook")
	WebElement fb;
	
	@FindBy(how=How.XPATH,using="(//span[.='Join Group'])[2]")
	WebElement joinGrp; */
	
/*	public void facebook()
	{
		fb.click();
	}
	
	public void joinGroup()
	{
		joinGrp.click();
	} */
	
	public void switchToChild() throws InterruptedException
	{
		String parent = driver.getWindowHandle();
		driver.findElement(By.className("facebook")).click();
		System.out.println("Parent window "+parent);
	
		Set<String> child = driver.getWindowHandles();
		
		Iterator<String> chWin = child.iterator();
		
	/*	while(chWin.hasNext())
		{
		String childWindow = chWin.next();
		driver.switchTo().window(childWindow);
		
		Thread.sleep(2000);

		}
		
		driver.findElement(By.xpath("//div[@aria-label='Join Group']")).click(); */

		for( String ss: child)
		{
			System.out.println( "Child window"+ss);
			
			if(!child.equals(parent))
			{
				
				driver.switchTo().window(ss);
				
				Thread.sleep(2000);
			
			}

		} 
		
		driver.findElement(By.xpath("(//span[.='Join Group'])[2]")).click();
		
		driver.switchTo().window(parent);
	}
	
	
}
