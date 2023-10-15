package Testcases;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TC_0001_checkforlogin {
	public static WebDriver driver;
	@BeforeMethod
	public void setup() {
		System.setProperty("Webdriver.chrome.driver","//src//test//resources//chromedriver_win32//chromedriver");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("https://demo.guru99.com/test/guru99home/");
	}
	@Test
	public void check1() {
System.out.println("HI i have installed TestNG now");
}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
