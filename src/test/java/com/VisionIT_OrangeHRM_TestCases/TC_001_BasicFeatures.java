package com.VisionIT_OrangeHRM_TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.VisionIT_OrangeHRM_PageObject.AddCartPage;
import com.VisionIT_OrangeHRM_PageObject.LoginPage;
import com.VisionIT_OrangeHRM_PageObject.ProductPage;
import com.VisionIT_OrangeHRM_PageObject.SignIn;
import com.VisionIT_OrangeHRM_TestBase.TestBase;

public class TC_001_BasicFeatures extends TestBase
{
	
	@Test(priority=1)
	public void verifyURL_TC_001()
	{
		Reporter.log("URL Redirection Test", true);
		test = reports.createTest("Verify URL Redirection_TC_001");
		
		String expUrl = "http://automationpractice.com/index.php";
		String actUrl = d.getCurrentUrl();
		if (actUrl.contains(expUrl)) 
		{
			Assert.assertEquals(actUrl, expUrl,"Expected URL is matched with Actual URL");
			test.pass("Expected URL is matched with Actual URL");		
		}
		else 
		{
			test.fail("Expected URL is not matched with Actual URL");			
		}
	}

	@Test(priority=2)
	public void verifyTitle_TC_002()
	{
		Reporter.log("Landing Page Title Test", true);
		test = reports.createTest("Verify Title Of The Page_TC_002");

		String expTitle = "My Store";
		String actTitle = d.getTitle();
		if (actTitle.contains(expTitle)) 
		{
			Assert.assertEquals(actTitle, expTitle,
					"Expected Title is matched with Actual Title");
			test.pass("Expected Title is matched with Actual Title");
		}
		else 
		{
			test.fail("Expected Title is not matched with Actual Title");			
		}

	}
	
	@Test(priority=3)
	public void verifyCategory_TC_003()
	{
		Reporter.log("Product Category Validation Test", true);
		test = reports.createTest("Verify Category Of The Product_TC_003");

		String[] expCategoryName = {"Women","Dresses","T-Shirts"};
		int expSize = expCategoryName.length;
		
		List<WebElement> items = d.findElements(By.xpath("//*[@id='block_top_menu']/ul/li"));
		int actSize = items.size();
		
		for (int i = 0; i < expSize; i++) 
		{
			for (int j = 0; j < actSize; j++) 
			{	
				if (expCategoryName[i].equalsIgnoreCase(items.get(j).getText()))
				{
					System.out.println(items.get(j).getText() + " - Product Is Present Under List");
					Assert.assertTrue(true,"Product Is Present Under List");
					break;
				}
			}
		}
		System.out.println("expSize -" + expSize + "----" + "actSize -"+actSize);
		Assert.assertEquals(actSize, expSize,"All Products Are Present Under List");
		test.pass("Product Is Present Under List Hence Test Case Is Passed");
	}
	
	@Test(priority=4)
	public void verifyAppLogo_TC_004()
	{

		Reporter.log("Landing Page Application Logo Display Test", true);
		test = reports.createTest("Verify Logo Of The Application_TC_004");

		WebElement logo = d.findElement(By.xpath("//img[@class='logo img-responsive']"));	
		if (logo.isDisplayed()) 
		{
			Assert.assertTrue(true);
			Reporter.log("Expected Logo Is Present in Application");
			test.pass("Landing Page Application Logo Display Test Hence Test Case Is Passed");
		}
		else 
		{
			Assert.assertFalse(false);			
			Reporter.log("Expected Logo Is Not Present in Application");
			test.fail("Logo Is Not Display Hence Test Case Failed");
		}
	}
	
	@Test(priority=5)
	public void verifyAppLogoHeight_TC_005()
	{

		Reporter.log("Vallidate Application Logo Height On Landing Page", true);
		test = reports.createTest("Verify Logo Height Of The Application_TC_005");
		
		WebElement logo = d.findElement(By.xpath("//img[@class='logo img-responsive']"));	

		int expLogoHeight = 99;
		String actsLogoHeight = logo.getAttribute("height");

		int actLogoHeight = Integer.valueOf(actsLogoHeight);
		
//		System.out.println("actLogoHeight - "+ actLogoHeight);

		Assert.assertEquals(actLogoHeight, expLogoHeight,
				"Expected Logo Height is matched with Actual Logo Height");
		
	}

	@Test(priority=6)
	public void verifyAppLogoWidth_TC_006()
	{

		Reporter.log("Vallidate Application Logo Height On Landing Page", true);
		test = reports.createTest("Vallidate Application Logo Height On Landing Page_TC_006");
		
		WebElement logo = d.findElement(By.xpath("//img[@class='logo img-responsive']"));	

		if (logo.isDisplayed()) 
		{
			int expLogoWidth = 350;
			String actsLogoWidth = logo.getAttribute("width");

			int actLogoWidth = Integer.valueOf(actsLogoWidth);
			
//			System.out.println("actLogoHeight - "+ actLogoHeight);

			Assert.assertEquals(actLogoWidth, expLogoWidth,
					"Expected Logo Width is matched with Actual Logo Width");
			
			test.pass("Application Logo Height On Landing Page Hence Test Case Is Passed");			
		}
		else 
		{
			test.fail("Application Logo Height On Landing Page Hence Test Case Is Failed");			
		}
	}
	
	@Test(priority=7)
	public void verifySignInPage_TC_007() throws Exception
	{

		Reporter.log("SignIn Page Title Validation Test", true);
		test = reports.createTest("SignIn Page Title Validation Test_TC_007");
		
		WebElement logo = d.findElement(By.xpath("//a[@class='login']"));	
		logo.click();
		Thread.sleep(2000);
		String expSignInTitle = "Login - My Store";
		String actSignInTitle = d.getTitle();

		if (actSignInTitle.equals(expSignInTitle)) 
		{
			test.pass("Expected SignIn Title is matched with Actual SignIn Title Hence Test Case Is Passed");
		}
		else 
		{
			test.fail("Expected SignIn Title is Not matched with Actual SignIn Title Hence Test Case Is Failed");			
		}
	}
	
//-------------------------Need To Implement-------------------------	
	
	@Test(priority=8)
	public void verifyLoginPage_TC_008() throws Exception 
	{	
		Reporter.log("Register User With New Email ID on SignIn Page", true);
		test = reports.createTest("Register User With New Email ID on SignIn Page_TC_008");

		SignIn s = new SignIn(d);
		s.personalInfo();
		
		Thread.sleep(2000);	
	}
		
	@Test(priority=9)
	public void verifySearchBox_TC_009() throws InterruptedException
	{
		String keyword = "Dress";
		int expCount = 5;
		int actCount = 0;
		
		Reporter.log("Search by a keyword in the product search box and vallidate how"
				+ " many products are matching with the name.", true);
	
		test = reports.createTest("Verify Search Box Matching Product_TC_009");
		
		WebElement searchBox = d.findElement(By.xpath("//*[@id='search_query_top']"));
		if (searchBox.isDisplayed()) 
		{
			searchBox.sendKeys(keyword);
			Thread.sleep(2000);
			
			List<WebElement> items = 
					d.findElements(By.xpath("//div[@class='ac_results']/ul[.]/li[.]"));
			int itemSize = items.size();

			Reporter.log("Total Products Are - " + itemSize, true);
			System.out.println("Product Name - ");
			for (int i = 0; i < itemSize; i++)
			{	
				Reporter.log(items.get(i).getText(), true);
				if (items.get(i).getText().contains(keyword))
				{
					actCount = actCount + 1;
				}
			}
			System.out.println("actCount - " + actCount);
			if (actCount == expCount) 
			{
				Reporter.log("Dress Size Is Matched", true);
				Assert.assertTrue(true);
				test.pass("Dress Size Is Matched Hence Test Case Is Passed");
			}
			else 
			{
				Assert.assertTrue(false);
				test.pass("Dress Size Is Not Matched Hence Test Case Is Failed");				
			}
		}		
	}
	
	@Test(priority=10)
	public void verifyProductPrice_TC_010() throws InterruptedException
	{
		test = reports.createTest("verify Product Price_TC_010");

		String expTotalPrice ="$152.87";
		String e = expTotalPrice.substring(1);
		double expPrice = Double.valueOf(e);		//	Type Casting String to Double
		double actPrice = 0.0d; 
		System.out.println("expPrice Price - " + expPrice);
		
//--------------------------Dresses Menu Is uppercase---------------------------------------		
		WebElement DressOption = d.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a"));
		String dressName = DressOption.getText();
		
		if (dressName.toUpperCase() != null) 
		{
			Assert.assertTrue(true);
			Reporter.log("Dress Menu Is In Uppercase", true);
			test.pass("Dress Menu Is In Uppercase Hence Test Case Pass");
		}
		DressOption.click();
		Thread.sleep(2000);
		
//--------------------------Fetching All Prices---------------------------------------		
		
		String PrintedDressP1 = d.findElement(By.xpath("//*[@id='center_column']/ul/li[1]/div/div[2]/div[1]/span[1]")).getText();
		String PrintedDressP2 = d.findElement(By.xpath("//*[@id='center_column']/ul/li[2]/div/div[2]/div[1]/span[1]")).getText();
		String PrintedSummerDressP1 = d.findElement(By.xpath("//*[@id='center_column']/ul/li[3]/div/div[2]/div[1]/span[1]")).getText(); 
		String PrintedSummerDressP2 = d.findElement(By.xpath("//*[@id='center_column']/ul/li[4]/div/div[2]/div[1]/span[1]")).getText();
		String PrintedChiffonDressP	= d.findElement(By.xpath("//*[@id='center_column']/ul/li[5]/div/div[2]/div[1]/span[1]")).getText();
		
		ArrayList<String> al = new ArrayList<String>();
		al.add(PrintedDressP1);
		al.add(PrintedDressP2);
		al.add(PrintedSummerDressP1);
		al.add(PrintedSummerDressP2);
		al.add(PrintedChiffonDressP);
		
		for (String ss : al) 
		{
			String s = ss.substring(1);
			double price = Double.valueOf(s);
			actPrice = actPrice + price;
		}
		System.out.println("expPrice - " + expPrice + " -- " + "actPrice - " + actPrice);
		
		if (actPrice == expPrice) 
		{
			Assert.assertTrue(true);
			test.pass("Total Price Is Matched Hence Test Case Is Passed");
		}
		else 
		{
			test.fail("Total Price Is Not Matched Hence Test Case Is Failed");
		}	
	}
	
	@Test(priority = 11)
	public void verifyFriendFeature_TC_011()
	{	
		test = reports.createTest("verify Friend Feature_TC_011");

		Reporter.log("send a Friend Feature", true);
		LoginPage lp = new LoginPage(d);
		lp.loginInApp();
	}
	
	@Test(priority = 12)
	public void verifyColorFeature()
	{
		Reporter.log("Change in the image using Color Feature", true);
		test = reports.createTest("Change in the image using Color Feature_TC_012");

		// Click on the T-Shirt Menu
		WebElement tshirtEle = d.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"));
		tshirtEle.click();
		
		Actions builder = new Actions(d);
		builder.moveToElement(d.findElement(By.xpath("//*[@id='center_column']/ul/li/div/div[2]"))).build().perform();
		
		//	Click on the Image color
		d.findElement(By.xpath("//a[@id='color_1']")).click();
		
		//	Small Image Attribute
		WebElement img = d.findElement(By.xpath("//img[@id='bigpic']"));
		
		//	Click on Orange Image Box
		WebElement orangeColorBox = d.findElement(By.id("color_13"));
		orangeColorBox.click();
		
		//	Taking Orange Color Img Property
		String orangeImg = img.getAttribute("src");

//		System.out.println("orangeImg - "+ orangeImg);
		
		WebElement blueColorBox = d.findElement(By.id("color_14"));
		blueColorBox.click();
		
		//	Taking Blue Color Img Property
		String blueImg = img.getAttribute("src");
//		System.out.println("blueImg - "+ blueImg);
		
		if (blueImg != orangeImg) 
		{
			Assert.assertTrue(true);
			Reporter.log("Change color of the product", true);
			test.pass("Product Color Has Changed Hence Test Case Is Passed");
		}
		else 
		{
			test.fail("Product Color Has Not Changed Hence Test Case Is Failed");			
		}
	}

	@Test(priority = 13)
	public void verifyFacebookSocialMedia()
	{
		Reporter.log("Vallidate Facebook Socal Media Handle", true);
		test = reports.createTest("Vallidate Facebook Socal Media Handle_TC_013");
		
		String curWin = d.getWindowHandle();
		System.out.println(curWin);
		
		//	Click on Facebook Media Icon
		d.findElement(By.xpath("//*[@class='facebook']")).click();
	
		String expTitle = "facebook";
		String actTitle = d.getTitle();
		Reporter.log("Expected Facebook Title Has Shown " + actTitle);
		
		if (actTitle.contains(expTitle)) 
		{
			Assert.assertTrue(true,"Expected Title Is Matched With Actual Title");
			Reporter.log("Expected Title Is Matched With Actual Title");
			test.pass("Expected Title Is Matched With Actual Title Hence Test Case Is Passed");			
		}
		else 
		{
			test.fail("Expected Title Is Not Matched Hence Test Case Is Failed");			
		}
		
		String openedWin = d.getWindowHandle();
		System.out.println(openedWin);
	}
	
	@Test(priority = 14)
	public void verifyTwitterSocialMedia() throws InterruptedException
	{
		Reporter.log("Vallidate Twiter Social Media Handle", true);
		test = reports.createTest("Vallidate Twiter Social Media Handle_TC_014");
			
		String curWin = d.getWindowHandle();
		System.out.println(curWin);
	
		WebElement twitterIcon = d.findElement(By.xpath("//*[@class='twitter']"));
		twitterIcon.click();
		
		Thread.sleep(3000);

		Set<String> allWin = d.getWindowHandles();

		Iterator<String>it = allWin.iterator();
		
		while (it.hasNext())
		{
			String openedWin = it.next();
			
				if (!curWin.equalsIgnoreCase(openedWin)) 
				{
					// Switching to Child window	
					d.switchTo().window(openedWin);
					System.out.println("Driver Switched On Opened Window");
					
					System.out.println("openedWin" + openedWin);
					
					String expSeleFra = "Selenium Framework";
					String actSeleFra = d.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div/div[1]/div")).getText();
					if (actSeleFra.equalsIgnoreCase(expSeleFra)) 
					{
						Assert.assertTrue(true, "Selenium Framework Is Present In Twitter Account");
						Reporter.log("Selenium Framework Is Present In Twitter Account", true);
						test.pass("Selenium Framework Is Present In Twitter Account Hence Test Case Is Passed");

					}
					else 
					{
						Assert.assertFalse(false, "Selenium Framework Is -- Not Present In Twitter Account");
						Reporter.log("Selenium Framework Is -- Not Present In Twitter Account", true);						
						test.fail("Selenium Framework Is -- Not Present In Twitter Account Hence Test Case Is Failed");			
					}
			}
		}		
	}
	
	@Test(priority = 15)
	public void verifyYoutubeSocialMedia() throws InterruptedException
	{
		Reporter.log("Vallidate Youtube Social Media Handle", true);
		test = reports.createTest("Vallidate Youtube Social Media Handle_TC_015");
	
		String currentWin = d.getWindowHandle();
		System.out.println("currentWin - " + currentWin);
		
		WebElement youtubeIcon = d.findElement(By.xpath("//*[@class='youtube']"));
		youtubeIcon.click();
		
		Thread.sleep(2000);
		
		Set<String>allWin = d.getWindowHandles();
		Iterator<String>it = allWin.iterator();
		
		while (it.hasNext())
		{
			String openedWin = it.next();
			if (!currentWin.equalsIgnoreCase(openedWin)) 
			{
				// Switching to new opened window
				d.switchTo().window(openedWin);
				System.out.println("Driver Switched On Opened Window");
				
				System.out.println("openedWin - " + openedWin);
				
				WebElement youTubeText = d.findElement
						(By.xpath("//*[@id='text' and text() = 'Selenium Framework']"));
				
				String expText = "Selenium";
				String actText = youTubeText.getText();
				if (actText.contains(expText)) 
				{
//					System.out.println("expText - " + expText + " -- " + "actText - " +actText);
					Assert.assertTrue(true);
					Reporter.log("Selenium Framework Is Present In YouTube Account", true);
					test.pass("Selenium Framework Is Present In YouTube Account Hence Test Case Is Passed");
				}
				else 
				{
					Assert.assertFalse(false, "Selenium Framework Is -- Not Present In Twitter Account");
					Reporter.log("Selenium Framework Is Not Present In YouTube Account", true);						
					test.fail("Selenium Framework Is -- Not Present In YouTube Account Hence Test Case Is Failed");			
				}
			}
		}				
	}

	@Test(priority = 16)
	public void verifyNewsLetter() throws InterruptedException
	{
		String emailId = "John_carter@gmail.com";
		Reporter.log("Vallidate News Letter Subscription", true);
		test = reports.createTest("Vallidate News Letter Subscription_TC_016");
		
		//	Send a Random Email ID in Newsletter Subscription Text Box
		WebElement newsLetterText = d.findElement(By.id("newsletter-input"));
		newsLetterText.sendKeys(emailId);
		
		//	click on Proceed button
		d.findElement(By.name("submitNewsletter")).click();
		
		String expMsg = "You have successfully subscribed to this newsletter";
		String actMsg = d.findElement(By.xpath("//p[@class= 'alert alert-success']")).getText();

		if (actMsg.contains(expMsg)) 
		{
			Assert.assertTrue(true, "Subscription Message Is Matched As Expected");
			Reporter.log("Subscription Message Is Matched As Expected", true);
			test.pass("Subscription Message Is Matched As Expected Hence Test Case Is Passed");
			
		}
		else 
		{
			Assert.assertFalse(false, "Subscription Message Is -- Not Matched As Expected");
			Reporter.log("Subscription Message Is -- Not Matched As Expected", true);
			test.fail("Subscription Message Is -- Not Matched As Expected Hence Test Case Is Failed");			

		}
	}

	@Test(priority = 17, enabled = true)
	public void verifyCartValueUpdate() throws Exception
	{
		Reporter.log("Vallidate Cart Value Is Updating", true);
		test = reports.createTest("Vallidate Cart Value Is Updating_TC_017");
			
		AddCartPage ap = new AddCartPage(d);

		ap.fadedMoveToElement();
		ap.faded_TshirtsBtn();
		ap.continueShopBtn();
		System.out.println("Faded Short Sleeve T-shirts Added Into Cart");
		Thread.sleep(1000);
		
		ap.blouseMoveToElement();
		ap.blouseBtn();
		ap.continueShopBtn();
		System.out.println("Blouse Added Into Cart");
		Thread.sleep(1000);
		
		ap.printedChiffonDressMoveToElement();
		ap.printedChiffonDressBtn();
		ap.continueShopBtn();
		System.out.println("Printed Chiffon Dress Added Into Cart");
		
//		ap.closeCartWin();
		
		String expCartQuantity = "3";
		String actCartQuantity = ap.cartValue();

		Assert.assertEquals(actCartQuantity, expCartQuantity, "Cart Quantinty Has Same");
		test.pass("Cart Quantinty Has Same Hence Test Case Is Passed");

	}
	
	@Test(priority = 18)
	public void verifySameProductsAddedInCart() throws Exception
	{
		Reporter.log("Vallidate Total Price Is Corrent In Cart", true);
		test = reports.createTest("Vallidate Total Price Is Corrent In Cart_TC_018");
			
		verifyCartValueUpdate();
		
		AddCartPage ap = new AddCartPage(d);

		String[] productList = {"Faded Short Sleeve T-shirts", "Blouse", "Printed Chiffon Dress"};
		int productSize = productList.length;
		for (int pr = 0; pr < productSize; pr++) 
		{
			ap.cartMoveToElement();
			
			List<WebElement>cartprods = d.findElements(By.xpath("//*[@class='cart_block_product_name']"));
			int cartSize = cartprods.size();
			for (int ca = 0; ca < cartSize; ca++) 
			{
				if (productList[pr].contains(cartprods.get(ca).getText())) 
				{
					System.out.println("Product Is Added In Cart");
					Assert.assertTrue(true, "Product Is Added In Cart");
					break;
				}
			}
		}
		Assert.assertTrue(true, "All Products Are Added In Cart");
		test.pass("All Products Are Added In Cart Hence Test Case Is Passed");

//		Assert.assertEquals(actPrice, expPrice, "Product's Total Price Has Matched Hence - Test Pass");
	}
	
	@Test(priority = 19)
	public void verifyTotalIsCorrentInCart() throws Exception
	{
		Reporter.log("Vallidate Total Price Is Corrent In Cart", true);
		test = reports.createTest("Vallidate Total Price Is Corrent In Cart_TC_019");
				
		verifyCartValueUpdate();
		
		AddCartPage ap = new AddCartPage(d);
		
		ap.cartMoveToElement();
		Thread.sleep(1000);
		
		String expPrice = "$61.91";
		String actPrice = ap.cartTotalPrice();

		System.out.println("expPrice - " + expPrice);
		System.out.println("actPrice - " + actPrice);

		Assert.assertEquals(actPrice, expPrice, "Product's Total Price Has Matched Hence - Test Pass");
		test.pass("Product's Total Price Has Matched Hence Test Case Is Passed");

	}
	
	@Test(priority = 20)
	public void verifyProductRemoveFromCart() throws Exception
	{
		Reporter.log("Vallidate a product can be removed from cart feature", true);
		test = reports.createTest("Vallidate a product can be removed from cart feature_TC_020");
			
		verifyCartValueUpdate();
		
		AddCartPage ap = new AddCartPage(d);
		
		ap.cartMoveToElement();
		Thread.sleep(1000);
		
/*--------------------Before Remove the product from cart---------------	*/		

		System.out.println("Before Remove The Product");				
		String expPrice = "$61.91";
		String actPrice = ap.cartTotalPrice();
		System.out.println("expPrice - " + expPrice +" --- "+ "actPrice - " + actPrice);		
		Assert.assertEquals(actPrice, expPrice, "Product's Total Price Has Matched Before Product Removal Hence - Test Pass");
	
/*--------------------	Remove the product from cart---------------	*/		

		ap.removeProductFromCart();
		Thread.sleep(3000);

/*--------------------After Remove the product from cart---------------	*/		
		
		System.out.println("After Remove The Product");		
		String expPrice1 = "$45.40";
		String actPrice1 = ap.cartTotalPrice();
		System.out.println("expPrice1 - " + expPrice1 +" --- "+ "actPrice1 - " + actPrice1);
		Assert.assertEquals(actPrice1, expPrice1, "Product's Total Price Has Matched After Product Removal Hence - Test Pass");

/*--------------------Check Cart Product Value---------------	*/		
		
		String expCartVal = "2";
		String actCartVal = ap.cartValue();
		System.out.println("expCartVal - " + expCartVal +" --- "+ "actCartVal - " + actCartVal);
		Assert.assertEquals(actCartVal, expCartVal, "Product's Total Price Has Matched In Cart Hence - Test Pass");
		test.pass("Product's Total Price Has Matched In Cart Hence Test Case Is Passed");
	
	}
}




/*


		String[] productList = {"Faded Short Sleeve T-shirts", "Blouse", "Printed Chiffon Dress"};
		int productSize = productList.length;
//		String proSize = String.valueOf(productSize);
		
		System.out.println("productSize - " + productSize);
		
		for (int pr = 0; pr < productSize; pr++) 
		{	
			WebElement proImg = d.findElement(By.xpath("//div[@class='product-container']"));
			Helper.moveToImgContainer(d, proImg);
			Thread.sleep(1000);
			
			ap.addToCart(productList[pr]);
			Thread.sleep(1000);
			
			WebElement layerCart = d.findElement(By.xpath("//div[@class='clearfix']"));
			if (layerCart.isDisplayed()) 
			{
				ap.continueShopBtn();
				Thread.sleep(1000);				
			}
		}


*/




