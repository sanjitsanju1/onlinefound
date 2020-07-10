package practiceclass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Leave {
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
	public void myleave() throws Throwable {
		Actions act1= new Actions(driver);
		 
		act1.moveToElement(driver.findElement(By.xpath("//b[contains(text(),'Leave')]"))).perform();
		  driver.findElement(By.id("menu_leave_viewMyLeaveList")).click();
		  driver.findElement(By.className("ui-datepicker-trigger")).click();
		  Thread.sleep(2000);
	List<WebElement>dates= driver.findElements(By.xpath("//div[@id=\"ui-datepicker-div\"]/table//td"));
	
	for(int i=0;i<dates.size();i++) {
		String date=dates.get(i).getText();

		if(date.equalsIgnoreCase("5")) {
			dates.get(i).click();
			break;
		}
	}
	driver.findElement(By.className("ui-datepicker-trigger")).click();
	List<WebElement>olist=driver.findElements(By.xpath("//div[@id=\"ui-datepicker-div\"]/table//td"));
	for(int i=0;i<olist.size();i++) {
		String dates1=olist.get(i).getText();
		if(dates1.equalsIgnoreCase("17")) {
			olist.get(i).click();
			break;
		}
	}
	driver.findElement(By.id("leaveList_chkSearchFilter_checkboxgroup_allcheck")).click();
	driver.findElement(By.name("btnSearch")).click();	
	}
	

	public static void main(String[] args) throws Throwable {
		Leave obj =new Leave();
		obj.LaunchApplication();
		obj.Adminlogin("Admin", "Qedge123!@#");
		obj.myleave();
		Thread.sleep(5000);
		obj.closeApplication();
		
		

	}

}
