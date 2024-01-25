package Testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.URL;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilitieslocal {
	public static WebDriver driver;
	public static Logger log;
	public static File screenshot;
	public static DesiredCapabilities dc;
	@Parameters({"url","browser"})
	@BeforeClass
	public static void setup(String url,String browser) throws Exception {
		log=LogManager.getLogger(Utilitieslocal.class);
		dc=new DesiredCapabilities();
		
		if(browser.equalsIgnoreCase("chrome")) {
		//System.setProperty("Webdriver.chrome.driver","//src//test//resources//chromedriver_win32//chromedriver");
			//https://rahulshettyacademy.com/AutomationPractice/-use this hereafter
			//WebDriverManager.chromedriver().setup();
		ChromeOptions chromeoptions=new ChromeOptions();
		chromeoptions.addArguments("--incognito");
		chromeoptions.addArguments("--headless");
		driver=WebDriverManager.chromedriver().capabilities(chromeoptions).create();
			/*dc.setBrowserName("chrome");		
			log.info("chrome driver opened up");*/
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.gecko.driver","//src//test//resources//geckodriver-v0.33.0-win64//geckodriver");
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			/*FirefoxOptions options=new FirefoxOptions();
			options.addArguments("InPrivate");
			driver=WebDriverManager.firefoxdriver().capabilities(options).create();*/
			//dc.setBrowserName("firefox");
			log.info("firefox opened successfully");
		}
		
		else if(browser.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver","//src//test//resources//edgedriver_win64//msedgedriver");
			/*WebDriverManager.edgedriver().arch64().setup();
			EdgeOptions options=new EdgeOptions();
			options.addArguments("InPrivate");
			driver=new EdgeDriver(options);*/
			/*dc.setBrowserName("MicrosoftEdge");
			log.info("edge opened successfully");*/
			EdgeOptions options=new EdgeOptions();
			options.addArguments("InPrivate");
			driver=WebDriverManager.edgedriver().capabilities(options).create();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver=WebDriverManager.safaridriver().create();
		}
		//driver=new RemoteWebDriver(dc); we can use this statement if we use hub and node concept 
		screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")+"//src//test//resources//screenshot1.jpg"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.get(url);
		System.out.println(driver.getTitle());
		}
}
