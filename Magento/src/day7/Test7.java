package day7;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test7 {
	
	public static WebDriver driver;
	public static String baseURL;
	
	@BeforeTest
	public static void setUp()
	{
		driver=new FirefoxDriver();
		baseURL = "http://live.guru99.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
  @Test
  public void test7() throws InterruptedException 
  {
	  driver.get(baseURL);
	  //click my account
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  Thread.sleep(1000);
	   //login 
	  driver.findElement(By.id("email")).sendKeys("kc33@kc.com");
	  driver.findElement(By.id("pass")).sendKeys("123456");
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[2]/button")).click();
	   //click on my orders
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a")).click();
	   // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) { 
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	    //click on view order
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/table/tbody/tr/td[6]/span/a[1]")).click();
	    Thread.sleep(2000);
	    //verify order is pending
	    String ordPendingexp="ORDER #100003046 - PENDING";
	    String ordPending=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/h1")).getText();
	    System.out.println(ordPending);
	    try {
			Assert.assertEquals(ordPendingexp, ordPending);
		} catch (Exception e) {
			System.out.println("Status of the order is not displayed");
			e.printStackTrace();
		}
	    //click print order
	    driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.sales-order-view.customer-account div.wrapper div.page div.main-container.col2-left-layout div.main div.col-main div.my-account div.page-title.title-buttons a.link-print")).click();
	    Thread.sleep(2000);
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) { 
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000);
	    //check whether a pdf file is created
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) { 
	    	driver.switchTo().window(handle).close();
	    	}  	  
  }
  
  @AfterTest
  public void close()
  {
	  driver.quit();
  }
}
