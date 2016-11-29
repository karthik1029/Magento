package day1;

import java.io.File;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
	
	public static WebDriver driver;
	
	public static void setup()
	{
		File fb=new File(Util1.firefox_Path);
		FirefoxBinary ffb= new FirefoxBinary(fb);
		FirefoxProfile ffp=new FirefoxProfile();
		driver=new FirefoxDriver(ffb,ffp);
		driver.manage().timeouts().implicitlyWait(Util1.waitTime,TimeUnit.MILLISECONDS);
		driver.get(Util1.base_URL);
	}

	public static void main(String[] args) throws IOException {
		
		setup();
		String actual_Title="";
		String mobilepg_Actualtitle="";
		actual_Title=driver.getTitle();
		
		if(actual_Title.contentEquals(Util1.expected_Title))
		{
			System.out.println("Homepage setup successful");
		}
		else
		{
			System.out.println("Homepage setup failed");
		}
		
		driver.findElement(By.className("level0 ")).click();
		mobilepg_Actualtitle=driver.getTitle();
		
		if(mobilepg_Actualtitle.contentEquals(Util1.mobilepgexp_Title))
		{
			System.out.println("Directed to Mobile page");
		}
		else
		{
			System.out.println("Mobile page direction failed");
		}
		
		Select sel=new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/select")));
		sel.selectByVisibleText("Name");
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, new File("C:/selenium/sort.png"));
		
		driver.close();
		
		

	}

}
