package day3.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMWaits {

	public static void main(String[] args) {
		String currentWorkingDir = System.getProperty("user.dir");
		String chromeExePath = currentWorkingDir + ".\\Executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		//ChromeDriver cdriver = new ChromeDriver();
		//Creating an instance of chrome browser and up-casting it to webDriver interface
				
		WebDriver driver = new ChromeDriver();//Generic way
		
		//To enter the URL on open browser
		driver.get("https://opensource-demo.orangehrmlive.com/");
		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String pageTitle = driver.getTitle();
		String expectedTitle = "OrangeHRM";
	    System.out.println("page title :" +pageTitle);
		System.out.println("page title length :" +pageTitle.length());
		System.out.println("Page title validation :" +pageTitle.equals("OrangeHRM"));
		
	    String pageURL = driver.getCurrentUrl();
	    System.out.println("page URL length :" +pageURL);
		System.out.println("Page URL validation :" +pageURL.contains("https://opensource-demo.orangehrmlive.com/"));
		
	    String pageContent = driver.getPageSource();
	    System.out.println("Page source length:" +pageContent.length());
	    //Identify username field
	    WebElement userNameInputField = driver.findElement(By.id("txtUsername"));
	    System.out.println("User name is display or not? " +userNameInputField.isDisplayed());
	    System.out.println("User name is functional  or not? " +userNameInputField.isEnabled());
	    
	    //Identify password field
	    WebElement passwordInputField = driver.findElement(By.id("txtPassword"));
	   System.out.println("Password field is display or not? " +passwordInputField.isDisplayed()); 
	   System.out.println("Password field is enable or not? " +passwordInputField.isEnabled()); 
	   
	   //Verify login button
	   WebElement loginButton = driver.findElement(By.id("btnLogin"));
	   System.out.println("Login button is display or not? " +loginButton.isDisplayed()); 
	   System.out.println("Login button is enable or not? " +loginButton.isEnabled()); 
	   System.out.println("Login button is select or not? " +loginButton.isSelected()); 
	   
	   //Verify check box
	   //WebElement checkBoxField = driver.findElement(By.id("btnLogin"));
	  // System.out.println("Login button is display or not? " +checkBoxField.isDisplayed()); 
	   //System.out.println("Login button is enable or not? " +checkBoxField.isEnabled()); 
	   //System.out.println("Login button is select or not? " +checkBoxField.isSelected()); 
	   driver.close();
	   
	}

	
}
