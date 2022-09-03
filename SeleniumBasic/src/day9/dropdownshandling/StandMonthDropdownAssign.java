package day9.dropdownshandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StandMonthDropdownAssign {

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
		driver.get("https://demo.automationtesting.in/Register.html");
		String actualTitle = driver.getTitle();
		String expectedTitle ="Register";
		System.out.println("Actual automationtesting home page title is :" +actualTitle);
		System.out.println("Expected automationtesting home page title is :" +expectedTitle);
		System.out.println("automationtesting title validation status :" +actualTitle.equals(expectedTitle) );

		//Uniquely identify the dropdown list
		WebElement monthDropdown =driver.findElement(By.cssSelector("select[placeholder=\"Month\"]"));
		//Create an instance of select class and pass above element in constructor
		Select selectmonth = new Select(monthDropdown);
		//Check whether the dropdown is multiselect dropdown or not
		System.out.println("Required dropdown is multislect or not? " + selectmonth.isMultiple());
		//get default or already select value
		System.out.println("Already selected option name is :" +selectmonth.getFirstSelectedOption().getText());
		//get option count
		List<WebElement> options=selectmonth.getOptions();
		System.out.println("Option count is :" +options.size());
		//OR
	//	System.out.println("Option count is :" +selectmonth.getOptions().size());
		//select option from dropdown
		selectmonth.selectByIndex(3);
		System.out.println("Already selected option name is :" +selectmonth.getFirstSelectedOption().getText());
	//	Checking the order of month
		String selectMon=" ";
	//Print all the option names
		for(int i=1; i<options.size(); i++) {
			selectMon=selectMon+options.get(i).getText()+",";
		}
		//Month s sequence order
		String exp_selectmonth = " January,February,March,April,May,June,July,August,September,October,November,December," ;
		System.out.println("selectMon:" +selectMon);
		System.out.println("exp_selectmonth: " +exp_selectmonth);
		System.out.println("Months are in sorted orderor not? " +selectMon.equals(exp_selectmonth));
		
			
			
	}

}
