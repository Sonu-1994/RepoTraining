package day12.explicitwait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitProg {

	public static void main(String[] args) {
		//use setup of WebDriverManager
				WebDriverManager.chromedriver().setup();
				//Create an instance of web driver
				WebDriver driver = new ChromeDriver();
				//To define implicit wait for browser
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				//To maximize the screen size of browser 
				driver.manage().window().maximize();
				//To enter required application URL use get() method of webDriver interface
				driver.get("https://demo.actitime.com");
				driver.findElement(By.id("username")).sendKeys("admin");
				//type password as manager
				driver.findElement(By.name("pwd")).sendKeys("manager");
				//click on login button
				driver.findElement(By.id("loginButton")).click();
				
				//fluent wait declaration
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
				
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logoutLink")));
				System.out.println("Home page Title:" +driver.getTitle());
	}

}
