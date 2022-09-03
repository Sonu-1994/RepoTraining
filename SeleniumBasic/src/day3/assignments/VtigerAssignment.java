package day3.assignments;

import java.util.concurrent.TimeUnit;

import javax.rmi.ssl.SslRMIClientSocketFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerAssignment {

	public static void main(String[] args) throws InterruptedException {
		//To get current working directory by using getProperty() i.e.Your Project Name
		String chromeExePath = System.getProperty("user.dir") + "\\Executables\\chromedriver.exe";

		//To set Driver executable path by using setProperty()
		System.setProperty("webdriver.chrome.driver", chromeExePath);

		/*ChromeDriver cdriver = newChromeDriver();//Simple way
		Creating an instance of chromeBrowser and up-casting it to webDriver interface
		It is ex. of runtime Polymorphism And child class override the abstract() method */
		WebDriver driver = new ChromeDriver();//Generic way

		//To maximize the screen size of browser
		driver.manage().window().maximize();

		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		//To enter required application URL use get() of WebDriver interface
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");

		//To get title from the application use getTitle()
		String pageTitle = driver.getTitle();
		System.out.println("Page title :" + pageTitle);
		System.out.println("Page title length :" + pageTitle.length());
		String expectedTitle = "vtiger";
		//validating login page
		System.out.println("Page title validation status:" + pageTitle.equals(expectedTitle));

		//Application URL validation /
		String pageURL = driver.getCurrentUrl();
		System.out.println("Page cureent URL :" +pageURL);
		System.out.println("Page URL validation status:" +pageURL.contains("https://demoo.vtiger.com/vtigercrm/index.php"));

		//Application page source code
		String sourceCode = driver.getPageSource();
		System.out.println("Page source code :" +sourceCode.length());

		//Identify username field by using 6 locators
		WebElement userNameInputField = driver.findElement(By.id("username"));
		userNameInputField.sendKeys("admin");
		//OR
		userNameInputField.clear();
		driver.findElement(By.name("username")).sendKeys("admin");
		System.out.println("User name is display or not? " +userNameInputField.isDisplayed());
		System.out.println("User name is enable or not? " +userNameInputField.isEnabled());

		//Identify default text for userName field
		String defaultTextUserNameField = userNameInputField.getAttribute("Placeholder");
		System.out.println("Default text of user name input field :" +defaultTextUserNameField);
		System.out.println("Default text validation for user name input field status:" +defaultTextUserNameField.equals("Username"));

		//Identify Password field by using 6 locators
		WebElement passwordInputField = driver.findElement(By.id("password"));
		passwordInputField.clear();
		passwordInputField.sendKeys("Test@123");
		System.out.println("Password field is display or not?" +passwordInputField.isDisplayed());
		System.out.println("Password field is enable or not? " +passwordInputField.isEnabled());

		//Identify default text for password field 
		String defaultPasswordField = passwordInputField.getAttribute("Placeholder");
		System.out.println("Default text of password field :" +defaultPasswordField);
		System.out.println("Default text validation for password input field status:" +defaultPasswordField.equals("Password"));

		//Identify sign in button by using  6 locators 
		WebElement signInButton = driver.findElement(By.className("buttonBlue"));
		System.out.println("Sign In button is display or not? " +signInButton.isDisplayed());
		System.out.println("Sign In button is enable or not? " +signInButton.isEnabled());
		System.out.println("Button name is:"+signInButton.getText().equals("Sign in"));
		//System.out.println("Sign In button is selected or not?" +signInButton.isSelected());
		signInButton.click();

		//Verify forgot password link 
		//driver.findElement(By.cssSelector(".forgotPasswordLink")).click();
		//System.out.println("Forgot your password, page URL:" +driver.getCurrentUrl());
		//Explicit wait (Static wait)
		//Thread.sleep(2000);

		//Verify home page 
		String HomePageTitle = driver.getTitle();
		System.out.println("Home page Title:" +HomePageTitle);
		System.out.println("Home page validation status:" +HomePageTitle.equals("Home"));

		//Verify sign out link
		//driver.findElement(By.cssSelector("a#menubar_item_right_LBL_SIGN_OUT")).click();

		//Come back to previous page 
		driver.navigate().back();
		System.out.println("Login page URL:"+driver.getCurrentUrl());
		//Go back next page again
		driver.navigate().forward();
		System.out.println("Forgot your password, page URL:" +driver.getCurrentUrl());
		//Refresh/Reload the page
		driver.navigate().refresh();
		// move to another URL
		driver.navigate().to("https://www.google.com");
	}

}