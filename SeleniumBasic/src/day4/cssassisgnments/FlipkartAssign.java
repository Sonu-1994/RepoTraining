package day4.cssassisgnments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartAssign {

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
		driver.get("https://www.flipkart.com");
		//Validate home page
		String actualTitle = driver.getTitle();
		String expectedTitle = "Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		System.out.println("Actual flipkart home page title is :" +actualTitle);
		System.out.println("Expected flipkart home page title is :" +expectedTitle);
		System.out.println("flipkart title validation status :" +actualTitle.equals(expectedTitle) );
		
		// Print main menu options counts and Names
		List<WebElement> optionCountWithName = driver.findElements(By.cssSelector("div.xtXmba"));
		System.out.println("Main menu option count:" + optionCountWithName.size());

		for (int i = 0; i < optionCountWithName.size(); i++) {
			WebElement element = optionCountWithName.get(i);
			System.out.println("Print main menu name: " + element.getText());
		}

	}

}
