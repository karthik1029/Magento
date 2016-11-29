package day6;


import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test6 {

	
	public static WebDriver driver;
	public static String baseURL;
	

	@BeforeTest
	public static void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:/Users/karthik/Downloads/SeleniumAutomation Project/Selenium/JAR Files/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		baseURL = "http://live.guru99.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}
	
	
  @Test
  public void test6() throws IOException, InterruptedException {
	  
	  driver.get(baseURL);
	  driver.findElement(By.xpath("/html/body/div/div/div[3]/div/div[4]/ul/li[1]/a")).click();
	  //login 
	  driver.findElement(By.id("email")).sendKeys("kc33@kc.com");
	  driver.findElement(By.id("pass")).sendKeys("123456");
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/div/div[2]/div[2]/button")).click();
	  //click my wish-list
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div/div[2]/ul/li[8]/a")).click();
	  //click add to cart
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[1]/form[1]/div/table/tbody/tr/td[5]/div/button")).click();
	  //select country
	  driver.findElement(By.id("country")).sendKeys("United States");
	  //select state
	  driver.findElement(By.id("region_id")).sendKeys("Texas");
	  //type post-code
	  driver.findElement(By.id("postcode")).sendKeys("75023");
	  //click estimate
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form/div/button")).click();
	  //verify shipping cost generated
	  String shCostexp="Flat Rate";
	  String shCost=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dt")).getText();
	  
	  try {
		Assert.assertEquals(shCostexp,shCost);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
//	  String shCostpriexp="";
//	  String shCostpri=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dd/ul/li/label")).getText();
	  
	  //click shipping cost radio button
	  driver.findElement(By.id("s_method_flatrate_flatrate")).click();
	  //click update total
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form[2]/div/button")).click();
	  //verify flat rate included
	  String flatRateexp="$5.00";
	  String flatRate=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[2]/td[2]/span")).getText();
	  
	  try {
		Assert.assertEquals(flatRateexp, flatRate);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  //click proceed to checkout
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button")).click();
	  
	  Thread.sleep(3000);    
	    
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) { 
	    	driver.switchTo().window(handle);
	    	}  
	    Thread.sleep(2000); 
	    
	    //enter billing information
	    driver.findElement(By.id("billing:firstname")).clear();
	    driver.findElement(By.id("billing:firstname")).sendKeys("karthik");
	    
	    driver.findElement(By.id("billing:lastname")).clear();
	    driver.findElement(By.id("billing:lastname")).sendKeys("chandran");
	    
	    driver.findElement(By.id("billing:street1")).clear();
	    driver.findElement(By.id("billing:street1")).sendKeys("1029 west st");
	    
	    driver.findElement(By.id("billing:city")).clear();
	    driver.findElement(By.id("billing:city")).sendKeys("San Marcos");
	    
	    driver.findElement(By.id("billing:country_id")).sendKeys("United States");
	    
	    driver.findElement(By.id("billing:region_id")).sendKeys("Texas");;
	    
	    driver.findElement(By.id("billing:postcode")).clear();
	    driver.findElement(By.id("billing:postcode")).sendKeys("78666");
	    
	    
	    
	    driver.findElement(By.id("billing:telephone")).clear();
	    driver.findElement(By.id("billing:telephone")).sendKeys("5122343456");
	    
	    //click ship to same address
	    driver.findElement(By.id("billing:use_for_shipping_yes")).click();
	    Thread.sleep(2000);
	    
	    //click continue
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")).click();
	    Thread.sleep(2000);
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) { 
	    	driver.switchTo().window(handle);
	    	}  
	    
	    //click continue in shipping method
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")).click();
	    Thread.sleep(2000);
	    
	    //select check/money-order
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/form/div/dl/dt[1]/input")).click();
	    Thread.sleep(2000);
	    
	    //click continue
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")).click();
	    Thread.sleep(3000);
	    
	    //click place order
	    driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button")).click();
	    Thread.sleep(2000);
	    
	    //note order no
	    String oNo=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/p[1]/a")).getText();
	    
	    System.out.println("Order No:"+oNo);

  }
  
  @AfterTest
  public static void close()
  {
	  driver.close();
  }
}
