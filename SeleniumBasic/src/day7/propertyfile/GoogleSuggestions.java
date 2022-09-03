package day7.propertyfile;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSuggestions {

	public static void main(String[] args) throws InterruptedException {
		// To get current working directory by using getProperty()
		String chromeExePath = System.getProperty("user.dir")+"\\Executables\\chromedriver.exe";
		// To set driver executable path by using setProperty()
		System.setProperty("webdriver.chrome.driver", chromeExePath);
		// Creating instance an chromeBrowser and up-casting to it webDriver interface
		WebDriver driver = new ChromeDriver();
		// To maximize the browser screen
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// To enter the required URL on open browser use get()
		driver.get("https://www.google.com/");
		
		//Type Selenium Interview Questions
		driver.findElement(By.name("q")).sendKeys("selenium interview questions");
		//Explicit wait
		Thread.sleep(2000);
		//To get all Suggestions
		List<WebElement> sugg = driver.findElements(By.cssSelector("ul.G43f7e>li>div>div:nth-of-type(2)>div:first-child>span"));
		//Suggestion counts
		System.out.println("suggestion counts:"+sugg.size());
		//Print suggestions in the console
		for(int i=0;i<sugg.size();i++) {
			WebElement element=sugg.get(i);
			System.out.println(element.getText());
							//or
			//System.out.println(sugg.get(i).getText());	
		} 
//			  			//OR	
//			 Iterator itr = sugg.iterator();
//			 while(itr.hasNext()) {
//				System.out.println(itr.next()); 
//			 }
			//OR
//		for (WebElement element:sugg) {
//		System.out.println(element.getText());
	}

}
