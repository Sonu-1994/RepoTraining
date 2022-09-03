package day4.cssassisgnments;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cricinfoAssign {

	public static void main(String[] args) {
		String chromeExePath = System.getProperty("user.dir") + "\\Executables\\chromedriver.exe";
		// setting the path for driver executable
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		// creating an instance of ChromeBrowser and up-casting it to WebDriver
		// interface
		WebDriver driver = new ChromeDriver();
		// maximize browser window
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// to enter required application URL use get() of WebDriver interface
		driver.get("https://www.cricinfo.com");
		//Validate home page
		String actualTitle = driver.getTitle();
		String expectedTitle = "Live cricket scores, match schedules, latest cricket news, cricket videos";
		System.out.println("Actual cricinfo home page title is :" +actualTitle);
		System.out.println("Expected cricinfo home page title is :" +expectedTitle);
		System.out.println("cricinfo title validation status :" +actualTitle.equals(expectedTitle) );
		// Main menu option count
		List<WebElement> OptionCountAndNames = driver.findElements(By.cssSelector("div.ds-popper-wrapper>a"));
		System.out.println("Count main menu options:" + OptionCountAndNames.size());
		
		// print main menu option name
		for (WebElement element : OptionCountAndNames) {
			System.out.println("Print Menu Name :" +element.getText());
		}
	}

}
