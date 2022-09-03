package day8.webdrivermanagersetup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webDriverManagerSetupForChrome {

	public static void main(String[] args) {
		//String chromeExePath = System.getProperty("user.dir") + "\\Executables\\chromedriver.exe";
		//Step 1: Set driver executable path by using System.setPrperty(String key, SString value)
		//System.setProperty("webdriver.chrome.driver", chromeExePath);
		//OR USE
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
		driver.get("https://demo.automationtesting.in/Register.html");
	}
}
