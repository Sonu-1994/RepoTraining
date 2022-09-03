package day9.dropdownshandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class CustomDropdown {

	private static Object wait;

	public static void main(String[] args) throws InterruptedException {
		//To get current working directory by using getProperty() i.e.Your Project Name
		String chromeExePath = System.getProperty("user.dir") + "\\Executables\\chromedriver.exe";

		//To set Driver executable path by using setProperty()
		System.setProperty("webdriver.chrome.driver", chromeExePath);

		/*ChromeDriver cdriver = newChromeDriver();//Simple way
				Creating an instance of chromeBrowser and up-casting it to webDriver interface
				It is ex. of runtime Polymorphism And child class override the abstract() method */
		WebDriver driver = new ChromeDriver();//Generic way

		//To maximize the screen size of browser
		driver.manage().window().maximize();

		//Define implicit wait for browser
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

		//To enter required application URL use get() of WebDriver interface
		driver.get("https://thompsonsj.com/bootstrap-select-dropdown");
		//explicit wait(Static wait)
		Thread.sleep(2000);
		//WebDriverWait wait= new webDriverwait(driver,20);
		String actualTitle = driver.getTitle();
		String expectedTitle ="Bootstrap Select Dropdown";
		System.out.println("Actual omayo home page title is :" +actualTitle);
		System.out.println("Expected omayo home page title is :" +expectedTitle);
		System.out.println("omayo title validation status :" +actualTitle.equals(expectedTitle));
		
		WebElement CustomDropdown = driver.findElement(By.cssSelector("button[data-target='#bsd1-container']"));
		// wait.until(ExpectedConditions.elementToBeClickable(CustomDropdown));
		 //Identify dropdown list and click on it
		 CustomDropdown.click();
		 //Identify all the options and store them into List<WebElement>
		 List<WebElement> options = driver.findElements(By.cssSelector(".dropdown-menu.show>div>a"));
		 //use size() to get option count
		 System.out.println("option count:"+options.size());
		 //Use for loop to print one by one options
		 for(int i=0; i<options.size(); i++) {
			 System.out.println(options.get(i).getText() );
			 }
		 options.get(4).click();
	}

}