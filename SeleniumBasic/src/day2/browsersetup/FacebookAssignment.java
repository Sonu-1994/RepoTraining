package day2.browsersetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAssignment {

	public static void main(String[] args) {
		
		String currentWorkingDir = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", "G:\\Acceleration\\Workspace\\SeleniumBasic\\Executables\\chromedriver.exe");

		//ChromeDriver cdriver = new ChromeDriver();
		 //creating an instance of Chrome browser and up-casting it to WebDriver interface
		
		WebDriver driver = new ChromeDriver();
		
		//To enter the URL on open browser
	    driver.get("https://www.facebook.com");
	    
	   String pageTitle = driver.getTitle();
	   String expectedTitle ="Facebook - log in or sign up";
	   System.out.println("Page title :" + pageTitle);
	   System.out.println("Facebook title validation :" +pageTitle.equals(expectedTitle));
	   
	   String pageURL = driver.getCurrentUrl();
	   String expectedURL = "https://www.facebook.com";
	    System.out.println("page URL length :" +pageURL);
		System.out.println("Page URL validation :" +pageURL.contains(expectedURL));
		
	    String pageContent = driver.getPageSource();
	    System.out.println("Page source length:" +pageContent.length());
	    
	    
		//Close the current browser
		driver.close();

	}

}
