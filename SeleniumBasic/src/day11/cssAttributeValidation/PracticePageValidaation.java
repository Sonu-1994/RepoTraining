package day11.cssAttributeValidation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticePageValidaation {

	public static void main(String[] args) {
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
		driver.get("https://www.practicepage.com");
	
		String actualTitle = driver.getTitle();
		String expectedTitle ="Practice Page";
		System.out.println("Actual practicepage home page title is :" +actualTitle);
		System.out.println("Expected practicepage home page title is :" +expectedTitle);
		System.out.println("practicepage title validation status :" +actualTitle.equals(expectedTitle));
		

	}

}
