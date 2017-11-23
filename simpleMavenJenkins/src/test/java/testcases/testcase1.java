package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testcase1 {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.out.println("this is test test 2");
		System.setProperty("webdriver.chrome.driver", "c:\\driver\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\aDee\\Desktop\\Sel\\geckodriver-v0.19.1-win64\\geckodriver.exe");
		//driver=new FirefoxDriver();
		driver = new ChromeDriver();
	}
	@Test(priority=1)
	public void validateHomePageTitle() {
		driver.get("http://zero.webappsecurity.com/");
		System.out.println(driver.getTitle());
		Assert.assertEquals("Zero - Personal Banking - Loans - Credit Cards", driver.getTitle());
	}
	
	@Test(priority=2)
	public void login() {
		driver.findElement(By.id("signin_button")).click();
		System.out.println(driver.getTitle());
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		System.out.println(driver.getTitle());
		String actual=driver.findElement(By.xpath("//a[@href='/bank/redirect.html?url=account-summary.html']")).getText();
		Assert.assertEquals("Account Summary", actual);
		}
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}
