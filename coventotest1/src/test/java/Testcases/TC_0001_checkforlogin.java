package Testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC_0001_checkforlogin {
	public static WebDriver driver;
	@BeforeClass
	@Parameters({"url","browser"})
	public void setup(String url,String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("Webdriver.chrome.driver","//src//test//resources//chromedriver_win32//chromedriver");
		driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get(url);
		System.out.println(driver.getTitle());
		}
	@Test(priority=3,dependsOnMethods="basecheck1")
	public void check1() {
System.out.println("First method this is");
}
	@Test(priority=2)
	public void basecheck1() {
System.out.println("Second method this is");
}
	
	@Test(priority=-1)
	public void aftercheck1() {
System.out.println("Third method this is");
}
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
