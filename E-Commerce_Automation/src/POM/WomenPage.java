package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Generic.BaseTest;

public class WomenPage extends BaseTest {
	WebDriver driver;
	public WomenPage(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	

	@FindBy(how= How.XPATH, using="//a[.='Women']")
	WebElement womenhover;
	
	@FindBy(how=How.XPATH, using ="(//a[@title='T-shirts'])[1]")
	WebElement clickTshirt;
	
	@FindBy(how=How.XPATH, using ="//img[@title='Faded Short Sleeve T-shirts']")
	WebElement img_tee;
	
	
	
	@FindBy(how=How.XPATH,using ="(//a[@data-id-product='1'])[1]")
	WebElement tee_Addcart;
	
	@FindBy(how=How.XPATH, using="//span[contains(.,'Proceed to checkout')] ")
	WebElement pro_cart;
	
	@FindBy(how= How.XPATH, using= "//span[.='Proceed to checkout']")
	WebElement pro_checkout;
	
	@FindBy(id="uniform-cgv")
	WebElement terms_cond;
	
	@FindBy(how=How.XPATH, using ="(//span[contains(.,'Proceed to checkout')])[2]")
	WebElement ship_checkout;
	
	@FindBy(how=How.XPATH,using ="//a[contains(.,'Pay by bank wire')]")
	WebElement payment;
	
	@FindBy(how=How.XPATH,using="//span[contains(.,'I confirm my order')]")
	WebElement confirmOrder;
	
	public void women_Hover()
	{
		Actions ac= new Actions(driver);
		ac.moveToElement(womenhover).perform();
	}
	
	public void click_tshirt()
	{
		clickTshirt.click();
	}
	//Scroll method is in base class(Genenic)
	/*public void window_Scroll()
	{
		WebElement a = driver.findElement(By.xpath("//span[.='Availability']"));
	JavascriptExecutor js =(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);",a);
	} */
	
	public void mouseover_tee()
	{
		WebElement b = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		Actions ac= new Actions(driver);
		ac.moveToElement(b).perform();
	}
	
	
	
	public void tee_cart()
	{
		tee_Addcart.click();
	}
	
	public void proceed_Tocart()
	{
		pro_cart.click();
	}
	
	public void proceed_tocheckout()
	{
		pro_checkout.click();
	}
	
	public void termsCond()
	{
		terms_cond.click();
	}
	
	public void ship_checkout()
	{
		ship_checkout.click();
	}
	
	public void payment()
	{
		payment.click();
	}
	
	public void confirmOrder()
	{
		confirmOrder.click();
	}
}
