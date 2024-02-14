package org.libgobal;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class ProductListWithAssertion extends BaseClass{
	
	@BeforeClass
	public static void beforeClass (){
		browserLaunch();
		enterApplnUrl("https://omrbranch.com/");
		maximizeWindow();
		implictWait();
	}

	@Test
	public void productBooking() throws IOException, InterruptedException
	{
		
		WebElement txtEmail=findElementById("email");
		sendKeys(txtEmail,getCellData("hello",1,0));
		WebElement textpass = findElementById("pass");
		sendKeys(textpass,getCellData("hello",1,1));
		WebElement login = findelementByXpath(("(//button[@type='submit'])[1]"));
		javaScriptclick(login);
		WebElement welcome = findelementByXpath("//a[@data-testid='username']");
		String productTextname = elementGetText(welcome);
		//System.out.println(productTextname);
		//Assert.assertEquals("Welcome SELLA",productTextname);
		Assert.assertEquals("Valid", "Welcome SELLA", productTextname);
		//Assert.assertEquals("verify after login", "Welcome SELLAs", productTextname);
		WebElement productname= findElementBycssselector("#search");
		sendKeys(productname,getCellData("hello", 1, 2));
		findElementBycssselector(".fa-search").click();
		WebElement totalproduct= findElementById("productResult");
		visibilityOfElement(totalproduct);
		findelementByXpath("(//a[text()='Add'])[6]").click();
	    findElementById("cart-31").click();
	    sleep();
		findelementByXpath("//a[text()=' Go To Cart ']").click();
		WebElement mycart = findelementByXpath("//h5[text()='My Cart']");
		String cartname = elementGetText(mycart);
		//System.out.println(cartname);
		Assert.assertEquals("verify", "My Cart", cartname);
		findelementByXpath("//div[@data-toggle='modal']").click();
		WebElement address= findElementBycssselector("#address_type");
		address.click();
		selectByIndex(address,3);
		WebElement firstname = findelementByXpath("(//input[@name='first_name'])[1]");
		sendKeys(firstname, getCellData("hello", 1, 3));
		WebElement lastname = findelementByXpath("(//input[@name='last_name'])[1]");
		sendKeys(lastname, getCellData("hello", 1, 4));
		WebElement moiblenumber = findelementByXpath("//input[@name='mobile']");
		sendKeys(moiblenumber, getCellData("hello", 1, 5));
		WebElement houseno = findelementByXpath("//input[@name='apartment']");
		sendKeys(houseno, getCellData("hello", 1, 6));
		WebElement homeaddress = findelementByXpath("//input[@name='address']");
		sendKeys(homeaddress, getCellData("hello", 1, 7));
		WebElement countryname = findelementByXpath("//select[@name='country']");
		countryname.click();
		selectByIndex(countryname, 1);
		WebElement statename = findelementByXpath("//select[@name='state']");
		statename.click();
		selectByText(statename,getCellData("hello", 1, 9));
		//selectByText(statename,"Tamil Nadu");
		WebElement cityname = findelementByXpath("//select[@name='city']");
		cityname.click();
		selectByText(cityname,getCellData("hello", 1, 10));
		//selectByText(cityname,"Chennai");
		WebElement zipcode = findelementByXpath("//input[@name='zipcode']");
		sendKeys(zipcode,getCellData("hello", 1, 12));
		findelementByXpath("(//button[@type='submit'])[3]").click();
		//elementOkDimiss();
		sleep();
		WebElement card = findelementByXpath("//select[@id='payment_type']");
		card.click();
		selectByText(card,getCellData("hello", 1, 12));
		findelementByXpath("//label[@for='visa_card']").click();
		WebElement cardnumber = findelementByXpath("//input[@name='card_no']");
		sendKeys(cardnumber,getCellData("hello",1,13));
		WebElement month = findelementByXpath("//select[@id='month']");
		month.click();
		selectByText(month,getCellData("hello", 1, 14));
		WebElement years = findelementByXpath("(//select[@name='year'])[1]");
		years.click();
		visibilityOfElement(years);
		WebElement year = findElementBycssselector("#year");
		year.click();
		selectByValue(year, getCellData("hello", 1, 15));
		WebElement cvv = findelementByXpath("//input[@name='cvv']");
		sendKeys(cvv, getCellData("hello", 1, 16));
		findelementByXpath("//button[@id='placeOrder']").click();
		sleep();
		WebElement orderresult = findelementByXpath("(//span[@class='font16 fontNormal color36'])[1]");
		String orderno = orderresult.getText();
		//System.out.println(orderno);
		//String expectedOrderNumber = "your_expected_order_number";
		//Assert.assertEquals(orderno, expectedOrderNumber, "Order number mismatch");
		Assert.assertNotSame(orderno, 875336);
		findelementByXpath("//a[@data-testid='username']").click();
		findelementByXpath("//a[text()='Logout']").click();
		
	}

}
