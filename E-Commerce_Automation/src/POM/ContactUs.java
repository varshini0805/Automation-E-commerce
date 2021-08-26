package POM;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs {

	WebDriver driver;
	public ContactUs(WebDriver d)
	{
	driver=d;
	PageFactory.initElements(d, this);
	}
	
	@FindBy(how=How.XPATH,using="//a[.='Contact us']")
	WebElement ContactUs;
	
	@FindBy(id="id_order")
	WebElement OrderRef;
	
	//@FindBy(how=How.XPATH,using="//span[.='Choose File']")
	@FindBy(id="fileUpload")
	WebElement fileuploadbtn;
	
	@FindBy(id="message")
	WebElement msg;
	
	@FindBy(how=How.XPATH,using ="//span[.='Send']")
	WebElement sendKey;
	
	public void contactUs_click()
	{
		ContactUs.click();
	}
	
	public void OrderRef(String refid)
	{
		OrderRef.sendKeys(refid);
	}
	
	public void file_upload_click(String Fpath) throws InterruptedException, AWTException
	{
		System.out.println("File upload started");
		 WebElement f = driver.findElement(By.xpath("//input[@id='fileUpload']"));
		f.sendKeys(Fpath);
		//fileuploadbtn.click();
		//new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[.='Choose File']")));
		//new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='Choose File']"))).click();
		System.out.println("btn clicked");
		/*StringSelection ss= new StringSelection(Fpath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		Thread.sleep(3000);
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER); */
	}
	
	

	public void message(String msgs)
	{
		msg.sendKeys(msgs);
	}
	
	public void sendKey()
	{
		sendKey.click();
	}
	
	
}
