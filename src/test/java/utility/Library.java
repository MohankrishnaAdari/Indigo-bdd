package utility;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;




public class Library 
{
	 /*
	 * Method Name : clickElement
	 * 
	 * Description : This method is used to Click the Element
	 * 
	 * Input:: WebElement
	 * 
	 * 
	 * Author : Mohan Selenium Testing 
	 * 
	 * 
	 * 
	 */
	public static void clickElement(WebElement element) {
        
		

		try {
			
			element.click();
			
			
			
		} 
		catch (Exception e) 
		{
			System.out.println("test failed "+e);
		}

		
	}

	 /*
		 * Method Name : validateElement
		 * 
		 * Description : This method is used to validate Element is selected or not
		 * 
		 * Input:: WebElement
		 * 
		 * 
		 * Author : Mohan Selenium Testing 
		 * 
		 * 
		 * 
		 */
		public static void validateElement(WebElement element,Scenario s) throws Exception 
		{
	        
			Thread.sleep(5000);

			try {
				
				if(element.isSelected())
				{
				  s.write("Element selection test pass");	
				}
				else
				{
					s.write("Element selection test fail");
				}
				
				
			} 
			catch (Exception e) 
			{
				System.out.println("test failed "+e);
			}

			
		}
		
		
		/*
		 * Method Name : elementisdisplayed
		 * 
		 * Description : This method is used to element is displayed
		 *  
		 * Input:: WebElement 
		 * 
		 * 
		 * Author : Mohan Selenium Testing 
		 * 
		 * 
		 * 
		 */
		
      public static void elementisdisplayed(WebElement element,Scenario s)
      {
    	  if(element.isDisplayed())
    	  {
    		  s.write("Search Flight test was passed");
    	  }
    	  else 
    	  {
    		  s.write("Seach Flight test was failed");
    	  }
      }

	/*
	 * Method Name : setTextandEnter
	 * 
	 * Description : This method is used to send the data to input text field
	 * 
	 * Input:: WebElement and text Data
	 * 
	 * 
	 * Author : Mohan Selenium Testing 
	 * 
	 * 
	 * 
	 */
	public static void setTextandEnter(WebElement element,String x) 
	{

		

		try {
			
			
			element.click();
			element.sendKeys(x,Keys.ENTER);
			} 
		catch (Exception e) 
		{
			System.out.println("test failed "+e);
		}

		
	}
	

	

	
 //----DatePicker------
	public void datepicker(String date,WebElement mnt1element,WebElement mnt2element,WebElement nxtBtn,List<WebElement> dt,List<WebElement> dt2) throws InterruptedException
	{
		
		
			String[] d=date.split("-");
			String expday=d[0];
			String month=d[1];
		try
		  {
		while (4>2)
        {
			
			
			String actmnt=mnt1element.getText();
			
		  
	        if (actmnt.contains(month))
	         {
	        	System.out.println("match ele");
	        	break; 
	         }
	        else
	        {
	        	
	        	Thread.sleep(3000);
	        	nxtBtn.click();
	        	
	        }
	           
           }
		  }
		  catch(Exception e)
		  {
			  
			  String actmnt2=mnt2element.getText();
			  System.out.println(actmnt2);
			 if(actmnt2.contains(month))
			 {
				 
				 for(WebElement day2:dt2)
					{
					  String actdate=day2.getText();
					  System.out.println(actdate);
					  if(expday.equals(actdate))
					  {
						  day2.click();
						  Thread.sleep(5000);
						  break;
					  }
					}
				 
			 }
		  }
		
		for(WebElement day1:dt)
		{
		  String actdate=day1.getText();
		  
		  if(expday.equals(actdate))
		  {
			  System.out.println(day1);
			  day1.click();
			  Thread.sleep(5000);
			  break;
		  }
		  
		}
	}
		
}
