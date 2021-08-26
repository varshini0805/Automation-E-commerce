package Grid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginGrid {

	public WebDriver driver;
	
	@Test(priority=1)
	public void setUp() throws MalformedURLException
	{
		String node="http://192.168.0.10:4444/wd/hub";
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.MAC);
		
		System.setProperty("webdriver.chrome.driver", "C:\\JavaWorkspace\\Driver\\chromedriver.exe");
		driver= new RemoteWebDriver(new URL(node),cap);
		
		
	}
	
	
	@Test(priority=2)
	public void login()
	{
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		String Actualtitle = driver.getTitle();
		String expectedTxt="nopCommerce demo store"; 
		Assert.assertEquals(Actualtitle, expectedTxt);
	}
}
