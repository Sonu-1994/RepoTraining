package day3.assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VtigerWidgets {

	public static void main(String[] args) {
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
		driver.get("https://demo.vtiger.com/vtigercrm/index.php");
		 String actualTitle = driver.getTitle();
			String expectedTitle ="vtiger";
			System.out.println("Actual vtiger home page title is :" +actualTitle);
			System.out.println("Expected vtiger home page title is :" +expectedTitle);
			System.out.println("vtiger title validation status :" +actualTitle.equals(expectedTitle) );

		//click on sign in button
		driver.findElement(By.cssSelector(".buttonBlue")).click();

		//Click on widgets button 
		driver.findElement(By.cssSelector(".addButton")).click();
		//Click on sales Pipeline
		driver.findElement(By.cssSelector("a[data-name='PipelinedAmountPerSalesPerson']")).click();

		//Click on widgets button
		driver.findElement(By.cssSelector(".addButton")).click();
		//Click on lead by status
		driver.findElement(By.cssSelector("a[data-name='LeadsByStatus']")).click();

		//Click on widgets button
		driver.findElement(By.cssSelector(".addButton")).click();
		//Click on tag cloud
		driver.findElement(By.cssSelector("a[data-name='TagCloud']")).click();

		//Delete the selected widgets of sales pipeline
		driver.findElement(By.cssSelector("a[name='dclose']")).click();
		driver.findElement(By.cssSelector(".confirm-box-ok")).click();
		driver.navigate().refresh();
			
		//Delete the selected widgets of lead by status
		driver.findElement(By.cssSelector("a[name='dclose']")).click();
		driver.findElement(By.cssSelector(".confirm-box-ok ")).click();
		driver.navigate().refresh();
		//Delete the selected widgets of tag cloud
		driver.findElement(By.cssSelector("a[name='dclose")).click();
		driver.findElement(By.cssSelector(".confirm-box-ok ")).click();
		
		//Click on user profile
		driver.findElement(By.cssSelector(".userName")).click();
		driver.findElement(By.cssSelector("#menubar_item_right_LBL_SIGN_OUT")).click();
	}
}
