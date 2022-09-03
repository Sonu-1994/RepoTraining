package day2.browsersetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMObjectIdentifyAssign {

	public static void main(String[] args) {
	 String currentWorkingDir = System.getProperty("user.dir");
		String chromeExePath = currentWorkingDir + ".\\Executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		//ChromeDriver cdriver = new ChromeDriver();
		//Creating an instance of chrome browser and up-casting it to webDriver interface
				
		WebDriver driver = new ChromeDriver();//Generic way
		
		//To enter the URL on open browser
		driver.get("https://opensource-demo.orangehrmlive.com/");
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
	    
		//type username as admin
				WebElement username=driver.findElement(By.id("txtUsername"));
				
				//perform require operation in username field
				username.clear();
				username.sendKeys("Admin");
				//Identify password field
				WebElement pwd = driver.findElement(By.name("txtPassword"));
				//Perform required operation in the password field
				pwd.clear();
				pwd.sendKeys("admin123");
				//Identify login button field
				WebElement submitbut = driver.findElement(By.className("button"));
				//Perform required operation in the button field
				submitbut.click();
				             //OR
				driver.findElement(By.className("button")).click();
				
				// Verify home page
				String homePageUrl= driver.getCurrentUrl();
				System.out.println("Home page Url:" +homePageUrl);
				System.out.println("Home page validation status: " +homePageUrl.contains("dashboard"));
				
				//Verify login page
				System.out.println("Title validation status:" +pageTitle.equals(expectedTitle));
				
				//Verify logout page
				driver.findElement(By.id("welcome")).click();
				driver.findElement(By.linkText("Logout")).click();
				//driver.close();
				
	}

}
/**
 * Once the WebElement is identified you can perform any of the below mentioned operations depending on requirement 
 * Operation: type  ----------> sendKeys();
 * 			 click  ----------> click();
 * 			existing delete---> clear();
 */
