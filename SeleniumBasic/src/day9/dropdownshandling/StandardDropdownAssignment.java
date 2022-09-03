package day9.dropdownshandling;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StandardDropdownAssignment {

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

				//uniquely identify the dropdown list
				WebElement yearDropdown = driver.findElement(By.cssSelector("select[id='yearbox']"));
				WebElement dayDropdown = driver.findElement(By.cssSelector("#daybox"));
				//create an instance of select class and pass above dropdown element into its condtructor
				Select selectYear = new Select(yearDropdown);
				Select selectDay = new Select(dayDropdown);
				//Check whether the dropdown is mutlti select dropdown or not
				System.out.println("Is dropdown is allowing you select mutiple options:"+ selectYear.isMultiple());
				System.out.println("Required dropdown is multislect or not? "+ selectDay.isMultiple());
				// Get a default or already selected value
				WebElement defaultoption = selectYear.getFirstSelectedOption();
				String defaultOptionName = defaultoption.getText();
				System.out.println("Already selected option from year dropdown:" +defaultOptionName);
				
				System.out.println("Already selected option from day dropdown :" +selectDay.getFirstSelectedOption().getText());
				//Get counts the options
				List <WebElement> countYear = selectYear.getOptions();
				System.out.println("Count the option in year dropdown :" +countYear.size());
				
				List <WebElement> countday = selectDay.getOptions();
				System.out.println("Count the options in day dropdown :" +countday.size());
				
				//Select options from dropdown
				selectYear.selectByIndex(54);
				System.out.println("Already selected option from day dropdown :" +selectYear.getFirstSelectedOption().getText());
				
				selectDay.selectByVisibleText("19");
				System.out.println("Already selected option from day dropdown :" +selectDay.getFirstSelectedOption().getText());
				
				List originalList = new ArrayList();
				// Get print full dropdown list
				for(int i=1; i<countYear.size(); i++ ) {
					originalList.add(countYear.get(i).getText());
				}
				//Dropdown sort in ascending order
				List temp = new ArrayList(originalList);
				Collections.sort(temp);
				System.out.println("originalList:"+originalList);
				System.out.println("temp2:"+temp);
				System.out.println("Year list are in sorted order or not:" +originalList.equals(temp));
				
				List originalDay = new ArrayList();
				//Get print drpdown list
				for(int i=1; i<countday.size(); i++) {
					originalDay.add(countday.get(i).getText());
				}
				//dropdown sort in ascending order
				List temp2 = new ArrayList(originalDay);
				Collections.sort(temp2);
				System.out.println("originalDay:"+originalDay);
				System.out.println("temp2:"+temp2);
				System.out.println("Year list are in sorted order or not:" +originalDay.equals(temp2));
				
				
				

	}

}
