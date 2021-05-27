package com.VisionIT_OrangeHRM_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.VisionIT_OrangeHRM_TestBase.TestBase;

public class AddCartPage extends TestBase
{
	WebDriver d;

//------------------------------------------------------------------------------------------	
	@FindBy(xpath="//*[@id='homefeatured']/li[1]/div")
	@CacheLookup
	WebElement FadedMoveToProduct;	
	
	@FindBy(xpath="//*[@id='homefeatured']/li[1]/div/div[2]/h5/a")
	@CacheLookup
	WebElement Faded_TshirtsEle;
	
	@FindBy(xpath="//*[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]/span")
	@CacheLookup
	WebElement Faded_Short_AddToCart_Btn;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='homefeatured']/li[2]/div")
	@CacheLookup
	WebElement BlouseMoveToProduct;	
	
	@FindBy(xpath="//*[@id='homefeatured']/li[2]/div/div[2]/h5/a")
	@CacheLookup
	WebElement BlouseEle;
	
	@FindBy(xpath="//*[@id='homefeatured']/li[2]/div/div[2]/div[2]/a[1]/span")
	@CacheLookup
	WebElement BlouseEle_Btn;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='homefeatured']/li[7]/div")
	@CacheLookup
	WebElement PrintedChiffonDressMoveToProduct;	
	
	@FindBy(xpath="//*[@id='homefeatured']/li[7]/div/div[2]/h5/a")
	@CacheLookup
	WebElement PrintedChiffonDressEle;
	
	@FindBy(xpath="//*[@id='homefeatured']/li[7]/div/div[2]/div[2]/a[1]/span")
	@CacheLookup
	WebElement PrintedChiffonDress_Btn;
//------------------------------------------------------------------------------------------
	@FindBy(xpath = "//*[@class='continue btn btn-default button exclusive-medium']")
	@CacheLookup
	WebElement ContinueShopping_Btn;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")
	@CacheLookup
	WebElement Proceedtocheckout_Btn;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='layer_cart']/div[1]/div[1]/span")
	@CacheLookup
	WebElement closeWin_Btn;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='header']/div[3]/div/div/div[3]/div/a/span[1]")
	@CacheLookup
	WebElement cartValue;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//div[@class='cart-prices']/div[2]/span[1]")
	@CacheLookup
	WebElement cartTotalPrice;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt[1]/div/div[1]/a")
	@CacheLookup
	WebElement underCartPro1;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt[2]/div/div[1]/a")
	@CacheLookup
	WebElement underCartPro2;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt[3]/div/div[1]/a")
	@CacheLookup
	WebElement underCartPro3;
//------------------------------------------------------------------------------------------
	@FindBy(xpath="//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt[1]/span/a")
	@CacheLookup
	WebElement removeProductFromCart;
//------------------------------------------------------------------------------------------
	//*[@id="header"]/div[3]/div/div/div[3]/div/div/div/div/dl/dt[2]/span/a
	//*[@id='header']/div[3]/div/div/div[3]/div/div/div/div/dl/dt[1]/span/a
	public AddCartPage(WebDriver d) 
	{
		this.d = d;
		PageFactory.initElements(d, this);
	}

	public void removeProductFromCart()
	{
		removeProductFromCart.click();
	}
	
	public String cartTotalPrice()
	{
		String price = cartTotalPrice.getText();
		return price;
//		System.out.println("total price - " + price);
	}

	public void cartMoveToElement()
	{
		Actions builder = new Actions(d);
		Action act = builder.moveToElement(cartValue).build();
			act.perform();
	}
	public void fadedMoveToElement()
	{
		Actions builder = new Actions(d);
		Action act = builder.moveToElement(FadedMoveToProduct).build();
			act.perform();
	}
	public void faded_TshirtsBtn()
	{
		Faded_Short_AddToCart_Btn.click();
	}
	
	public void blouseMoveToElement()
	{
		Actions builder = new Actions(d);
		Action act = builder.moveToElement(BlouseMoveToProduct).build();
			act.perform();
	}	
	public void blouseBtn()
	{
		BlouseEle_Btn.click();
	}
	
	public void printedChiffonDressMoveToElement()
	{
		Actions builder = new Actions(d);
		Action act = builder.moveToElement(PrintedChiffonDressMoveToProduct).build();
			act.perform();
	}	
	public void printedChiffonDressBtn()
	{
		PrintedChiffonDress_Btn.click();
	}
	
	public void addToCart(String proName) throws Exception
	{		
		String productName1 = Faded_TshirtsEle.getAttribute("title");	
//		System.out.println(productName1);
		if (proName.equals(productName1)) 
		{
			Faded_Short_AddToCart_Btn.click();
		}
		
		String productName2 = BlouseEle.getAttribute("title");
//		System.out.println(productName2);

		if (proName.equals(productName2)) 
		{
			BlouseEle_Btn.click();
		}
		
/*		String productName3 = Printed_DressEle1.getAttribute("title");
		if (productName3.contains(proName)) 
		{
			Printed_DressEle_Btn1.click();
		}
		
		String productName4 = Printed_DressEle2.getAttribute("title");
		if (productName4.contains(proName)) 
		{
			Printed_DressEle_Btn2.click();
		}
		
		String productName5 = PrintedSummerDressEle1.getAttribute("title");
		if (productName5.contains(proName)) 
		{
			PrintedSummerDress_Btn1.click();
		}
		
		String productName6 = PrintedSummerDressEle2.getAttribute("title");
		if (productName6.contains(proName)) 
		{
			PrintedSummerDress_Btn2.click();
		}*/
		
		String productName7 = PrintedChiffonDressEle.getAttribute("title");	
		if (productName7.equals(proName)) 
		{
			PrintedChiffonDress_Btn.click();
		}
		
		else 
		{
			System.out.println("No Such Product");
		}
	}

	public void continueShopBtn()
	{
		ContinueShopping_Btn.click();
	}
	
	public void proceedToCheckoutBtn()
	{
		Proceedtocheckout_Btn.click();
	}
	
	public void closeCartWin()
	{
		closeWin_Btn.click();
	}
	
	public String cartValue()
	{
		String cartQua = cartValue.getText();
//		int cartQuantity = Integer.valueOf(cartQua);
		return cartQua;
	}
}
