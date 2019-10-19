package Test;

import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.Base;
import Pages.Homepage;
import Pages.mainPage;
import junit.framework.Assert;

public class MainPageTest extends Base {

	Homepage hp;
	mainPage mp;
	
	
	public MainPageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp(){
		
		Installation();
		hp= new Homepage();
		mp= hp.validateUserIsOnMain();
		
	}
	
	
	@Test
	public void verifyMainPageOptions(){
		
	List<String> mainOptions= mp.OptionsList();
	
	boolean b= mainOptions.contains("WebTable");
	
	Assert.assertTrue(b);
	}
	
	
	@Test
	public void verifyAddDetailsInRegisterPage() throws InterruptedException{
		mp.addDetailsInRegisterPage();
		
		
	}
	
	@AfterMethod
	public void TearDown(){
		
		driver.close();
		
	}
	
	
	
	
	
	
	
	
	
	
}
