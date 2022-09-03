package day11.cssAttributeValidation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PositionValidation {

	public static void main(String[] args) {
		/**
		 * Open a browser and enter actitime application URL 
		 * click on login button with entering username and password
		 * validate in error msg "Username or Password is invalid. Please try again." is displayed in red color
		 * above the username field
		 */
		//WebDriverManager to manager chrome browser executable based on system requirement
		//Use setup method of  WebDriverManager
		WebDriverManager.chromedriver().setup();
		//Step 2: Create an instance of chromeBrowser
		WebDriver driver = new ChromeDriver();
		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		//To maximize the screen size of browser
		driver.manage().window().maximize();

		//To enter required application URL use get() of WebDriver interface
		driver.get("https://demo.actitime.com/login.do");
		
	    String actualTitle = driver.getTitle();
	    String expectedTitle = "actiTIME - Login";
		System.out.println("Actual actiTIME home page title is :" +actualTitle);
		System.out.println("Expected actiTIME home page title is :" +expectedTitle);
		System.out.println("actiTIME title validation status :" +actualTitle.equals(expectedTitle));

		//click on sign in button
		driver.findElement(By.id("loginButton")).click();
		WebElement errorMsg=driver.findElement(By.cssSelector("span.errormsg"));
		System.out.println("Error message :" +errorMsg.getText());
		System.out.println("Error message text color:" +errorMsg.getCssValue("color"));
		//position of error msg with point class
		Point locationOfErrorMsg = errorMsg.getLocation();
		int errorMsgX = locationOfErrorMsg.getX();
		int errorMsgY = locationOfErrorMsg.getY();
		System.out.println("Error of X cord:" +errorMsgX);
		System.out.println("Error of Y cord:" +errorMsgX);
		
		WebElement  userNameInputField =driver.findElement(By.cssSelector("input#username"));
		Point locationOfUsername = userNameInputField.getLocation();
		int userNameX = locationOfUsername.getX();
		int userNameY = locationOfUsername.getY();
		System.out.println("Error of X cord:" +locationOfUsername);
		System.out.println("Error of Y cord:" +locationOfUsername);
		
		int pwdY = driver.findElement(By.name("pwd")).getLocation().getY();
		System.out.println("PWDY :" +pwdY);
		
		System.out.println("Is error msg displayed above the username field ?" +(errorMsgY<userNameY));
		
		

	}

}
