package Pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import MainBase.Base;

public class mainPage extends Base {
	
	
	public mainPage(){
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(how=How.XPATH,using="//ul[@class='nav navbar-nav']/li")
	List<WebElement> topOptions;
	
	
	@FindBy(how=How.XPATH,using="//input[@ng-model='FirstName']")
	WebElement firstName;
	
	@FindBy(how=How.XPATH,using="//input[@ng-model='LastName']")
	WebElement lastName;
	
	@FindBy(how=How.XPATH,using="//textarea[@ng-model='Adress']")
	WebElement address;
	
	@FindBy(how=How.XPATH,using="//input[@ng-model='Phone']")
	WebElement phone;
	
	@FindBy(how=How.XPATH,using="//input[@ng-model='EmailAdress']")
	WebElement email;
	
	@FindBy(how=How.XPATH,using="//label[text()=' Male ']/input")
	WebElement genderMale;
	
	@FindBy(how=How.XPATH,using="//input[@value='Cricket']")
	WebElement hobiesCricket;
	
	@FindBy(how=How.XPATH,using="//label[text()='Languages']//following-sibling::div")
	WebElement language;
	
	@FindBy(how=How.XPATH,using="//label[text()='Languages']//following-sibling::div//ul/li")
	List<WebElement> languageOptions;
	
	
	
	@FindBy(how=How.XPATH,using="//select[@id='Skills']")
	WebElement skills;
	
	@FindBy(how=How.XPATH,using="//select[@id='countries']")
	WebElement country;
	
	
	@FindBy(how=How.XPATH,using="//span[@role='presentation']")
	WebElement searchCountry;
	
	@FindBy(how=How.XPATH,using="//input[@class='select2-search__field']")
	WebElement CountryText;
	
	@FindBy(how=How.XPATH,using="//label[text()='Languages']")
	WebElement lan;
	
	
	
	
	public List<String> OptionsList(){
		
		
		int optionSize= topOptions.size();
		
		List<String> allOptions= new ArrayList<String>();
		
		for(int i=1;i<=optionSize;i++){
			
			String option= driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li["+i+"]")).getText();
			
			allOptions.add(option);
		}
		
		return allOptions;
		
	}
	
	public void addDetailsInRegisterPage() throws InterruptedException{
	
		
		firstName.sendKeys("Raju");
		
		lastName.sendKeys("Konda");
		
		address.sendKeys("DLF Hyderabad");
		
		phone.sendKeys("9700302569");
		email.sendKeys("raju.k@test.com");
		genderMale.click();
		
		hobiesCricket.click();
		
		language.click();
		
		//select language
		
		Thread.sleep(3000);
		
		
		int languageSize= languageOptions.size();
		
		for(int i=1;i<=languageSize;i++){
			
			String lang= driver.findElement(By.xpath("//label[text()='Languages']//following-sibling::div//ul/li["+i+"]")).getText();
			
			if(lang.equalsIgnoreCase("Spanish")){
				
				driver.findElement(By.xpath("//label[text()='Languages']//following-sibling::div//ul/li["+i+"]")).click();
				
				break;
				
			}
			
		}
		
		Thread.sleep(2000);
		
		lan.click();
		
		Thread.sleep(3000);
		
		Select sl = new Select(skills);
		sl.selectByVisibleText("Analytics");
		
		Thread.sleep(3000);
		
		Select sm= new Select(country);
		sm.selectByIndex(5);
		
		Thread.sleep(2000);
		
		searchCountry.click();
		
		// search for country first
		Thread.sleep(2000);
		CountryText.sendKeys("India");
		
		CountryText.sendKeys(Keys.ENTER);
		
		
	}
	
	
	
	
	
	
}
