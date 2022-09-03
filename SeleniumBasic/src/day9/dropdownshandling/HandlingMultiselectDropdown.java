package day9.dropdownshandling;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingMultiselectDropdown {

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
				driver.get("https://omayo.blogspot.com/");
				String actualTitle = driver.getTitle();
				String expectedTitle ="omayo (QAFox.com)";
				System.out.println("Actual omayo home page title is :" +actualTitle);
				System.out.println("Expected omayo home page title is :" +expectedTitle);
				System.out.println("omayo title validation status :" +actualTitle.equals(expectedTitle) );
				//Uniquely identify dropdown list
				WebElement carDropdown = driver.findElement(By.id("multiselect1"));
				//Create an instance of select class and pass above element into its constructor
				Select selectCar = new Select(carDropdown);
				//Check whether dropdown is multiselect dropdown or not
				System.out.println("Is dropdown is allowing you to selet multiple option: " +selectCar.isMultiple());
		
				//get option counts
				List<WebElement> options = selectCar.getOptions();
				System.out.println("option count is :" +options.size());
				//Get dropdown option names
				for (int i=0; i<options.size(); i++) {
					System.out.println("Print option names "+i+" :" +options.get(i).getText());
				}
				//Get select option from dropdown
				selectCar.selectByIndex(0);
				selectCar.selectByIndex(2);
				selectCar.selectByIndex(3);
			//	selectCar.selectByValue("swiftx");
			//	selectCar.selectByVisibleText("Audi");
				//Get all the selected options
				List<WebElement> selectOption = selectCar.getAllSelectedOptions();
				System.out.println("Selected car count:" +selectOption.size());
				//Unselect already select options
//				selectCar.deselectByIndex(0);
//				selectCar.deselectByValue("swiftx");
//				selectCar.deselectByVisibleText("Audi");
//				OR
				selectCar.deselectAll();
	}

}
