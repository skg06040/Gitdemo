package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;

public class Landing_Page_Negative extends Base {
	
	
public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=GetDriverinfo();
		driver.get(prop.getProperty("url_home"));
		log.info("home page url hit done for negative");
		
	}
	
	
	@Test
	public void Navigate_Home_negtive() throws IOException, InterruptedException
	{
		
		LandingPage lp=new LandingPage(driver);

		//checking popup and if present-close it
		if(lp.getPopupElem().isDisplayed())
		{
			lp.getPopupElem().click();
			log.debug("clicked on popup of home page");
		}
		
		Assert.assertEquals(lp.getValMsg().getText(),"FEATURED COURSES123");
		 log.info("validation of home page text unsuccessful first time");	
			
	}
	
/*	@Test
	public void Navigate_Home_negtive2() throws IOException, InterruptedException
	{
		
		LandingPage lp=new LandingPage(driver);

		//checking popup and if present-close it
		if(lp.getPopupElem().isDisplayed())
		{
			lp.getPopupElem().click();
			log.debug("clicked on popup of home page");
		}
		
		Assert.assertEquals(lp.getValMsg().getText(),"FEATURED COURSES1234");
		 log.info("validation of home page text unsuccessful twice");	
			
	}
	*/


	@AfterTest
	public void Session_Close()
	{
		driver.close();
		log.info("driver closed for home page");
		driver=null;
	}
}



