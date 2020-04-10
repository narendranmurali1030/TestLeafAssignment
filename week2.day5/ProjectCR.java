package week2.day5;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ProjectCR {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);		
		driver.get("http://leafground.com/pages/selectable.html");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();


		//		1) Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");


		//			2) Mouse over on WOMEN (Actions -> moveToElement)
		WebElement eleWomen = driver.findElementByXPath("(//a[text()='Women'])[1]");


		//			3) Click Jackets & Coats
		Actions builder = new Actions(driver);
		builder.moveToElement(eleWomen).perform();
		driver.findElementByXPath("//a[text()='Jackets & Coats']").click();


		//			4) Find the total count of item (top) -> getText -> String
		//			     String str = driver.findElementByClassName("title-count").getText();
		//			     split, 
		//			     String text = str.replaceAll("\\D","") -> String
		//			     Integer.parseInt(text) -> int
		int varTotal = Integer.parseInt(driver.findElementByClassName("title-count").getText().replaceAll("\\D", ""));


		//			5) Validate the sum of categories count matches
		int varJacket = Integer.parseInt(driver.findElementByXPath("//ul[@class='categories-list']/li[1]//span").getText().replaceAll("\\D", ""));
		int varCoats = Integer.parseInt(driver.findElementByXPath("//ul[@class='categories-list']/li[2]//span").getText().replaceAll("\\D", ""));

		if (varTotal == (varJacket+varCoats)) {
			System.out.println("Total Count = " + varTotal);
			System.out.println("Total Coats = "+ varCoats);
			System.out.println("Total Jackets = "+ varJacket);
			System.out.println("Total = " + varTotal);

		}

		//			6) Check Coats
		driver.findElementByXPath("//ul[@class='categories-list']/li[1]/label/div").click();

		//			7) Click + More option under BRAND    
		driver.findElementByXPath("(//section//div[contains(@class,'brand')])[last()]").click();


		//			8) Type MANGO and click checkbox
		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("Mango");
		driver.findElementByXPath("//ul[@class='FilterDirectory-list']/li[2]").click();

		Thread.sleep(3000);

		//			9) Close the pop-up x
		driver.findElementByXPath("//span[contains(@class,'close sprites')]").click();
		
		Thread.sleep(3000);


		//			10) Confirm all the Coats are of brand MANGO
		//			    findElements (brand) -> List<WebElement> 
		//			    foreach -> getText of each brand 
		//			    compare > if(condition)
		List<WebElement> listElements = driver.findElementsByClassName("product-brand");
		for (WebElement each : listElements) {
			if(!(each.getText()).contains("MANGO")) {
				System.out.println(each.getText());
				System.out.println("Its Mango");
			}


			//			11) Sort by Better Discount
			WebElement eleSortyBy = driver.findElementByClassName("sort-sortBy");
			builder.moveToElement(eleSortyBy).perform();
			driver.findElementByXPath("//ul[@class='sort-list']/li[3]/label").click();



			//			12) Find the price of first displayed item
			//			     findElements (price) -> List<WebElement> 
			//			     get(0) -> WebElement -> getText -> String -> int
			List<WebElement> eleBestDiscount = driver.findElementsByXPath("//span[@class='product-discountedPrice']");
			System.out.println("The Best Discounted Prices is : " + Integer.parseInt(eleBestDiscount.get(0).getText().replaceAll("\\D", "")));

			Thread.sleep(5000);

			//			13) Mouse over on size of the first item
			WebElement eleObj = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]");
			WebElement eleSize = driver.findElementByXPath("(//span[contains(@class,'product-size')])[1]");
			builder.moveToElement(eleObj).moveToElement(eleSize).perform();


			//			14) Click on WishList
			driver.findElementByXPath("(//span[contains(@class,'wishlist')])[1]").click();


		}
	}

}
