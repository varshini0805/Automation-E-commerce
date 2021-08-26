package Scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic.BaseTest;
import Generic.ReadConfig;
import POM.CreateAccount;
import POM.WomenPage;

public class WomenPage_TestCase3 extends BaseTest {
	
	@Test
	public void women() throws InterruptedException, IOException
	{
		String scroll_ele="//span[.='Availability']";
		
		String Scroll_addcart ="(//span[.='Total'])[1]";
		String Scroll_addresspage ="//a[contains(.,'Continue Shopping')]";
		String Scroll_shipping = "//strong[.='My carrier']";
		String Scroll_payment1="(//span[.='Total'])[2]";
		String Scroll_payment = "//a[contains(.,'Other payment methods')]";
		
		String Scroll_OrderComplete ="//div[@class='box']";
		
		
		WomenPage wp= new WomenPage(driver);
		
		wp.women_Hover();
		wp.click_tshirt();
		
		Thread.sleep(3000);
		scrollInto(scroll_ele);
		
		
		wp.tee_cart();
		wp.proceed_Tocart();
		
		Thread.sleep(2000);
		scrollInto(Scroll_addcart);
		wp.proceed_tocheckout();
		Thread.sleep(2000);
		screenShot(driver,"CheckoutSC");
		
		CreateAccount ac= new CreateAccount(driver);
		ReadConfig rc= new ReadConfig();
		ac.email_signin(rc.getEmail());
		ac.pswd_signin(rc.getPassword());
		ac.submit();
		
		
		
		String Expt_txt="Use the delivery address as the billing address.";
		String Actl_txt = driver.findElement(By.xpath("//label[@for='addressesAreEquals']")).getText();
		
		if(Expt_txt.equals(Actl_txt))
		{
			Assert.assertTrue(true);
			System.out.println("Test Correct");
			screenShot(driver,"test3_correct");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Error occured");
			screenShot(driver,"test3_error");
		}
		
		scrollInto(Scroll_addresspage);
		wp.proceed_tocheckout();
		
		scrollInto(Scroll_shipping);
		wp.termsCond();
		wp.ship_checkout();
		
		scrollInto(Scroll_payment1);
		wp.payment();
		
		scrollInto(Scroll_payment);
		wp.confirmOrder();
		
				
		
		String final_expt ="Your order on My Store is complete.";
		String final_actual= driver.findElement(By.xpath("//strong[contains(.,'Your order on My Store is complete.')]")).getText();
		
		if(final_expt.equals(final_actual))
		{
			Assert.assertTrue(true);
			System.out.println("Order placed");
			scrollInto(Scroll_OrderComplete);
			screenShot(driver,"Order_placed");
		}
		else
		{
			Assert.assertTrue(false);
			System.out.println("Error occured");
			screenShot(driver,"Order_notplaced");
		}
		
	}
}
