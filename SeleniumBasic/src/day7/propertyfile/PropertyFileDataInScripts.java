package day7.propertyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFileDataInScripts {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream(".\\PropertyFiles\\TestData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		String driverKey = prop.getProperty("webdriver.chrome.driver");
		String executablePath = prop.getProperty("driverExecutablePath");
		String appUrl = prop.getProperty("applicationURl");
		String usernameField= prop.getProperty("userName");
		String passwordField = prop.getProperty("password");
		String expectedLoginPageTitle = prop.getProperty("loginPageTitle");
		String loginButtonName = prop.getProperty("buttonName");
		String checkBoxField = prop.getProperty("checkBOx");

		System.out.println(executablePath+"\n"+driverKey+"\n"+appUrl+"\n"+usernameField+"\n"+passwordField+"\n"+expectedLoginPageTitle+"\n"+loginButtonName+"\n"+checkBoxField); 

//		// To get current working directory by using getProperty()
//		String chromeExePath = System.getProperty("user.dir")+ executablePath;
//		// To set driver executable path by using setProperty()
//		System.setProperty(driverKey, chromeExePath);
//		// Creating instance an chromeBrowser and up-casting to it webDriver interface
//		WebDriver driver = new ChromeDriver();
//		//To enter required application URL use get() of webDriver interface
//		driver.get(appUrl);
//		//To get title from the application use getTitle() of webDriver interface
//		String pageTitle = driver.getTitle();
//		System.out.println("Page title :" +pageTitle);
//		System.out.println("Page title length:" +pageTitle.length());
//		//Validating login page
//		System.out.println("Page title validation status :" +pageTitle.equals(expectedLoginPageTitle));
//		//Application URL validation
//		String pageURL = driver.getCurrentUrl();
//		System.out.println("Page URL :" +pageURL);
//		//Validating login page
//		System.out.println("PageURL validation status:" +pageURL.contains(appUrl));
//
//		//Page source code
//		String pageContent = driver.getPageSource();
//		System.out.println("Page source code:" +pageContent.length());
//
//		//Identify and perform required operation on username field
//
//		driver.findElement(By.id("username")).sendKeys("usernameField");
//
//		//Identify and perform required operation on password field
//		driver.findElement(By.name("pwd")).sendKeys("passwordField");
//		//click on login button and perform operation
//		driver.findElement(By.id("loginButton")).click();
//
//		driver.findElement(By.id("keepLoggedInLabel"));
//		driver.close();
//
//
	}

}
