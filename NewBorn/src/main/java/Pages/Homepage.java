package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import MainBase.Base;
import Utility.TestUtility;

public class Homepage extends Base {

	TestUtility ta= new TestUtility();
	
	public Homepage(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.LINK_TEXT,using="Register")
	WebElement register;
	
	
	@FindBy(how=How.XPATH,using="//button[@id='btn2']")
	WebElement skipSignin;
	
	
	@FindBy(how=How.XPATH,using="//button[@id='btn1']")
	WebElement signIn;
	
	public  String verifyTitle(){
		
		String title= driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	
	public boolean verifyUserinHome(){
		
		return signIn.isDisplayed()&&skipSignin.isDisplayed();
		
	}
	
	public mainPage validateUserIsOnMain(){
		
		skipSignin.click();
		ta.waiting(register);
		
		return new mainPage();
	}
	
	
	
	
	
	
	
	
}
