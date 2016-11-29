package day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test2 {
	public static WebDriver driver;
	public static String baseURL;
	
	@BeforeTest
	public static void setup()
	{
		driver=new FirefoxDriver();
		baseURL = "http://live.guru99.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		
	}
	
	

  @Test
  public static void test2()
  {
	  driver.get(baseURL);
	  driver.findElement(By.linkText("MOBILE")).click();
	  String xperiaPrice=driver.findElement(By.id("product-price-1")).getText();
	  driver.findElement(By.id("product-collection-image-1")).click();
	  String detailPrice=driver.findElement(By.cssSelector("span.price")).getText();
	  try {
		Assert.assertEquals(xperiaPrice, detailPrice);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
  }
  
  @AfterTest
  public void close()
  {
	  driver.quit();
  }
  
}
