package practiceclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Pim_employlist {
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
public void Customfield() throws Throwable {
	/*
	 * driver.findElement(By.id("buttonAdd")).click();
	 * driver.findElement(By.name("customField[name]")).sendKeys("sanjit");
	 * 
	 * Select srt= new Select(driver.findElement(By.name("customField[screen]")));
	 * srt.selectByIndex(1); Select srt1= new
	 * Select(driver.findElement(By.name("customField[type]")));
	 * srt1.selectByIndex(1); driver.findElement(By.name("btnSave")).click();
	 * 
	 * 
	 * Thread.sleep(3000);
	 */
	  driver.findElement(By.xpath("//tr[1]//td[1]//input[1] ")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("buttonRemove")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("dialogDeleteBtn")).click();
	  System.out.println("sucessfully deleated");
	 
}

	public static void main(String[] args) throws Throwable {
		Pim_employlist obj= new Pim_employlist();
		obj.LaunchApplication();
		obj.Adminlogin("Admin", "Qedge123!@#");
		//testcase 1-customfield
		 Actions act1= new Actions(driver);
		 
			act1.moveToElement(driver.findElement(By.xpath("//b[contains(text(),'PIM')]"))).perform();
			  
		 
			 act1.moveToElement(driver.findElement(By.id("menu_pim_Configuration"))).
			  perform ();
		  
		  driver.findElement(By.id("menu_pim_listCustomFields")).click();
		  obj.Customfield();
	obj.closeApplication();
	}

}
