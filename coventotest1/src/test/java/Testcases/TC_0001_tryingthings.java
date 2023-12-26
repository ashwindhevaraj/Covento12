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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import Corepages.Excelread;

public class TC_0001_tryingthings{
	@Parameters({"url","browser"})
	@BeforeTest
	public void loginmercury(String url,String browser)throws Exception {
		Utilitieslocal.setup(url,browser);
		//Mercurytours tour=new Mercurytours(Utilitieslocal.driver);
		//tour.clicksignon();
		
	}
	
	// TC 1 written by Ash
	@Test(priority=3)
	public void check1() {
System.out.println("First method this is");
}
	
	//TC 2 written by Ash
	@Test(priority=2)
	public void basecheck1() {
		Utilitieslocal.driver.get("https://www.gmail.com");
System.out.println("Second method this is");
}
	
	//TC3 written by Ash
	@Test(priority=1)
    
	public void aftercheck1() {
System.out.println("Third method this is");
}
	
	//TC4 written by Ash using dataprovider
	@Test(priority=4,dataProvider="readdata")
	public void excelread(String username,String password) {
		System.out.println("checking this method working");
		System.out.println(username);
		System.out.println(password);
	}
	
	//Dataprovider at local level
	@DataProvider
	public Iterator<Object[]> readdata() throws Exception {
		ArrayList<Object[]> l=Excelread.initialize(System.getProperty("user.dir")+"//src//test//resources","datasheet.xlsx","Sheet1");
		return l.iterator();
	}
	
	
	@AfterTest
	public void teardown() {
		Utilitieslocal.driver.close();
	}
}
