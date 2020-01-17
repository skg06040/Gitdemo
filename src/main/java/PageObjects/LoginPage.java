package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	 
	 private By email_bar=By.id("user_email");
	 private By pass_bar=By.id("user_password");
	 private By go_button=By.name("commit");
	 private By Login_page_val=By.xpath("//*[text()='Email Address']");
	 public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		 
		 this.driver=driver;
	}

	
	public WebElement getEmailElem()
	 {
		 return driver.findElement(email_bar);
	 }
	 
	public WebElement getPasswordElem()
	 {
		 return driver.findElement(pass_bar);
	 }
	 
	public WebElement getGoElem()
	 {
		 return driver.findElement(go_button);
	 }
	 
	public WebElement getvalMsgLogin() {
		// TODO Auto-generated method stub
		return driver.findElement(Login_page_val);
	}
		
	}

	
	

