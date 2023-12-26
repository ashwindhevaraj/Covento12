package listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class Generaloutput extends TestListenerAdapter {
public void onTestStart(ITestResult tr) {
	System.out.println("Test cases started- message from listener class");
}
public void onTestSuccess(ITestResult tr) {
	System.out.println("Test cases passed successfully- message from listener class");
}
public void onTestFailure(ITestResult tr) {
	System.out.println("Testcases failed- message from Listener class");
}
public void onTestSkipped(ITestResult tr) {
	System.out.println("Test cases execution skipped- message from listener class");
}
}
