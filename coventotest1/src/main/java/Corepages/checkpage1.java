package Corepages;
import java.util.ResourceBundle;

public class checkpage1 {
public static void main(String args[]) {
	ResourceBundle rr=ResourceBundle.getBundle("config");
	System.out.println(rr.getString("username"));
}
}
