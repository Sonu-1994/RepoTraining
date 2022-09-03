package day2.browsersetup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenericWayToOpenErail {

	public static void main(String[] args) {
		
		
		String currentWorkingDir=System.getProperty("user.dir");
		String erailExePath=currentWorkingDir +".\\Executables\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", erailExePath );
		//ErailDriver edriver = new ChromeDriver();
		//Creating an instance of erail site and up-casting it to webdriver interface
		
		WebDriver driver = new ChromeDriver();//It is runtime polymorphism because webdriver is a interface when child class
											  //inherit the interface then abstract() method override that child class
		//To enter the URL on open browser
		driver.get("https://erail.in/");
		
		//Application title validation 
		String actualTitle=driver.getTitle();
		String expectedTitle="Erail";
		System.out.println("Actual Erail page title :" +actualTitle);
		System.out.println("Expected Erail page title :"  +expectedTitle);
		System.out.println("Erail title validation :" +actualTitle.equals(expectedTitle));
		
		//Validation of URL
		String actualURL=driver.getCurrentUrl();
		String expectedURL="https://erail.in/";
		System.out.println("Actual Erail page URL :" +actualURL);
		System.out.println("Expected Erail page URL :"  +expectedURL);
		System.out.println("Erail URL validation :" +actualURL.contains(expectedURL));
		
		//Page source code
		String sourceCode=driver.getPageSource();
		System.out.println("Page source code content length :" +sourceCode.length());
		
		//Close the current browser
		driver.close();
	}

}
