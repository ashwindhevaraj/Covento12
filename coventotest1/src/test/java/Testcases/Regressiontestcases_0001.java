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
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class Regressiontestcases_0001 {
@Factory
public Object[] testcases() {
	return new Object[] {new TC_0002_ToolsQA(),
			new TC_0003_RahushettyTC()
			};
}
}
