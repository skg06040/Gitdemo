package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

public WebDriver driver;
 
 private By log_button=By.xpath("//span[text()='Login']");
 private By pop_up=By.xpath("//*[text()='NO THANKS']");
 private By Landing_page_val=By.xpath("//*[text()='Featured Courses']");
 private By Title=By.cssSelector("div[class*='video-banner'] p");  //$("div[class*='video-banner'] p")

 
 public LandingPage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 
	 this.driver=driver;
}

public WebElement getLoginElem()
 {
	 return driver.findElement(log_button);
 }
 
public WebElement getTitle()
{
	 return driver.findElement(Title);
}

public WebElement getPopupElem()
{
	 return driver.findElement(pop_up);
}

public WebElement getValMsg()
{
	 return driver.findElement(Landing_page_val);
}


	
}
