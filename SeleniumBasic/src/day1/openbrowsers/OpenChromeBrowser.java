package day1.openbrowsers;

import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {

	public static void main(String[] args) {
		/* Step 1: Set the path of required browser executable file using System.setProperty(key ,value);
		 * Step 2: Create an instance of required browser class
		 */
		System.setProperty("webdriver.chrome.driver", "G:\\Acceleration\\Workspace\\SeleniumBasic\\Executables\\chromedriver.exe");

		ChromeDriver cdriver = new ChromeDriver();

		cdriver.get("https://www.google.com");
		
		cdriver.close();
	}

}
