package day3;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test3 {
	
	public static WebDriver driver;
	public static String baseURL;
	public static String experrMsg="* The maximum quantity allowed for purchase is 500.";
	public static String expempCart="You have no items in your shopping cart.";
@BeforeTest	
 public static void setUp()
 {
	driver=new FirefoxDriver();
	baseURL = "http://live.guru99.com/";
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
 }
  @Test
  public void test3() {
	  
	  driver.get(baseURL);
	  driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a")).click();
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input")).sendKeys("1000");
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button")).click();
	  String errorMsg=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[2]/p")).getText();

	  try {
		Assert.assertEquals(experrMsg, errorMsg);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  driver.findElement(By.id("empty_cart_button")).click();
	  String empCart=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div[2]/p[1]")).getText();
	  
	  try {
		Assert.assertEquals(expempCart, empCart);
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
