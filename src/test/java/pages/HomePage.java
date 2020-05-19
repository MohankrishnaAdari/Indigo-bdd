package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;
import utility.Library;

public class HomePage extends Library
{

//===========Elements section===================
  //-------------- Radio Button Element---------------------

@FindBy(xpath= "//*[text()='One Way']")
public static WebElement onewayRadioBtn;

@FindBy(xpath = "//*[text()='Round Trip']")
public static WebElement roundTripRadioBtn;

@FindBy (xpath = "//*[text()='Multi-city']")
public static WebElement multcityRadioBtn;

//------------From text field Element--------------------

@FindBy(xpath="(//*[text()='From'])[1]/parent::div/div/input")
public static WebElement fromfield;

//------------NextButton Element----------------------------

@FindBy (xpath="//span[text()='Next']")
public static WebElement  nextButton;

//------------To text field Element--------------------

@FindBy (xpath="(//*[text()='To'])[1]/parent::div/div/input")
public static WebElement  toField;

//--------------Calender Elements-----------------
@FindBy (xpath="(//*[text()='Departure Date'])[1]/parent::div/input")
public static WebElement  depaturedate;

@FindBy (xpath ="(//span[@class='ui-datepicker-month'])[1]")
public static WebElement  mnt1;

@FindBy (xpath="(//span[@class='ui-datepicker-month'])[2]")
public static WebElement  mnt2;

@FindBys(@FindBy (xpath="(//table[@class='ui-datepicker-calendar'])[1]/tbody/tr/td"))
public static List<WebElement> days1;

@FindBys(@FindBy (xpath="(//table[@class='ui-datepicker-calendar'])[2]/tbody/tr/td"))
public static List<WebElement> days2;

@FindBy (xpath="(//*[text()='Return Date'])[1]/parent::div/input")
public static WebElement returndate;

@FindBy(xpath="//span[text()='Search Flight']")
public static WebElement searchbtn;

@FindBy(xpath="(//button[text()='Modify Search'])[2]")
public static WebElement modifysearch;

public WebDriver driver;
public JavascriptExecutor js;
public String radiobtnType =null;
public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

public void clickRadioButton(String rb)
{
	radiobtnType = rb;
	if (rb.equalsIgnoreCase("OneWay"))
	{
		clickElement(onewayRadioBtn);
		
	}
	else if(rb.equalsIgnoreCase("RoundTrip"))
	{
		
		clickElement(roundTripRadioBtn);
	}
	else
	{
		clickElement(multcityRadioBtn);
	}
}
public void fromPlace(String frmPlce)throws Exception
{
	System.out.println(fromfield);
	setTextandEnter(fromfield,frmPlce);
}
public void toPlace(String toPlce)throws Exception
{
	setTextandEnter(toField,toPlce);
}

public void enterfrmdate(String date)throws Exception
{
	Thread.sleep(5000);
	clickElement(depaturedate);
		
	datepicker(date,mnt1,mnt2,nextButton,days1,days2);
}
public void entertodate(String date)throws Exception
{
	if(!radiobtnType.equalsIgnoreCase("oneway"))
	{	
	clickElement(returndate);
	
	
	datepicker(date,mnt1,mnt2,nextButton,days1,days2);
}
}
public void clicksearchbtn()
{
	clickElement(searchbtn);
	
}

public void validateRadiobtn(Scenario s)throws Exception
{
	if (radiobtnType.equalsIgnoreCase("OneWay"))
	{
	validateElement(onewayRadioBtn, s);
	}
	else if (radiobtnType.equalsIgnoreCase("RoundTrip"))
	{
		validateElement(roundTripRadioBtn, s);	
	}
	   else
	   {
		  validateElement(multcityRadioBtn,s);
	   }
	

}

public void flightdetspg(Scenario s)
{
	elementisdisplayed(modifysearch,s);
}

}
