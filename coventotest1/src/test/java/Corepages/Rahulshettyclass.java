package Corepages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Rahulshettyclass extends Basepage{
	public WebDriver driver;
	public WebDriverWait wait;
	public Rahulshettyclass(WebDriver driver) {
		super(driver);
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	}
	@FindBy(how=How.CSS,using="[value='radio1']")WebElement radio1;
	@FindBy(how=How.CSS,using="[value='radio2']")WebElement radio2;
	@FindBy(how=How.CSS,using="[value='radio3']")WebElement radio3;
	@FindBy(how=How.CSS,using="#alertbtn")WebElement alertbtn;
	@FindBy(how=How.CSS,using="#openwindow")WebElement windowbtn;
	@FindBy(how=How.XPATH,using="(//a[text()='Courses'])[1]")WebElement childwindow_courses;
	@FindBy(how=How.XPATH,using="//input[@placeholder='Hide/Show Example']//following::table[position()=1]")WebElement dynamictable;
	@FindBy(how=How.XPATH,using="//input[@placeholder='Hide/Show Example']//following::table[position()=1]//tbody//tr")List<WebElement> dynamictablerows;
	@FindBy(how=How.XPATH,using="//input[@placeholder='Hide/Show Example']//following::table[position()=1]//thead//tr//th")List<WebElement> dynamictablecols;
	@FindBy(how=How.CSS,using="select[id='dropdown-class-example']")WebElement selectdpdown;
	public void clickradiobutton() {
		radio1.click();
		radio2.click();
		radio3.click();
	}
	public void displayall_links() {
		List<WebElement> link=driver.findElements(By.tagName("a"));
		for(int x=0;x<link.size();x++) {
			System.out.println("link index is "+x+"and exact link name is"+link.get(x).getText());
		}
		}
	public void popuphandler() {
		this.waitforelementclickable(alertbtn);
		alertbtn.click();
		Alert alert=driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		//driver.switchTo().defaultContent();
		//driver.switchTo().frame("iii");
	}
	public void windowhandler() {
		this.waitforelementclickable(windowbtn);
		windowbtn.click();
		String mainwindow=driver.getWindowHandle();
		(windowbtn).click();
		Set<String> handles=driver.getWindowHandles();
		Iterator iter=handles.iterator();
		while(iter.hasNext()) {
			String childwindow=(String)iter.next();
			if(!mainwindow.equalsIgnoreCase(childwindow)) {
				driver.switchTo().window(childwindow);
				this.waitforelementclickable(childwindow_courses);
				childwindow_courses.click();
				driver.close();
			}
		}
		driver.switchTo().window(mainwindow);
		
	}
	public void dynamictablehandler() {
		//this.waitforelementclickable(dynamictablerows);
		//List<WebElement> rows=dynamictablerows.findElements();
		System.out.println(dynamictablerows.size());
		//List<WebElement> cols=driver.findElements(dynamictablecols);
		System.out.println(dynamictablecols.size());
		for(int i=1;i<dynamictablerows.size();i++) {
			for(int j=0;j<dynamictablecols.size();j++) {
				System.out.print(driver.findElement(By.xpath("//input[@placeholder=\"Hide/Show Example\"]//following::table[position()=1]//tbody//tr["+i+"]//td["+(j+1)+"]")).getText()+" ");
			}
			System.out.println();
		}
		
	}
	public void selectdpdownoption() {
		//this.waitforelementclickable(selectdpdown);
		Select sel=new Select(selectdpdown);
		List<WebElement> options=sel.getOptions();
		List op1=new ArrayList();
		
		for(int i=0;i<options.size();i++) {
			op1.add(options.get(i).getText());
			System.out.println(options.get(i).getText());
		}
		op1.remove("Select");
		List op2=new ArrayList();
		op2.addAll(op1);
		Collections.sort(op2);
		Assert.assertTrue(op1.equals(op2),"Both array in ascending order only");
		//changed this line
	}
}
