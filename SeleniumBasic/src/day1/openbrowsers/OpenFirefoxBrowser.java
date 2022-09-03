package day1.openbrowsers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefoxBrowser {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver","G:\\Acceleration\\Workspace\\SeleniumBasic\\Executables\\geckodriver.exe");
		
		FirefoxDriver fdriver = new FirefoxDriver();
		
		fdriver.get("https://www.google.com");

	}

}
