package day5.seleniumwaits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActiTimeWaitAssign {

	public static void main(String[] args) {
		String currentWorkingDir = System.getProperty("user.dir");
		String chromeExePath = currentWorkingDir + ".\\Executables\\chromedriver.exe";
		//Setting the path for driver executable 
				System.setProperty("webdriver.chrome.driver", chromeExePath);
				//ChromeDriver cdriver = new ChromeDriver();//Simple way
				
				//Creating an instance of erail site and up-casting it to webdriver interface
						
				WebDriver driver = new ChromeDriver();//Generic way
				driver.get("https://demo.actitime.com");
		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//To get title from the application use getTitle() of webDriver interface
				String pageTitle = driver.getTitle();
				String expectedTitle = "actiTIME - Login";
				System.out.println("Page title :" +pageTitle);
				System.out.println("Page title length:" +pageTitle.length());
				//Validating login page
				System.out.println("Page title validation status :" +pageTitle.equals(expectedTitle));
				//Application URL validation
				String pageURL = driver.getCurrentUrl();
				String expectedURL = "https://demo.actitime.com/login.do";
				System.out.println("Page URL :" +pageURL);
				//Validating login page
				System.out.println("PageURL validation status:" +pageURL.contains(expectedURL));
						
				//Page source code
				String pageContent = driver.getPageSource();
				System.out.println("Page source code:" +pageContent.length());
				
				//Identify user name Field
				WebElement userNameInputField = driver.findElement(By.id("username"));
				System.out.println("User name is display or not? " +userNameInputField.isDisplayed());
				System.out.println("User name is enable or not? " +userNameInputField.isEnabled());
				
				//Identify Default text for username field
				String defaultTextInUserNameInputField = userNameInputField.getAttribute("placeholder");
				System.out.println("Default text name input  field:" +defaultTextInUserNameInputField);
				System.out.println("Default text validation for user name iinput field:"+defaultTextInUserNameInputField.equals("Username"));
				
				//Identify Password field
				WebElement passwordInputField = driver.findElement(By.className("pwdfield"));
				System.out.println("Password name is display or not? " +passwordInputField.isDisplayed());
				System.out.println("Password name is enable or not? " +passwordInputField.isEnabled());
				
				//Identify Default text for password field
				String defaultTextInPasswordInputField = passwordInputField.getAttribute("placeholder");
				System.out.println("Default password input  field:" +defaultTextInPasswordInputField);
				System.out.println("Default text validation for password input field:"+defaultTextInPasswordInputField.equals("Password"));
				
				
				//Identify login button
				WebElement loginButton = driver.findElement(By.id("loginButton"));
				System.out.println("Login Button is display or not? " +loginButton.isDisplayed());
				System.out.println("Login Button is enable or not? " +loginButton.isEnabled());
				System.out.println("Login Button is selected or not? " +loginButton.isSelected());
				
				//Identify Check Box
				WebElement keepMeLoggedInCheckBox = driver.findElement(By.id("keepLoggedInLabel"));
				System.out.println("Check box is display or not? " +keepMeLoggedInCheckBox.isDisplayed());
				System.out.println("Check box is enable or not? " +keepMeLoggedInCheckBox.isEnabled());
				System.out.println("Check box is enable or not? " +keepMeLoggedInCheckBox.isEnabled());
				String checkBoxTextName = keepMeLoggedInCheckBox.getText();
				System.out.println("Check box Name:" +checkBoxTextName);
				driver.close();
				
	}

}
