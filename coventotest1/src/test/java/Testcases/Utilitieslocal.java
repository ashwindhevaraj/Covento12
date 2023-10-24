package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilitieslocal {
	public static WebDriver driver;
	public static void setup(String url,String browser) {
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
}
