package day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test5 {
	
	
	public static WebDriver driver;
	public static String baseURL;
	public static String firstName="KC6";
	public static String lastName="CHAN6";
	
	@BeforeTest
	public static void setUp()
	{
		driver=new FirefoxDriver();
		baseURL = "http://live.guru99.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
  @Test
  public void test5() throws InterruptedException 
  {
	  driver.get(baseURL);
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  Thread.sleep(1000);
	  
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[1]/div[2]/a")).click();
	  Thread.sleep(1000);
	  
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[1]/div/input")).clear();
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[1]/ul/li[1]/div/div[1]/div/input")).sendKeys(firstName);
	  driver.findElement(By.id("lastname")).clear();
	  driver.findElement(By.id("lastname")).sendKeys(lastName);
	  driver.findElement(By.id("email_address")).clear();
	  driver.findElement(By.id("email_address")).sendKeys("kc33@kc.com");
	  driver.findElement(By.id("password")).sendKeys("123456");
	  driver.findElement(By.id("confirmation")).sendKeys("123456");
	  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div[2]/button")).click();
	  
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  String vWelcome = ("WELCOME, " + firstName + " " + lastName + "!");
	  String uWelcome=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/p")).getText();
	  
	  try {
		Assert.assertEquals(vWelcome,uWelcome);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[2]/a")).click();
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[2]/ul/li[1]/a")).click();
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/div/button[1]")).click();
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.findElement(By.id("email_address")).sendKeys("kc@kc.com");
	  
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/form/div[2]/button")).click();
	  
	  String wishList="Your Wishlist has been shared.";
	  String vwishList=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
	  
	  try {
		Assert.assertEquals(wishList,vwishList);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
  }
  
  @AfterTest
  public static void close()
  {
	  driver.close();
  }
}
