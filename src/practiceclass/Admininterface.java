package practiceclass;

import java.awt.Desktop.Action;
import java.io.File;
//import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Admininterface {
	static WebDriver driver;

	public void LaunchApplication() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sanjit sahoo\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void closeApplication() {
		driver.quit();

	}

	public void Adminlogin(String username, String password) throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
	}

	/*
	 * File ts=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * FileHandler.copy(ts, new File("c://Screenshot//photo.png")); }
	 * 
	 */
	public void AddUser() {
		Select rc = new Select(driver.findElement(By.id("systemUser_userType")));
		rc.selectByIndex(1);

		driver.findElement(By.name("systemUser[employeeName][empName]")).sendKeys("sanjit sahoo");
		driver.findElement(By.name("systemUser[userName]")).sendKeys("User234");
		Select rc1 = new Select(driver.findElement(By.name("systemUser[status]")));
		rc1.selectByIndex(0);
		driver.findElement(By.name("systemUser[password]")).sendKeys("Username@12");
		driver.findElement(By.name("systemUser[confirmPassword]")).sendKeys("Username@12");
		driver.findElement(By.className("addbutton")).click();

	}
	public void Optional_Field() {
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("configPim_chkDeprecateFields")).click();
		driver.findElement(By.id("configPim_chkShowSSN")).click();
		driver.findElement(By.id("configPim_chkShowSIN")).click();
		driver.findElement(By.id("configPim_chkShowTax")).click();
		driver.findElement(By.id("btnSave")).click();
		System.out.println("Sucessfully saved");
	}

	public static void main(String[] args) throws Throwable {
		Admininterface obj = new Admininterface();

		/*
		 * //Testcase 1 verify lunch application boolean username=
		 * driver.findElement(By.name("txtUsername")).isDisplayed(); boolean password
		 * =driver.findElement(By.name("txtPassword")).isDisplayed(); boolean login=
		 * driver.findElement(By.name("Submit")).isDisplayed(); if(username==true &&
		 * password == true && login==true) {
		 * System.out.println("Testcase 1 "+"username, password, login is availabale");
		 * } else System.out.println("username, password, login is not availabale");
		 * obj.closeApplication(); //testcase 2 verify admin login
		 * 
		 * obj.LaunchApplication(); obj.Adminlogin("Admin", "Qedge123!@#"); String
		 * url=driver.getCurrentUrl(); if(url.equals(
		 * "http://orangehrm.qedgetech.com/symfony/web/index.php/dashboard")) {
		 * System.out.println("Testcase 2 "+"Login sucessful"); } else
		 * System.out.println("login failed");
		 * 
		 * obj.closeApplication();
		 */
		// Testcase 3 verify dashboard.

		obj.LaunchApplication();
		obj.Adminlogin("Admin", "Qedge123!@#");
		// String dash = driver.findElement(By.className("firstLevelMenu")).getText();

		
		
		/*
		 * Actions ac= new Actions(driver);
		 * ac.moveToElement(driver.findElement(By.className("firstLevelMenu"))).perform(
		 * ); ac.moveToElement(driver.findElement(By.id("menu_admin_UserManagement"))).
		 * perform(); driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		 * driver.findElement(By.id("btnAdd")).click(); obj.AddUser();
		 * driver.navigate().refresh(); driver.navigate().back();
		 */
		  Actions act= new Actions(driver);
		  act.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).
		  perform ();
		  act.moveToElement(driver.findElement(By.id("menu_pim_Configuration"))).
		  perform(); 
		  driver.findElement(By.linkText("Optional Fields")).click() ;
		 driver.navigate().back();
		 Actions act1= new Actions(driver);
		  act1.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).
		  perform ();
		  act1.moveToElement(driver.findElement(By.id("menu_pim_Configuration"))).
		  perform(); 
		 driver.findElement(By.id("menu_pim_listCustomFields")).click();
		 driver.navigate().back();
		 Actions act2= new Actions(driver);
		  act2.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).
		  perform ();
		  act2.moveToElement(driver.findElement(By.id("menu_pim_Configuration"))).
		  perform(); 
		 driver.findElement(By.id("menu_admin_pimCsvImport")).click();
		 driver.navigate().back();
		 Actions act3= new Actions(driver);
		  act3.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).
		  perform ();
		  act3.moveToElement(driver.findElement(By.id("menu_pim_Configuration"))).
		  perform(); 
		 driver.findElement(By.id("menu_pim_viewReportingMethods")).click();
		 driver.navigate().back();
		 Actions act4= new Actions(driver);
		  act4.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule"))).
		  perform ();
		  act4.moveToElement(driver.findElement(By.id("menu_pim_Configuration"))).
		  perform(); 
		 driver.findElement(By.id("menu_pim_viewTerminationReasons")).click();
		 driver.navigate().back();
		
		
		
		
	}

}
