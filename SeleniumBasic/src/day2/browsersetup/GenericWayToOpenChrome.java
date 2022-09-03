package day2.browsersetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericWayToOpenChrome {

	public static void main(String[] args) {
		/**
		 * Step1: set the path of required browser executable file using System.setProperty(key, value)
		 * 		path: 
		 * 		1. absolute path --> G:\\Acceleration\\Workspace\\SeleniumBasic\\Executables\\chromedriver.exe
		 * 		2. Relative path --> .\\Executables\\chromedriver.exe
		 * Step2: create an instance of required browser class
		 */
		String currentWorkingDir=System.getProperty("user.dir");
		String chromeExePath=currentWorkingDir+".\\Executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		//ChromeDriver cdriver=new ChromeDriver(); //or
		//creating an instance of Chrome browser and up-casting it to WebDriver interface
         WebDriver driver = new ChromeDriver();
         
         //to enter the url on the open browser
         driver.get("https://www.google.com");
         
         //Application title validation
         String actualTitle=driver.getTitle();
         String expectedTitle="Google";
         System.out.println("Actual Google page title :" +actualTitle);
         System.out.println("Expected Google page Title :" +expectedTitle );
         System.out.println("Google title validation :" +actualTitle.equals(expectedTitle));
         
         //Validation of URL
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "https://www.google.com";
        System.out.println("Actual Google page URL :" +actualUrl);
        System.out.println("Expected Google page URL :" +expectedUrl );
        System.out.println("Google URL validation :" +actualUrl.contains(expectedUrl));
        
        //Page source code
        String pageSource=driver.getPageSource();
        System.out.println("Page source code content length :" +pageSource.length());
        
        //close the current browser
        driver.close();
        }
	}
