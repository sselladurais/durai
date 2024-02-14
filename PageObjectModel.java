package org.libgobal;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.PageObject.CartPage;
import org.PageObject.LoginPage;
import org.PageObject.PaymentPage;
import org.PageObject.ProductPage;
import org.junit.Assert;

public class PageObjectModel extends BaseClass{
	
	
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
		
		LoginPage loginpage=new LoginPage();
		loginpage.LoginBtn();
	
		//System.out.println(productTextname);
		//Assert.assertEquals("Welcome SELLA",productTextname);
		//Assert.assertEquals("Valid", "Welcome SELLA", productTextname);
		//Assert.assertEquals("verify after login", "Welcome SELLAs", productTextname);
		ProductPage productpage=new ProductPage();
		productpage.ProductDetails();
		//Assert.assertEquals("verify", "My Cart", cartname);
		CartPage cartpage=new CartPage();
		cartpage.CartDetails();
		//elementOkDimiss();
		PaymentPage paymentpage=new PaymentPage();
		paymentpage.PaymentDetails();
		WebElement orderresult = findelementByXpath("(//span[@class='font16 fontNormal color36'])[1]");
		String orderno = orderresult.getText();
		//System.out.println(orderno);
		//String expectedOrderNumber = "your_expected_order_number";src
		//Assert.assertEquals(orderno, expectedOrderNumber, "Order number mismatch");
		Assert.assertNotSame(orderno, 875336);
		findelementByXpath("//a[@data-testid='username']").click();
		findelementByXpath("//a[text()='Logout']").click();
		
	}

}
