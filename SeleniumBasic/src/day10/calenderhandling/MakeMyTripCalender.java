package day10.calenderhandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripCalender {

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
				driver.get("https://www.makemytrip.com/");
				driver.findElement(By.cssSelector("body")).click();
				//close login popoup
			//	driver.findElement(By.cssSelector("li[data-cy='account']")).click();
				
				//Identify departure date and  click on it
				driver.findElement(By.cssSelector("label[for='departure']")).click();
				//select any date from next month
				driver.findElement(By.cssSelector("")).click();

	}

}
