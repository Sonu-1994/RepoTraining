package day6.browseroperation;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMBrowserOperation {

	public static void main(String[] args) {
	//To set executable chrome path by using getProperty()	
	 String currentWorkingDir = System.getProperty("user.dir");
	 String chromeExPath = currentWorkingDir + ".\\Executables\\chromedriver.exe";
	//To set Driver executable path by using setProperty()
	System.setProperty("webdriver.chrome.driver", chromeExPath);
	 //Simple way to create instance
	// ChromeDriver cdriver = new ChromeDriver();
	 //Creating instance of chrome browser & up-casting it to webDriver interface
	 WebDriver driver = new ChromeDriver();//Generic way 
	 //Implicit wait 
	 driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
	 // maximize browser window
	 driver.manage().window().maximize();
	 //we don't have any minimize method in selenium , so will use setSize()
	 driver.manage().window().setSize(new Dimension(425,500));
	 // maximize browser window
	 driver.manage().window().maximize();
	 //To enter the  URL on open browser
	 driver.get("https://opensource-demo.orangehrmlive.com/");
	 //Identify forgot password link 
	 driver.findElement(By.className("orangehrm-login-forgot-header")).click();
	 System.out.println("Forgot your password, page Url:" +driver.getCurrentUrl());
	 //Want to come back to previous page
	 driver.navigate().back();
	 System.out.println("Login page Url: " +driver.getCurrentUrl());
	 //Want to go back next page again 
	 driver.navigate().forward();
	 System.out.println("Forgot your password page Url: " +driver.getCurrentUrl());
	 //Want to refresh/reload current page
	 driver.navigate().refresh();
	 //Want to move other Url page
	 driver.navigate().to("https://www.google.com");
	}

}
