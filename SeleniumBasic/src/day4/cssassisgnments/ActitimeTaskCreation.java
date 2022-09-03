package day4.cssassisgnments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActitimeTaskCreation {

	public static void main(String[] args) {
		String chromeExePath = System.getProperty("user.dir") + "\\Executables\\chromedriver.exe";
		//Setting the path for driver executable 
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		//ChromeDriver cdriver = new ChromeDriver();//Simple way

		//Creating an instance of actitime site and up-casting it to webdriver interface
		WebDriver driver = new ChromeDriver();//Generic way
		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		// To enter required application URL use get() of webDriver interface
		driver.get("https://demo.actitime.com");

		String actualTitle = driver.getTitle();
		String expectedTitle ="actiTIME - Login";
		System.out.println("Actual actiTIME home page title is :" +actualTitle);
		System.out.println("Expected actiTIME home page title is :" +expectedTitle);
		System.out.println("actiTIME title validation status :" +actualTitle.equals(expectedTitle) );

		WebElement userNameInputField=driver.findElement(By.id("username"));
		userNameInputField.sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		//click on sign in button
		driver.findElement(By.id("loginButton")).click();
		//Create a task 
		driver.findElement(By.id("container_tasks")).click();
		//click on Add New button
		driver.findElement(By.cssSelector("div.addNewButton>div:nth-child(3)")).click();
		//select any one option
		driver.findElement(By.cssSelector(".createNewTasks")).click();
		//click on dropdown 
		driver.findElement(By.cssSelector(".customerSelector div.searchItemList>*:nth-child(5)")).click();
		//select any one option from dropdown
		driver.findElement(By.cssSelector(".projectSelector div.selectedItem")).click();
		//create a one task name
		driver.findElement(By.cssSelector("td.nameCell>input")).sendKeys("Python Developer");
		//click on create button
		driver.findElement(By.cssSelector(".commitButtonPlaceHolder .components_button_label")).click();
	}

}
