package day4.cssassisgnments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GsmArenaNavigatePage {

	public static void main(String[] args) throws InterruptedException {
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
		 //To enter the  URL on open browser
		 driver.get("https://www.gsmarena.com/");
		 //Validate home page
		 String actualTitle = driver.getTitle();
		String expectedTitle ="GSMArena.com - mobile phone reviews, news, specifications and more... ";
		System.out.println("Actual gsmarena home page title is :" +actualTitle);
		System.out.println("Expected gsmarena home page title is :" +expectedTitle);
		System.out.println("gsmarena title validation status :" +actualTitle.contains(expectedTitle) );
		//Identify the element from the web page & return webElement by using cssSelector
		 // By is a predefined class which has several static method
		 driver.findElement(By.cssSelector("a[href=\"samsung-phones-9.php\"]")).click();
		 //Pagination of 1st page of samsung and print samsung phone option and URL
		WebElement paginationPage = driver.findElement(By.cssSelector("a[href=\"samsung-phones-f-9-0-p3.php\"]"));
	
		System.out.println("pagination or not?" +paginationPage.isDisplayed());
		 System.out.println("Current URL is 1st page of samsung :" +driver.getCurrentUrl());
		 List<WebElement> samsungPhoneOptions = driver.findElements(By.cssSelector("#review-body>div>ul>li>a>strong>span"));
		 for(WebElement element :samsungPhoneOptions ) {
			 System.out.println("Menu name is:"+element.getText());
		 }
		 //Pagination of 2nd page of samsung and print samsung phone option and URL
		 driver.findElement(By.cssSelector("div.nav-pages strong")).click();
		 System.out.println("pagination or not?" +paginationPage.isDisplayed());
		 System.out.println("Current URL is 2nd page of samsung :" +driver.getCurrentUrl());
		 Thread.sleep(2000);
		//Pagination of 3rd page of samsung and print samsung phone option and URL
		 driver.findElement(By.cssSelector(".nav-pages strong")).click();
		 System.out.println("pagination or not?" +paginationPage.isDisplayed());
		 System.out.println("Current URL is 3rd page of samsung :" +driver.getCurrentUrl());
		 Thread.sleep(2500);
		 //Pagination is
		 System.out.println("Pagination is :");
		 driver.findElement(By.cssSelector(".col-1-5>a.pages-prev")).click();
		 System.out.println("Pagination of previous of samsung:" +driver.getCurrentUrl());
		 driver.close();
	}
    }
