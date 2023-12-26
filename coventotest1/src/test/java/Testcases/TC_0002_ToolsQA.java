package Testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Corepages.Excelread;
import Corepages.Loginpage;
import Corepages.Rahulshettyclass;

public class TC_0002_ToolsQA extends Utilitieslocal{
	Loginpage page;
	@Test()
	public void init() throws Exception{
		page=PageFactory.initElements(Utilitieslocal.driver,Loginpage.class);
	}
	@DataProvider
	public Iterator<Object[]> readdata() throws Exception {
		ArrayList<Object[]> l=Excelread.initialize(System.getProperty("user.dir")+"//src//test//resources","datasheet.xlsx","Sheet1");
		return l.iterator();
	}
	@Test(priority=1,dataProvider="readdata")
	public void Enterdetails(String uname,String pword){
		page.loginapplication(uname,pword);
	}
	@Test(priority=2,enabled=true)
	public void draganddrop(){
		page.draganddroptest();
	}
	
	@Test(priority=3)
	public void mouseactions(){
		page.mouseactions();
	}
	
	/*@Test(priority=4)
	public void keyboardactions(){
		page.keyboardactions();
	}*/
	@Test(priority=5)
	public void displaylinks() {
		page.displayall_links();
	}
	@Test(priority=6)
	public void handlingbrokenlinks() {
	   page.brokenlinksearch();
	}
	@Test(priority=7)
	public void handlingbrokenimage() {
		page.brokenimagecheck();
	}
	@Test(priority=8)
	public void textboxactions() {
		page.textboxverification("Aswintest","asdev@vestas.com","9A rmdoess street,npmkm,chn-788999");
	}
	@Test(priority=9)
	public void checkboxaction() {
		page.checkboxactions();
	}
	@Test(priority=10)
	public void radiobuttonactions() throws Exception {
		page.radiobuttonactions();
	}
	@Test(priority=11)
	public void webtablehandling() {
		page.webtablehandling();
	}
	@Test(priority=12)
	public void windowhandler() {
		page.linksverification();
	}
	@Test(priority=13)
	public void calenderactions() {
		page.calenderpick("21","April","2021");
	}
	
	@Test(expectedExceptions=ArithmeticException.class,priority=14)
	public void exceptioncheck() {
		page.exceptioncheck();
	}
	
	/*
	@Test(priority=8)
	public void dynamictable() {
		page.dynamictablehandler();
	}
	
	*/
	@AfterClass
	public void teardown() {
		Utilitieslocal.driver.quit();
	}
}
