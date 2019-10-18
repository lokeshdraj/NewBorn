package Test;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.Base;
import Pages.Homepage;
import Pages.mainPage;

public class HomePageTest extends Base {
	
	Homepage hp;
	mainPage mp;

	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void launchApp(){
		
		Installation();
		hp= new Homepage();
	
	}
	
	@Test
	public void verifyHome(){
		
		boolean ab= hp.verifyUserinHome();	
		Assert.assertTrue(ab);
		
	}
	
	@Test
	public void validateTitle(){
		
		String title=prop.getProperty("mainTitle");
		
		Assert.assertEquals(title,hp.verifyTitle());
		
	}
	
	
	
	
	@Test
	public void verifyUserisOnMain(){
		
		mp=hp.validateUserIsOnMain();
		
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.close();
		
	}
	
	
	
	
	
	
	
}
