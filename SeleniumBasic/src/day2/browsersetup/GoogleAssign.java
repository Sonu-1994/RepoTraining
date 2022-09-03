package day2.browsersetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAssign {

	public static void main(String[] args) {
		String currentWorkingDir = System.getProperty("user.home");
		System.setProperty("webdriver.chrome.driver", "G:\\Acceleration\\Workspace\\SeleniumBasic\\Executables\\chromedriver.exe");

		//ChromeDriver cdriver = new ChromeDriver();
		 //creating an instance of Chrome browser and up-casting it to WebDriver interface
		
		WebDriver driver = new ChromeDriver();
		
		//To enter the URL on open browser
	    driver.get("https://www.google.com");
	   
	    //Application title validation
	    String pageTitle = driver.getTitle();
	    System.out.println("page title :" +pageTitle);
		System.out.println("page title length :" +pageTitle.length());
		System.out.println("Page title validation :" +pageTitle.equals("Google"));
		
	    String pageURL = driver.getCurrentUrl();
	    System.out.println("page URL length :" +pageURL);
		System.out.println("Page URL validation :" +pageURL.equals("https://www.google.com/"));
		
	    String pageContent = driver.getPageSource();
	    System.out.println("Page source length:" +pageContent.length());
	    
	    
	    
	    
		//Close the current browser
		driver.close();
		
		
		
		
		

	}

}
