package Academy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Base {
	
	public static WebDriver driver;
	public Properties prop=new Properties();
	
	public WebDriver GetDriverinfo() throws IOException
	{
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		prop.load(file);
		//below line of code to get browser value from property file
		//String browser_name=prop.getProperty("browser");
		//below line of code to get browser value using maven system variables
		String browser_name=System.getProperty("browser");
		//System.out.println(browser_name);
		
	   //check the browser parameter from property file & assign accordingly
		if(browser_name.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browser_name.contains("headless"))
			{
				options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
		}
		else if(browser_name.equals("firefox"))
		{
			
		}//some code for setting firefix driver
		else
		{
			//code for IE driver setup
		}
	     
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("C:\\Users\\sumit\\Screens\\"+result+"screenshot.png"));
		FileUtils.copyFile(src,new File("D:\\Screens\\"+result+"_screenshot.png"));
		
		
		
	}
	

	

}
