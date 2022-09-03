package day2.browsersetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActitimeAssignment {

	public static void main(String[] args) {
		
		String currentWorkingDir=System.getProperty("user.dir");
		String chromeExePath = currentWorkingDir + ".\\Executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		//ChromeDriver cdriver=new ChromeDriver(); //or
	    //creating an instance of Chrome browser and up-casting it to WebDriver interface
		
		WebDriver driver = new ChromeDriver();
		
		//To enter the Url on open browser
		driver.get("https://demo.actitime.com");
		
		//Application Title validation
		String pageTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		System.out.println("Actual actitime page title :" +pageTitle);
		System.out.println(" actitime page title :" +pageTitle.length());
		System.out.println("Actitime title validation :" +pageTitle.equals(expectedTitle));
		
		//Validation of URL
		String pageURL = driver.getCurrentUrl();
		String expectedURL = "https://demo.actitime.com";
		System.out.println("Actual actitime page URL :" +pageURL);
		System.out.println("Actitime URL validation :" +pageURL.contains(expectedURL));
		
		//Page source code
		String sourceCode = driver.getPageSource();
		System.out.println("Page source code content length :" +sourceCode.length());
		
		//Close the current browser
		driver.close();
		
	}

}
