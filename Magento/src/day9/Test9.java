package day9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test9 {
	
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
  public void test9() 
  {
	  driver.get(baseURL);
	  //click on mobile
	  driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a")).click();
	  //sort by name
	  Select sel=new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
	  sel.selectByVisibleText("Name");
	  //add iphone to cart
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
	  //grand total
	  String graTot=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")).getText();
	  float graTot1=Float.parseFloat(graTot.replace("$", ""));
	  //enter coupon code
	  driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
	  //click apply
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div/div/button")).click();
	  //check discount generated
	  
	  
	  //grand total after discount
	  String graDisc=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")).getText();
	  float graDisc1=Float.parseFloat(graDisc.replace("$", ""));
	  
	  //discount(5%)
	  String disc=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[2]/td[2]/span")).getText();
	  float disc1=Float.parseFloat(disc.replace("-$", ""));
	  

	  System.out.println(graTot1);
	  System.out.println(graDisc1 );
	  
	  float disc2=graTot1-graDisc1;
	  
	  try {
		Assert.assertEquals(disc1, disc2);
		System.out.println("Discount generated");
	} catch (Exception e) {
		System.out.println("Discount not generated");
		e.printStackTrace();
	}
	  
	 
	  
  }
  
  @AfterTest
  public void close()
  {
	  driver.close();
  }
}
