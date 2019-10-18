package MainBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	
	public static  WebDriver driver;
	public static Properties prop;
	
	public Base(){
		
	try {
		FileInputStream fa = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestData\\global.properties");
		
		 prop= new Properties();
		
		prop.load(fa);
		
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
	
	public static  void Installation(){
		
		String browser= prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome")){
			
			
			System.setProperty("webdriver.chrome.driver",prop.getProperty("driverPath"));
			driver= new ChromeDriver();
			
			driver.get(prop.getProperty("url"));
			
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
