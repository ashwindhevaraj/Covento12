package Corepages;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import Testcases.Utilitieslocal;

public class Basepage {
	public Actions act1;
	public Action aaa;
	public WebDriver driver;
	public WebDriverWait wait;
	public HttpURLConnection huc;
	public SoftAssert sa;
	public Basepage(WebDriver driver) {
		this.driver=driver;
		this.act1=new Actions(driver);
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.ignoring(NoSuchElementException.class);
		this.sa=new SoftAssert();
	}
	public void getPropertiesdata() {
	ResourceBundle rr=ResourceBundle.getBundle("config");
	System.out.println(rr.getString("username"));
	System.out.println("Aswin learning branching in Devops-Eclipse");
	}
	public void doubleclick(WebElement element) {
		aaa=act1.doubleClick(element).build();
		aaa.perform();
	}
	public void rightclick(WebElement element) {
		aaa=act1.contextClick(element).build();
		aaa.perform();
	}
	public void mouseclick(WebElement element) {
		aaa=act1.moveToElement(element).click().build();
		aaa.perform();
	}
	public void keyboardmultiselect(List<WebElement> element) {
		/*Iterator<WebElement> iter=element.iterator();
		while(iter.hasNext()) {
			aaa=act1.keyDown(Keys.CONTROL).click(iter.next()).build();
			aaa.perform();
		}*/
		int n=element.size();
		while(n-->0) {
			aaa=act1.keyDown(Keys.CONTROL).click(element.get(n)).build();
			aaa.perform();
		}
	}
	public void waitforelementclickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitforelementvisibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitforelementselectable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	public void brokenlinksearch() {
		int responsecode=200;
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Iterator<WebElement> iter=links.iterator();
		String url=" ";
		while(iter.hasNext()) {
			url=iter.next().getAttribute("href");
			System.out.println(url);
			if(url==null || url.isEmpty()) {
				System.out.println(url+" is empty and it is not valid it seems");
			}
			else if(!url.startsWith("https://rahulshettyacademy.com/")) {
				System.out.println(url+" this url is not under our application and kindly ignore");
			}
			try {
				huc=(HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				responsecode=huc.getResponseCode();
				if(responsecode>=400) {
					System.out.println(url+" this url is bad url and it has response code"+responsecode);
				}
				else {
					System.out.println(url+" this url is valid url and it has response code"+responsecode);
				}
			}
			catch(Exception e) {
				System.out.println("just a place holder now");
			}
		}
		
	}
}
