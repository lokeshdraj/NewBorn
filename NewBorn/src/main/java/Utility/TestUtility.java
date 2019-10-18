package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainBase.Base;

public class TestUtility extends Base {

	
	public static void waiting(WebElement element){
		
		WebDriverWait wait= new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	
	
}
