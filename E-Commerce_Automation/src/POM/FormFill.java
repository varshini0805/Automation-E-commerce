package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import Generic.BaseTest;

public class FormFill extends BaseTest {
	public FormFill(WebDriver d)
	{
		driver=d;
		PageFactory.initElements(d, this);
	}
	
	WebDriver driver;
	
	
	@FindBy(id="id_gender2")
	WebElement title;
	
	@FindBy(id="customer_firstname")
	WebElement fname;
	
	@FindBy(id="customer_lastname")
	WebElement lname;
	
	@FindBy(id="passwd")
	WebElement pswd;
	
	@FindBy(id="days")
	WebElement date;
	
	@FindBy(id="months")
	WebElement mon;
	
	@FindBy(id="years")
	WebElement yrs;
	
	@FindBy(id="company")
	WebElement company;
	
	@FindBy(id="address1")
	WebElement address;
	
	@FindBy(id="address2")
	WebElement address2;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="other")
	WebElement other;
	
	@FindBy(id="phone_mobile")
	WebElement phone;
	
	@FindBy(id="alias")
	WebElement alias;
	
	
	
	@FindBy(how= How.XPATH,using= "//span[.='Register']")
	WebElement register;
	
	@FindBy(id="city")
	WebElement city;
	
	public void title()
	{
		title.click();
	}
	
	public void fName(String name)
	{
		fname.sendKeys(name);
	}
	
	public void lName(String lnme)
	{
		lname.sendKeys(lnme);
	}
	
	public void password(String pswdd)
	{
		pswd.sendKeys(pswdd);
	}
	
	public void phone(String phn)
	{
		phone.sendKeys(phn);
	}
	
	
	/*public void dOB(int day)
	{
		Select s= new Select(date);
		  s.selectByIndex(day);
	}
	
	public void month(String month)
	{
		Select s= new Select(mon);
		 // s.selectByIndex(month);
		List<WebElement> months = s.getOptions();
		
		for(int i=0;i<months.size();i++)
		{
			
			String mn = months.get(i).getText();
			if(mn.equals(month))
			{
				months.get(i).click();
			}
		}
	}
	
	public void yrs(String years)
	{
		Select sc= new Select(yrs);
		sc.selectByValue(years);
	}*/
	
	public void date(String xpath,String value)
	{
		
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		//Select s = new Select((WebElement) path);
		
		//List<WebElement> dmy = s.getOptions();
		
		for(int i=0;i<list.size();i++)
		{
			String day = list.get(i).getText();
			if(day.equals(value))
			{
				list.get(i).click();
			}
		}
	}
	
	public void company(String cName)
	{
		company.sendKeys(cName);
	}
	
	public void address(String add)
	{
		address.sendKeys(add);
	}
	
	public void address2(String add2)
	{
		address2.sendKeys(add2);
	}
	
	public void postcode(String pcode)
	{
		postcode.sendKeys(pcode);
	}
	
	public void other(String othr)
	{
		other.sendKeys(othr);
	}
	
	public void alias(String als)
	{
		alias.sendKeys(als);
	}
	
	public void city(String citi)
	{
		city.sendKeys(citi);
	}
	
	public void register()
	{
		register.click();
	}
	
}
