package day4.cssassisgnments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GsmArenaPhoneLink {

	public static void main(String[] args) {
		//To set current working directory by using getPrperty i.e.YOUR PROJECT NAME	
		 String currentWorkingDir = System.getProperty("user.dir");
		 String chromeExPath = currentWorkingDir + ".\\Executables\\chromedriver.exe";
		//To set Driver executable path by using setProperty()
		System.setProperty("webdriver.chrome.driver", chromeExPath);
		 //Simple way to create instance
		 // ChromeDriver cdriver = new ChromeDriver();
		 //Creating instance of chromeBrowsr & up-casting it to webDriver interface
		 WebDriver driver = new ChromeDriver();//Generic way 
		 //Implicit wait 
		 driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
		 // maximize browser window
		 driver.manage().window().maximize();
		 //we don't have any minimize method in selenium , so will use setSize()
		 driver.manage().window().setSize(new Dimension(425,500));
		 // maximize browser window
		 driver.manage().window().maximize();
		 //To enter the  URL on open browser
		 driver.get("https://www.gsmarena.com/");
		 //Validate home page 
		 String actualTitle = driver.getTitle();
			String expectedTitle ="GSMArena.com - mobile phone reviews, news, specifications and more...";
			System.out.println("Actual gsmarena home page title is :" +actualTitle);
			System.out.println("Expected gsmarena home page title is :" +expectedTitle);
			System.out.println("gsmarena title validation status :" +actualTitle.equals(expectedTitle) );
		 //Identify the element from the web page & return webElement by using cssSelector
		 // By is a predefined class which has several static method
		 driver.findElement(By.cssSelector("a[href=\"oppo-phones-82.php\"]")).click();
		 List<WebElement> countDeviceWithNames = driver.findElements(By.cssSelector("li>a>strong>span"));
		 System.out.println("Count the devices:"+countDeviceWithNames.size());
		
		 
		 for(int i=0;i<countDeviceWithNames.size();i++) {
			 System.out.println("Mobiles Names: " +countDeviceWithNames.get(i).getText());
		 }

	}

}
