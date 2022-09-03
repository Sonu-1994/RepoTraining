package day3.assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GsmArenaPhoneCount {

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
		driver.get("https://www.gsmarena.com/");
		//Validate home page 
		String actualTitle = driver.getTitle();
		String expectedTitle ="GSMArena.com - mobile phone reviews, news, specifications and more...";
		System.out.println("Actual gsmarena home page title is :" +actualTitle);
		System.out.println("Expected gsmarena home page title is :" +expectedTitle);
		System.out.println("gsmarena title validation status :" +actualTitle.equals(expectedTitle) );
		

		List<WebElement> deviceName = driver.findElements(By.cssSelector("div#tbodyid h4>a"));
		List<WebElement> devicePrice = driver.findElements(By.cssSelector("div#tbodyid h5"));

		for (int i=0;i<deviceName.size();i++) {
			System.out.println(deviceName.get(i).getText()+":"+devicePrice.get(i).getText());
		}

	}
}




