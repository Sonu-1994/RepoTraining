package day4.cssassisgnments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookDropdown {

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
		driver.get("https://www.facebook.com/");
		//Validate home page 
		String actualTitle = driver.getTitle();
		String expectedTitle ="facebook";
		System.out.println("Actual facebook home page title is :" +actualTitle);
		System.out.println("Expected facebook home page title is :" +expectedTitle);
		System.out.println("facebook title validation status :" +actualTitle.equals(expectedTitle) );
		//Verify date, month and year field by using CSS Selector
		WebElement dateField = driver.findElement(By.cssSelector(""));
		dateField.sendKeys("date");
		System.out.println("Date is visible or not? " +dateField.isDisplayed());
		System.out.println("Date is enable or not? " +dateField.isEnabled());
		System.out.println("Date is selected or not? " +dateField.isSelected());
	}

}
