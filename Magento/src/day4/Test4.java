package day4;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test4 {
	
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
  public void test4() 
  {
	  driver.get(baseURL);
	  driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/nav/ol/li[1]/a")).click();
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	  String mobile1=driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.catalog-category-view.categorypath-mobile-html.category-mobile div.wrapper div.page div.main-container.col3-layout div.main div.col-wrapper div.col-main div.category-products ul.products-grid.products-grid--max-4-col.first.last.odd li.item.last div.product-info h2.product-name a")).getText();
	  driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	  String mobile2=driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/h2/a")).getText();
	  driver.findElement(By.cssSelector("html#top.js.no-touch.localstorage.no-ios body.catalog-category-view.categorypath-mobile-html.category-mobile div.wrapper div.page div.main-container.col3-layout div.main div.col-right.sidebar div.block.block-list.block-compare div.block-content div.actions button.button")).click();
	  
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  String popMobile1=driver.findElement(By.xpath("/html/body/div/table/tbody[1]/tr[1]/td[1]/h2/a")).getText();
	  String popMobile2=driver.findElement(By.xpath("/html/body/div/table/tbody[1]/tr[1]/td[2]/h2/a")).getText();
	  
	  String head="COMPARE PRODUCTS";
	  String popHead=driver.findElement(By.xpath("/html/body/div/div[1]/h1")).getText();
	  
	  try {
		Assert.assertEquals(head, popHead);
	} catch (Exception e1) {
		e1.printStackTrace();
	}
	  
	  try {
		Assert.assertEquals(mobile1, popMobile1);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  try {
		Assert.assertEquals(mobile2, popMobile2);
	} catch (Exception e) {
		e.printStackTrace();
	}
	  
	  driver.findElement(By.xpath("/html/body/div/div[2]/button")).click();
	  
	  for(String handle:driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	
  }
  
  @AfterTest
  public static void close() throws InterruptedException
  {
	  driver.close();
  }
}
