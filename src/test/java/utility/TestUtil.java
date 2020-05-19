package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtil 
{
	public static WebDriver driver;
	public TestUtil()
	{
		driver=null;
	}
 public WebDriver openBrowser(String bn)
 {
	 
	 
	 if(bn.equalsIgnoreCase("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 else if (bn.equalsIgnoreCase("firefox"))
	 {
		 WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
	 }
	 else if(bn.equalsIgnoreCase("opera"))
	 {
		 WebDriverManager.operadriver().setup();
			driver=new OperaDriver();
		
	 }
	 else
	 {
		 
		 EdgeOptions eo=new EdgeOptions();
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
	 }
	 driver.manage().window().maximize();
	 return (driver);
 }
 public void launchsite(String url)throws Exception
 {
    driver.get(url);
    
 }
 public String screenShort() throws Exception
 {
	 SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
	 Date dt=new Date();
	 String st=sf.format(dt)+".png";
	 File src =((RemoteWebDriver) driver).getScreenshotAs(OutputType.FILE);
	 File dest=new File(st);
	 FileHandler.copy(src, dest);
	 return(dest.getAbsolutePath());
 }
 public void validate(WebDriver driver,Scenario s, String et)
 {
	 String at=driver.getTitle();
		if (at.contains(et))
		{
			s.write("Indigo site title test passed");
			
		}
		else
		{
			s.write("Indigo Site title test fail");
		}
 }
/* public void close(WebDriver driver)
 {
	 driver.close();
 }*/
 

}
