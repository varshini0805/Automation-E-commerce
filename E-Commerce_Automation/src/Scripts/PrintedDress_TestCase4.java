package Scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.SearchPrintedDresses;

public class PrintedDress_TestCase4 extends BaseTest{

	 
	
	@Test
	public void printeddress() throws InterruptedException
	{
		String sortBy_xpath ="//select[@id='selectProductSort']//option";
		//String Scroll_1= "(//span[contains(.,'In stock')])[2]";
		String Scroll_1="(//a[contains(.,'Blouse')])[2]";
		
		SearchPrintedDresses ds= new SearchPrintedDresses(driver);
		ds.searchBox("Printed Dresses");
		ds.ClickSearch();
		Thread.sleep(2000);
		 
		// new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.id("selectProductSort"))));
		//sortings(sortBy_xpath,"Reference: Lowest first");
		 //driver.findElement(By.id("list")).click();

		Thread.sleep(3000);
		ds.listclick();
		Thread.sleep(3000);
		//ds.scrollBy();
		scrollInto(Scroll_1);
		Thread.sleep(3000);
		//Thread.sleep(2000);
		ds.ClickMore();
		ds.SendFrnd_click();
		ds.frndName_Enter("varsh");
		ds.friend_email("varshi0805@gmail.com");
		ds.sendKey_click();
	//	Alert al = driver.switchTo().alert();
		//al.accept();
		ds.button();
	}
}
