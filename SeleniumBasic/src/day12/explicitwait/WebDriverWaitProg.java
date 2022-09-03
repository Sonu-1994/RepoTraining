package day12.explicitwait;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitProg {


	public static void main(String[] args) {
	//use setup of WebDriverManager
		WebDriverManager.chromedriver().setup();
		//Create an instance of web driver
		WebDriver driver = new ChromeDriver();
		//To define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//explicit wait(dynamic wait)
		WebDriverWait wait = new WebDriverWait(driver,20);
		//To maximize the screen size of browser 
		driver.manage().window().maximize();
		//To enter required application URL use get() method of webDriver interface
		driver.get("https://demo.actitime.com");
		//Identify and perform required operation
		driver.findElement(By.id("username")).sendKeys("admin");
		//type password as manager
		driver.findElement(By.name("pwd")).sendKeys("manager");
		//click on login button
		driver.findElement(By.id("loginButton")).click();
		//Wait for logout link to be loaded in the page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink")));
		System.out.println("Home page name:" +driver.getTitle());
		
		//Add condition to wait using WebDriverWait instance
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("logoutLink"))));
		
		//Click on logout link
		WebElement logoutLink = driver.findElement(By.id("logoutLink"));
		logoutLink.click();
	
		
	}

}
