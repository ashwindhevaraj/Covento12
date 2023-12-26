package Corepages;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Loginpage extends Basepage{
public WebDriver driver;
public WebDriverWait wait;
public SoftAssert sa;
public Loginpage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	this.sa=super.sa;
}
@FindBy(how=How.XPATH,using="//div[text()='Book Store Application']") WebElement bookstoreapplicationdiv;
@FindBy(how=How.XPATH,using="//span[text()='Login']") WebElement loginbutton;
@FindBy(how=How.ID,using="userName") WebElement usernametxt;
@FindBy(how=How.ID,using="password") WebElement passwordtxt;
@FindBy(how=How.ID,using="login") WebElement loginbtn;
@FindBy(how=How.XPATH,using="//div[text()='Interactions']") WebElement interactionmenu;
@FindBy(how=How.XPATH,using="//span[text()='Droppable']") WebElement droppablemenu;
@FindBy(how=How.XPATH,using="//div[text()='Drag me']") WebElement dragsource;
@FindBy(how=How.XPATH,using="(//p[text()='Drop here'])[1]") WebElement dragdestini;
@FindBy(how=How.XPATH,using="//div//p[text()='Dropped!']")WebElement droppedbox;
@FindBy(how=How.XPATH,using="//div[text()='Elements']")WebElement elementsbutton;
@FindBy(how=How.XPATH,using="//span[text()='Buttons']")WebElement buttonmenu;
@FindBy(how=How.ID,using="doubleClickBtn")WebElement doubleclickbtn;
@FindBy(how=How.ID,using="rightClickBtn")WebElement rightclickbtn;
@FindBy(how=How.XPATH,using="//button[text()='Click Me']")WebElement clickmebtn;
@FindBy(how=How.CSS,using="[id='verticalListContainer']>li")WebElement multiselect;
@FindBy(how=How.XPATH,using="//span[text()='Selectable']")WebElement selectablesubmenu;
@FindBy(how=How.XPATH,using="//p[text()='Valid image']//following::img[1]")WebElement validimage;
@FindBy(how=How.XPATH,using="//p[text()='Broken image']")WebElement brokenimage;
@FindBy(how=How.XPATH,using="//span[text()='Broken Links - Images']")WebElement brokenlinkbutton;
@FindBy(how=How.XPATH,using="//div[text()='Forms']")WebElement forms;
@FindBy(how=How.XPATH,using="//span[text()='Practice Form']")WebElement practiceforms;
@FindBy(how=How.CSS,using="#dateOfBirthInput")WebElement calenderinput;
@FindBy(how=How.CSS,using="select[class='react-datepicker__month-select']")WebElement monthdpdown;
@FindBy(how=How.CSS,using="select[class='react-datepicker__year-select']")WebElement yeardpdown;
@FindBy(how=How.XPATH,using="//div[@class='react-datepicker__month']")WebElement datepicker;
@FindBy(how=How.XPATH,using="//span[text()='Text Box']")WebElement textboxmenu;
@FindBy(how=How.CSS,using="[id='userName']")WebElement fullname;
@FindBy(how=How.CSS,using="[id='userEmail']")WebElement emailid;
@FindBy(how=How.CSS,using="[id='currentAddress']")WebElement currentaddress;
@FindBy(how=How.CSS,using="[id='permanentAddress']")WebElement permanentaddress;
@FindBy(how=How.CSS,using="[id='submit']")WebElement textsubmitbtn;
@FindBy(how=How.CSS,using="p[id='name']")WebElement fullnamecheck;
@FindBy(how=How.CSS,using="p[id='currentAddress']")WebElement currentaddresscheck;
@FindBy(how=How.CSS,using="p[id='email']")WebElement emailidcheck;
@FindBy(how=How.CSS,using="p[id='permanentAddress']")WebElement permanentaddresscheck;
@FindBy(how=How.XPATH,using="//span[text()='Check Box']")WebElement checkboxmenu;
@FindBy(how=How.CSS,using="button[title='Toggle']>svg")WebElement homecheckbox;
@FindBy(how=How.XPATH,using="//span[text()='Downloads']//ancestor::li[@class='rct-node rct-node-parent rct-node-collapsed']//button")WebElement downloadcheckboxbtn;
@FindBy(how=How.XPATH,using="//span[text()='Word File.doc']")WebElement wordfilename;
@FindBy(how=How.XPATH,using="//span[@class='text-success' and text()='wordFile']")WebElement confirmationtext1;
@FindBy(how=How.CSS,using="input#yesRadio")WebElement yesradiobtn;
@FindBy(how=How.CSS,using="span[class='text-success']")WebElement successmsg1;
@FindBy(how=How.CSS,using="#impressiveRadio")WebElement impressivebtn;
@FindBy(how=How.CSS,using="#noRadio")WebElement disabledradiobtn;
@FindBy(how=How.XPATH,using="//span[text()='Radio Button']")WebElement radiobtnmenu;
@FindBy(how=How.CSS,using="div[class='rt-resizable-header-content']")List<WebElement> tableheader;
@FindBy(how=How.CSS,using="div[class='rt-td']")List<WebElement> tablecolumn;
@FindBy(how=How.XPATH,using="//span[text()='Web Tables']")WebElement webtablemenu;
@FindBy(how=How.ID,using="addNewRecordButton")WebElement addbtn;
@FindBy(how=How.CSS,using="input#firstName")WebElement firstname;
@FindBy(how=How.CSS,using="input#lastName")WebElement lastname;
@FindBy(how=How.CSS,using="button#submit")WebElement submitbtn2;
@FindBy(how=How.ID,using="userEmail")WebElement email2;
@FindBy(how=How.ID,using="age")WebElement age2;
@FindBy(how=How.ID,using="salary")WebElement salary2;
@FindBy(how=How.ID,using="department")WebElement department2;
@FindBy(how=How.XPATH,using="//span[text()='Links']")WebElement linksmenu;
@FindBy(how=How.ID,using="simpleLink")WebElement homelink;
public void loginapplication(String uname,String pword) {
	
	//driver.findElement(bookstoreapplicationdiv).click();
	//wait.until(ExpectedConditions.elementToBeClickable(loginbutton));
	//driver.findElement(loginbutton).click();
	//wait.until(ExpectedConditions.presenceOfElementLocated(usernametxt));
	usernametxt.sendKeys(uname);
	passwordtxt.sendKeys(pword);
	loginbtn.click();
}

public void draganddroptest() {
	
	this.waitforelementclickable(interactionmenu);
	interactionmenu.click();
	//WebElement menu1=driver.findElement(droppablemenu);
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",droppablemenu);
	//wait.until(ExpectedConditions.visibilityOfElementLocated(droppablemenu));
	this.waitforelementclickable(droppablemenu);
	droppablemenu.click();
	//WebElement source=driver.findElement(dragsource);
	//WebElement target=driver.findElement(dragdestini);
	this.waitforelementclickable(dragsource);
	//wait.until(ExpectedConditions.elementToBeClickable(dragsource));
	Actions act=new Actions(driver);
	Action builder=act.clickAndHold(dragsource).moveToElement(dragdestini).release(dragsource).build();
	builder.perform();
	this.waitforelementclickable(droppedbox);
	//wait.until(ExpectedConditions.elementToBeClickable(droppedbox));
	String k=droppedbox.getText();
	System.out.println(k);
}
public void mouseactions() {
	
	this.waitforelementclickable(elementsbutton);
	elementsbutton.click();
	this.waitforelementclickable(buttonmenu);
	buttonmenu.click();
	//WebElement dbl=driver.findElement(doubleclickbtn);
	//WebElement rclk=driver.findElement(rightclickbtn);
	//WebElement clkme=driver.findElement(clickmebtn);
	this.waitforelementclickable(doubleclickbtn);
	doubleclick(doubleclickbtn);
	this.waitforelementclickable(rightclickbtn);
	rightclick(rightclickbtn);
	this.waitforelementclickable(clickmebtn);
	mouseclick(clickmebtn);
}
/*public void keyboardactions(){
	WebElement interact=driver.findElement(interactionmenu);
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",interact);
	wait.until(ExpectedConditions.elementToBeClickable(interactionmenu));
	driver.findElement(interactionmenu).click();
	wait.until(ExpectedConditions.elementToBeClickable(selectablesubmenu));
	driver.findElement(selectablesubmenu).click();
	List<WebElement> option=driver.findElements(multiselect);
	keyboardmultiselect(option);
}*/
public void displayall_links() {
	List<WebElement> link=driver.findElements(By.tagName("a"));
	for(int x=0;x<link.size();x++) {
		System.out.println("link index is "+x+"and exact link name is"+link.get(x).getText());
	}
	}
public void brokenimagecheck() {
	//this.waitforelementclickable(elementsbutton);
	//elementsbutton.click();
	this.waitforelementclickable(brokenlinkbutton);
	brokenlinkbutton.click();
	if(validimage.getAttribute("naturalWidth")==null) {
		System.out.println("Validimage is itself broken");
	}
	else if(brokenimage.getAttribute("naturalWidth")!=null) {
		System.out.println("brokenimage is itself broken");
	}
	System.out.println(brokenimage.getAttribute("naturalWidth"));
}
public void calenderpick(String day,String month,String year) {
	this.waitforelementclickable(elementsbutton);
	elementsbutton.click();
	try {
	this.waitforelementclickable(forms);
	forms.click();
	}
	catch(ElementClickInterceptedException e) {
		this.waitforelementclickable(forms);
		forms.click();
	}
	this.waitforelementclickable(practiceforms);
	practiceforms.click();
	this.waitforelementclickable(calenderinput);
	calenderinput.click();
	Select yrr=new Select(yeardpdown);
	Select mon=new Select(monthdpdown);
	
	//List l=mon.getOptions();
	yrr.selectByValue(year);
	this.waitforelementclickable(monthdpdown);
	mon.selectByVisibleText(month);
	datepicker.findElement(By.xpath("//div[text()='"+day+"']")).click();
}

public void textboxverification(String name,String email,String address) {
	textboxmenu.click();
	this.waitforelementclickable(fullname);
	fullname.sendKeys(name);
	emailid.sendKeys(email);
	currentaddress.sendKeys(address);
	permanentaddress.sendKeys(address);
	textsubmitbtn.click();
	this.waitforelementvisibility(fullnamecheck);
	sa.assertEquals(fullnamecheck.getText(),name);
	sa.assertEquals(emailidcheck.getText(), email);
	sa.assertEquals(currentaddresscheck.getText(),address);
	sa.assertEquals(permanentaddresscheck.getText(),address);
}
public void checkboxactions() {
	this.waitforelementclickable(checkboxmenu);
	checkboxmenu.click();
	this.waitforelementclickable(homecheckbox);
	homecheckbox.click();
	this.waitforelementclickable(downloadcheckboxbtn);
	downloadcheckboxbtn.click();
	this.waitforelementclickable(wordfilename);
	wordfilename.click();
	sa.assertEquals(wordfilename.getText(),"wordFile");
}
public void radiobuttonactions() throws Exception {
	this.waitforelementclickable(radiobtnmenu);
	radiobtnmenu.click();
	/*try {
	this.waitforelementclickable(yesradiobtn);
	}
	catch(Exception e) {
		this.waitforelementvisibility(yesradiobtn);
	}*/
	//this.waitforelementclickable(yesradiobtn);
	//((JavascriptExecutor)driver).executeScript("arguments[0].click", yesradiobtn);
	this.mouseclick(yesradiobtn);
	if(disabledradiobtn.isEnabled()) {
		System.out.println("Exact radio button of being disabled is not disabled");
	}
	else
		System.out.println("Radio button is disabled only");

	sa.assertEquals(successmsg1.getText(),"Yes");
	//this.waitforelementvisibility(impressivebtn);
	this.mouseclick(impressivebtn);
	sa.assertEquals(successmsg1.getText(),"Impressive");
	
}
public void exceptioncheck() {
	int a=0;
	int b=1;
	int c=0;
	c=b/a;
	}
public void webtablehandling() {
	this.waitforelementclickable(webtablemenu);
	webtablemenu.click();
	for(int x=0;x<tableheader.size()-1;x++) 
		System.out.print(tableheader.get(x).getText()+" ");
	System.out.println();
		for(int j=0;j<21;j++){
			System.out.print(tablecolumn.get(j).getText()+" ");
			if(j%7==0) {
				System.out.println();
				continue;
			}
		}
		this.waitforelementclickable(addbtn);
		addbtn.click();
		this.waitforelementvisibility(firstname);
		firstname.sendKeys("aswintesting");
		lastname.sendKeys("gggggggg");
		email2.sendKeys("ashd@gmail.com");
		age2.sendKeys("26");
		salary2.sendKeys("44444");
		department2.sendKeys("DDDDDDDDDD");
		submitbtn2.click();
		//driver.switchTo().frame(0)
}
public void linksverification() {
	this.waitforelementclickable(linksmenu);
	linksmenu.click();
	String mainwindow=driver.getWindowHandle();
	homelink.click();
	Set<String> child=driver.getWindowHandles();
	Iterator itr=child.iterator();
	while(itr.hasNext()) {
		String chwindow=itr.next().toString();
		if(!chwindow.equalsIgnoreCase(mainwindow)) {
			driver.switchTo().window(chwindow);
			WebElement chformtext=driver.findElement(By.xpath("//h5[text()='Forms']"));
			//boolean k=driver.findElement(By.xpath("//h5[text()='Forms']")).isEnabled();)
			chformtext.click();
			driver.close();
		}
	}
	driver.switchTo().window(mainwindow);
}
}
