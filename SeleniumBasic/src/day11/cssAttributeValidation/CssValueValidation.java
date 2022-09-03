package day11.cssAttributeValidation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CssValueValidation {

	public static void main(String[] args) {
		/**
		 * Open a browser and enter vtiger application URL 
		 * validate in login page Signin
		 * 			button is displayed in Green color(code) 
		 * 			Signin text size is 16px 
		 * 			Signin text in white color(code) 
		 * 			Forgot Password ? is displayed in Blue color(code)
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
				driver.get("https://demo.vtiger.com/vtigercrm/index.php");
				WebElement signInButton = driver.findElement(By.cssSelector("button[type='submit']"));
				
				System.out.println("Font color:"+signInButton.getCssValue("color"));
				System.out.println("Font size :"+signInButton.getCssValue("font-size"));
				System.out.println("Background color:"+signInButton.getCssValue("background-image"));
				
				WebElement forgotPasswordLink = driver.findElement(By.cssSelector(".forgotPasswordLink"));
				System.out.println("Forgot Password Link:"+forgotPasswordLink.getCssValue("color"));
	}

}
