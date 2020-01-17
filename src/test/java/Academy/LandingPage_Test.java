package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;


public class LandingPage_Test extends Base{
	
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=GetDriverinfo();
		driver.get(prop.getProperty("url_home"));
		log.info("home page url hit done");
		
	}
	
	
	@Test
	public void Navigate_Home() throws IOException, InterruptedException
	{
		
		lp=new LandingPage(driver);

		//checking popup and if present-close it
		if(lp.getPopupElem().isDisplayed())
		{
			lp.getPopupElem().click();
			log.debug("clicked on popup of home page");
		}
		Assert.assertEquals(lp.getValMsg().getText(),"FEATURED COURSES");
		log.info("validation of home page text successful");
	}
	
	@Test
	public void ValidateTitle_Home() throws IOException, InterruptedException
	{
		
		//LandingPage lp=new LandingPage(driver);

		//checking popup and if present-close it
		/*if(lp.getPopupElem().isDisplayed())
		{
			lp.getPopupElem().click();
			log.debug("clicked on popup of home page");
		}
		*/
		Assert.assertEquals(lp.getTitle().getText(),"Learn Hot tools like Selenium, Appium, JMeter, SoapUI,Database Testing and more..");
		log.info("validation of Title text successful");
	}
	

	@AfterTest
	public void Session_Close()
	{
		driver.close();
		log.info("driver closed for home page");
		driver=null;
	}
}
