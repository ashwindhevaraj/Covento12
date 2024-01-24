package Testcases;
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
import Corepages.Rahulshettyclass;
public class TC_0003_RahushettyTC extends Utilitieslocal {
	Rahulshettyclass rspage;
	@Test()
	public void init() throws Exception{
		rspage=PageFactory.initElements(Utilitieslocal.driver,Rahulshettyclass.class);
	}

@Test(priority=1)
public void clickradiobutton() {
	rspage.clickradiobutton();
}
@Test(priority=2)
public void alertpopuphandler() {
	rspage.popuphandler();
}
@Test(priority=3)
public void displayalllinks() {
	rspage.displayall_links();
}
@Test(priority=4)
public void windowhandler() {
	rspage.windowhandler();
}
@Test(priority=5)
public void dynamictablehandler() {
	rspage.dynamictablehandler();
}
@Test(priority=6)
public void brokenlinkvalidations() {
	rspage.brokenlinksearch();
}
@Test(priority=7)
public void selectdropdown() {
	rspage.selectdpdownoption();
}
@Test(priority=8)
public void suggestionbox() {
	rspage.suggestionbox();
}
@Test(priority=9)
public void checkboxclick() {
	rspage.checkboxclick();
}
@Test(priority=10)
public void newtabhandling() {
	rspage.newtabhandling();
}
@Test(priority=11)
public void alerthandler2() {
	rspage.alerthandler2();
}
@Test(priority=12)
public void mousehoverhandling() {
	rspage.mouseoverexample();
}
}





	