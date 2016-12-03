package day10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
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
		FirefoxProfile fp=new FirefoxProfile();
		
		fp.setPreference("browser.download.dir", "C://Users/karthik/Downloads");
		fp.setPreference("browser.download.folderList", 2);
		fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,application/octet-stream");
		fp.setPreference( "browser.download.manager.showWhenStarting", false );
		fp.setPreference( "pdfjs.disabled", true );
		fp.setPreference("browser.download.manager.alertOnEXEOpen", false);
		
		driver=new FirefoxDriver(fp);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		baseURL = "http://live.guru99.com/index.php/backendlogin";
		driver.get(baseURL);
		
	}

	
  @Test
  public void test10() throws InterruptedException
  {
	 
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
		
		try {
			Thread.sleep(3000);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//Get the downloaded file from the user's home directory
		String filePath = System.getProperty("user.home")+"/Downloads/orders.csv";
		
		//Read downloaded file and display the Heading and all the Order details in the console windows
		File f = new File(filePath);
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			while(line!=null){
				System.out.println(line);
				line = br.readLine();
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
  }
  
  @AfterTest
  public void close()
  {
	  driver.close();
  }
}
