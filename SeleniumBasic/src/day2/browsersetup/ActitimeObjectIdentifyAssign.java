package day2.browsersetup;

import java.util.concurrent.TimeUnit;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActitimeObjectIdentifyAssign {

	public static void main(String[] args) throws InterruptedException {
		 
		String chromeExePath = System.getProperty("user.dir") + ".\\Executables\\chromedriver.exe";
		//Setting the path for driver executable 
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		//ChromeDriver cdriver = new ChromeDriver();//Simple way
		
		//Creating an instance of erail site and up-casting it to webdriver interface
			
		WebDriver driver = new ChromeDriver();//Generic way
		
		//To enter required application URL use get() of webDriver interface
		driver.get("https://demo.actitime.com");
		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//To get title from the application use getTitle() of webDriver interface
		String pageTitle = driver.getTitle();
		String expectedTitle = "actiTIME - Login";
		System.out.println("Page title :" +pageTitle);
		System.out.println("Page title length:" +pageTitle.length());
		//Validating login page
		System.out.println("Page title validation status :" +pageTitle.equals(expectedTitle));
		//Application URL validation
		String pageURL = driver.getCurrentUrl();
		String expectedURL = "https://demo.actitime.com";
		System.out.println("Page URL :" +pageURL);
		//Validating login page
		System.out.println("PageURL validation status:" +pageURL.contains(expectedURL));
				
		//Page source code
		String pageContent = driver.getPageSource();
		System.out.println("Page source code:" +pageContent.length());
		
		//Identify and perform required operation on username field
	
	   driver.findElement(By.id("username")).sendKeys("admin");

	   //Identify and perform required operation on password field
	   driver.findElement(By.name("pwd")).sendKeys("manager");

		//click on login button and perform operation
	   driver.findElement(By.id("loginButton")).click();
	   
	   //Explicit wait(Static wait)
	   Thread.sleep(2000);
	    
	   //Verify home page 
	   String homepageTitle = driver.getTitle();
	   System.out.println("Home page title:"+homepageTitle);
	   System.out.println("Home page validation status:"+homepageTitle.equals("actiTIME - Enter Time-Track"));
	   
		//click on logout button and perform operation
	   driver.findElement(By.id("logoutLink")).click();
	   //Verify login page
	 //  System.out.println("Title validation Status:" +pageTitle.equals("actiTIME - Enter Time-Track"));
		//Close the browser
	   driver.close();
		}
	}

/**
 * In order to perform any operation on any element first identify it from WebPage, for that use findElement()
 * 
 *WebElement anyelement= findElement(By.locator())----->Use to identify the element from the Web page and return WebElemet
 *				   --->	By ----->Predefined class which has several static method known as locators
 *								--->id(string), name(string), linkText(string), partialLinkText(string)
 * 							className(string), tagName(string), cssSelector(String), xpath(String)
 * Once you identified the element, you can perform the required operation like-
 * 1. type				--> element.sendKeys("");
 * 2. click				--> element.click();
 * 3. delete existing text-> element.clear();
 */
/*
1. Open any browser
2. Enter the url as https://demo.actitime.com/login.do
3. Verify login page
3. Username as admin
4. password as manager
5. click on Login button 
6. verify home page
7. click on logout link
8. verify login page is opened or not
9. close the browser


*/
