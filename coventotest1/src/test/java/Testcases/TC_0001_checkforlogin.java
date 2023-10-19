package Testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import Corepages.Excelread;


public class TC_0001_checkforlogin {
	public static WebDriver driver;
	@BeforeClass
	@Parameters({"url","browser"})
	public void setup(String url,String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		//System.setProperty("Webdriver.chrome.driver","//src//test//resources//chromedriver_win32//chromedriver");
			WebDriverManager.chromedriver().setup();
		ChromeOptions chromeoptions=new ChromeOptions();
		chromeoptions.addArguments("--headless");
		driver=new ChromeDriver(chromeoptions);
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			//System.setProperty("Webdriver.gecko.driver","//src//test//resources//geckodriver-v0.33.0-win64//geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver","//src//test//resources//edgedriver_win64//msedgedriver");
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get(url);
		System.out.println(driver.getTitle());
		}
	
	// TC 1 written by Ash
	@Test(priority=3,dependsOnMethods="basecheck1")
	public void check1() {
System.out.println("First method this is");
}
	
	//TC 2 written by Ash
	@Test(priority=2,groups="regression")
	public void basecheck1() {
System.out.println("Second method this is");
}
	
	//TC3 written by Ash
	@Test(priority=1,groups="regression")
	public void aftercheck1() {
System.out.println("Third method this is");
}
	
	//TC4 written by Ash using dataprovider
	@Test(priority=4,dataProvider="readdata",groups="regression")
	public void excelread(String username,String password) {
		System.out.println("checking this method working");
		System.out.println(username);
		System.out.println(password);
	}
	
	//Dataprovider at local level
	@DataProvider
	public Iterator<Object[]> readdata() throws Exception {
		ArrayList<Object[]> l=Excelread.initialize(System.getProperty("user.dir")+"/src/test/resources","datasheet.xlsx","Sheet1");
		return l.iterator();
	}
	
	@AfterClass
	public void teardown() {
		driver.close();
	}
}
