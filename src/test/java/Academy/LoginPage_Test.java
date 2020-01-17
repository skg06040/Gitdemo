package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;


public class LoginPage_Test extends Base{
	
	public static org.apache.logging.log4j.Logger log=LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void intialize() throws IOException
	{
		driver=GetDriverinfo();
		log.info("driver initialized");
		
	}
	
	@Test(dataProvider="GetData")
	public void Navigate_SignIn(String emailID,String password) throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url_login"));		
		LoginPage lp1=new LoginPage(driver);
		Assert.assertEquals(lp1.getvalMsgLogin().getText(),"Email Address");
		log.info("login page landing successful");
		lp1.getEmailElem().sendKeys(emailID);
		lp1.getPasswordElem().sendKeys(password);
		lp1.getGoElem().click();
		log.debug("clicked on login button");
		
	}
	
	@DataProvider
	public Object[][] GetData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="firstUser@falna.com";
		data[0][1]="firstPasword";
		
		data[1][0]="secondUser@falna.com";
		data[1][1]="secondPassword";
		return data;
	}
	
	
	
	
	@AfterTest
	public void Session_Close()
	{
		driver.close();
		log.info("driver closed for login page successfull");
		driver=null;
	}
	
	
	

}
