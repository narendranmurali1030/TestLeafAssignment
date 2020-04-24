package week4.day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChangeManagementTC001 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);		
		driver.get("https://dev92474.service-now.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.switchTo().frame("gsft_main");
		driver.findElementById("user_name").sendKeys("admin");
		driver.findElementById("user_password").sendKeys("India@123");
		driver.findElementById("sysverb_login").click();
		Thread.sleep(10000);
		
		driver.findElementById("filter").sendKeys("Change");
		driver.findElementById("filter").sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		driver.findElementByXPath("(//div[text()='Create New'])[3]").click();
		
		driver.switchTo().frame("gsft_main");
		driver.findElementByPartialLinkText("Changes without predefined").click();
		
		String incNumber = driver.findElementById("change_request.number").getAttribute("value");
		System.out.println("Incident Number is : "+ incNumber);
//		Thread.sleep(10000);
		
		driver.findElementById("change_request.short_description").sendKeys("TEST NAREN");
		Thread.sleep(5000);
	
		driver.findElementById("sysverb_insert").click();
		Thread.sleep(5000);
		
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(incNumber);
		driver.findElementByXPath("(//input[@class='form-control'])[1]").sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		System.out.println("Retreived Incident Number = " + driver.findElementByXPath("//td[@class='vt']/a").getText());
		
		driver.close();
	}

}
