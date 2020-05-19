package gluecode;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchFlightStepDefination 
{
	

	public Shared sh;
	public SearchFlightStepDefination (Shared sh)
	{
		this.sh=sh;
	}
	
	
	@When ("^click radio button \"(.*)\"$")
		public void clickrdb(String rdbname)
	{
		sh.hp.clickRadioButton(rdbname);
	}
	 
  @When ("^enter from \"(.*)\" place \"(.*)\"$")
  @And ("^enter from place \"(.*)\"$")
  public void enterfrmcity(String frmcity)throws Exception
  {
	 sh.hp.fromPlace(frmcity);
	 
  }
  @When("^enter to \"(.*)\" place \"(.*)\"$") 
  @And ("^enter to place \"(.*)\"$")
  public void entertocity(String tocity)throws Exception
  {
	 sh.hp.toPlace(tocity);
  }
  @When ("^enter from \"(.*)\" date \"(.*)\"$")
  @And ("^enter from date \"(.*)\"$")
  public void enterfdt(String fdt)throws Exception
  {
	  ((RemoteWebDriver)sh.driver).executeScript("window.scroll(0,200);");
	  sh.hp.enterfrmdate(fdt);
  }
 @When ("^enter to \"(.*)\" date \"(.*)\"$")
 @And ("^enter to date \"(.*)\"$")
  public void entertdt(String tdt)throws Exception
  {
	  sh.hp.entertodate(tdt);
  }
 @When ("^click \"(.*)\" search$")
 @And("^click search$")
 public void clicksearchbtn()
 {
	 sh.hp.clicksearchbtn();
	 WebDriverWait wait =new WebDriverWait(sh.driver,20);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Modify Search'])[2]")));
 }
 @Then ("^validate radiobutton clicked$")
 public void validaterbtn()throws Exception
 {
	sh.hp.validateRadiobtn(sh.s); 
 }
 
 @Then ("^validate flight details page should be opend$")
 public void flightdetailspg()
 {
	sh.hp.flightdetspg(sh.s);
 }
 @When("^close \"(.*)\" site$")
 @And("^close site$")
 public void close()
 {
	 sh.tu.driver.quit();
 }

}

