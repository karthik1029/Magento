package day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test10 {
	
	public static WebDriver driver;
	public static String baseURL;
	
	@BeforeTest
	public static void setUp()
	{
		driver=new FirefoxDriver();
		baseURL = "http://live.guru99.com/index.php/backendlogin";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
	}

	
  @Test
  public void test10() throws InterruptedException
  {
	  driver.get(baseURL);
	  //enter username
	  driver.findElement(By.id("username")).sendKeys("user01");
	  //enter password
	  driver.findElement(By.id("login")).sendKeys("guru99com");
	  //click login
	  driver.findElement(By.xpath("/html/body/div/div/form/div/div[5]/input")).click();
	  Thread.sleep(3000);    
	    
	    
	    // switching to new window                                                                                
	    for (String handle : driver.getWindowHandles()) { 
	    	driver.switchTo().window(handle);
	    	}  
	    
	    //handle pop up
	    //driver.switchTo().alert().dismiss();
	    driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[1]/a/span")).click();
	    //click on sales
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/a/span")).click();
	    //click on orders
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/ul/li[1]/a/span")).click();
	    //select CSV in dropdown list and click export
	    Select sel=new Select(driver.findElement(By.id("sales_order_grid_export")));
		sel.selectByVisibleText("CSV");
		
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[3]/div/table/tbody/tr/td[2]/button")).click();
		
		//save the CSV file
		
  }
  
  @AfterTest
  public void close()
  {
	  driver.close();
  }
}
