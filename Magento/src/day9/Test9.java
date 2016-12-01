package day9;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	  //add iphone to cart
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
	  //enter coupon code
	  driver.findElement(By.id("coupon_code")).sendKeys("GURU50");
	  //click apply
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/form/div/div/div/div/button")).click();
	  //check discount generated
	  
	  //grand total
	  String graTot=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")).getText();
	  int graTot1=Integer.parseInt(graTot.replaceAll("$", ""));
	  //grand total after discount
	  String graDisc=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")).getText();
	  int graDisc1=Integer.parseInt(graDisc.replaceAll("$", ""));
	  System.out.println(graDisc1 );
	  System.out.println(graTot1);
	  
  }
  
  @AfterTest
  public void close()
  {
	  driver.close();
  }
}
