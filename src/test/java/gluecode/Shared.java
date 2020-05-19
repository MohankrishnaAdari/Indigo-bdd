package gluecode;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.HomePage;
import utility.TestUtil;

public class Shared 
{
	public  WebDriver driver;
	public static Scenario s;
	public Properties p;	
	public TestUtil tu;
	public HomePage hp;
	
	@Before
	public void getProperyVal(Scenario s)throws Exception
	{
		//define Scenario class object for current Scenario
		this.s=s;		
		//load properties file
		File f=new File("D:\\Selenium\\Workspace\\indigo\\src\\test\\resources\\properties\\indigoproperties.properties");
		FileReader fr=new FileReader(f);
		p=new Properties();
		p.load(fr);
		//define utility class object
		tu=new TestUtil();
		hp=new HomePage(driver);
		
	}

}
