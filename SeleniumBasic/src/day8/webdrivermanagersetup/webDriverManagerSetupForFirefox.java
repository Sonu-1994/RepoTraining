package day8.webdrivermanagersetup;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webDriverManagerSetupForFirefox {

	public static void main(String[] args) {
		//String chromeExePath = System.getProperty("user.dir") + "\\Executables\\chromedriver.exe";
		//Step 1: Set driver executable path by using System.setPrperty(String key, SString value)
		//System.setProperty("webdriver.chrome.driver", chromeExePath);
		//OR USE
		//WebDriverManager to manager chrome browser executable based on system requirement
		//Use setup method of  WebDriverManager
		WebDriverManager.firefoxdriver().setup();
		//Step 2: Create an instance of firefoxBrowser
		WebDriver driver = new FirefoxDriver();
		// maximize browser window
		driver.manage().window().maximize();
		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//To enter the  URL on open browse
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.close();
	}
}
