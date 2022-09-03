package day9.dropdownshandling;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.omg.Messaging.SyncScopeHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StandardDropdownList {

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

		//Uniquely identify dropdown list
		WebElement skillDropdown = driver.findElement(By.cssSelector("#Skills"));
		//Create an instance of select class and pass above element into its constructor
		Select selectSkill = new Select(skillDropdown);
		//Check whether dropdown is multiselect dropdown or not
		System.out.println("Is dropdown is allowing you to selet multiple option: " +selectSkill.isMultiple());
		//get default or alraedy select option
		//			WebElement selectedOption = selectSkill.getFirstSelectedOption();
		//			String selectedOptionName = selectedOption.getText();
		//			System.out.println("Already selected option name : " +selectedOptionName);
		//OR
		System.out.println("Alraedy selected option name : " +selectSkill.getFirstSelectedOption().getText());
		//get option counts
		List<WebElement> options = selectSkill.getOptions();
		System.out.println("option count is :" +options.size());
		//Get dropdown option names
		for (int i=0; i<options.size();i++) {
			System.out.println("Print Dropdown option names "+i+": "+options.get(i).getText());
		}
		//Select options from dropdown
		selectSkill.selectByIndex(5);
		System.out.println("Already selected option names :" +selectSkill.getFirstSelectedOption().getText());
		//OR
//		selectSkill.deselectByValue("Art Design");
//		System.out.println("Already selected option names :" +selectSkill.getFirstSelectedOption().getText());
		//OR
//		selectSkill.deselectByVisibleText("Certifications");
//		System.out.println("Already selected option names :" +selectSkill.getFirstSelectedOption().getText());

		//Checking the order of skills
		String skillName = " ";
		for(int i=1; i<options.size();i++) {
			skillName = skillName+options.get(i).getText()+" , ";
		}
		//Expected skills
		String exp_skillName ="Adobe InDesign , Adobe Photoshop , Analytics , Android , APIs , Art Design , AutoCAD , Backup Management , C , C++ , Certifications , Client Server , Client Support , Configuration , Content Managment , Content Management Systems (CMS) , Corel Draw , Corel Word Perfect , CSS , Data Analytics , Desktop Publishing , Design , Diagnostics , Documentation , End User Support , Email , Engineering , Excel , FileMaker Pro , Fortran , HTML , Implementation , Installation , Internet , iOS , iPhone , Linux , Java , Javascript , Mac , Matlab , Maya , Microsoft Excel , Microsoft Office , Microsoft Outlook , Microsoft Publisher , Microsoft Word , Microsoft Visual , Mobile , MySQL , Networks , Open Source Software , Oracle , Perl , PHP , Presentations , Processing , Programming , PT Modeler , Python , QuickBooks , Ruby , Shade , Software , Spreadsheet , SQL , Support , Systems Administration , Tech Support , Troubleshooting , Unix , UI / UX , Web Page Design , Windows , Word Processing , XML , XHTM ,L";
		System.out.println("skillName:" +skillName);
		System.out.println("exp_skillName:" +exp_skillName);
		System.out.println("Skills are in sorted order or not:" +skillName.equals(exp_skillName));
						


	}

}
