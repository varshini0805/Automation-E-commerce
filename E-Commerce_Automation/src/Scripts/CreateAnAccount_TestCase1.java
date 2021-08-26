package Scripts;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic.BaseTest;
import POM.CreateAccount;
import POM.FormFill;

public class CreateAnAccount_TestCase1 extends BaseTest {

	String monXpath="//select[@id='months']//option";
	String dayXpath="//select[@id='days']//option";
	String yearXpath="//select[@id='years']//option";
	String stateXpath="//select[@id='id_state']/option";
	String countryXpath="//select[@id='id_country']/option";
	
	
	@Test
	public void sendemail()
	{
		CreateAccount createacc = new CreateAccount(driver);
		createacc.enterEmail("uuuu@yahoo.com");
		createacc.createClick();
		FormFill formfil = new FormFill(driver);
		formfil.title();
		formfil.fName("Varshini");
		formfil.lName("Kanive");
		formfil.password("sujan");
		//formfil.dOB(3);
		//formfil.month("February ");
		//formfil.yrs("2020");
		formfil.date(dayXpath, "24  ");
		formfil.date(monXpath, "April ");
		formfil.date(yearXpath,"2019  ");
		formfil.company("SPI");
		formfil.address("2951 S king dr");
		formfil.address2("Apt 1234");
		formfil.postcode("56789");
		formfil.other("xyz");
		formfil.city("Chicago");
		formfil.date(stateXpath, "Illinois");
		formfil.date(countryXpath, "United States");
		formfil.phone("12344567890");
		
		formfil.register();
		//Welcome to your account. Here you can manage all of your personal information and orders
		//p[@class='info-account']
		
		String valid = driver.findElement(By.xpath("//p[@class='info-account']")).getText();
		if(valid.equals("Welcome to your account. Here you can manage all of your personal information and orders."))
		{
			System.out.println("Validated");
		}
		else
		{
			System.out.println("Not validated");
		}
	}
	
	
}
