package gluecode;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;



public class LoginStepDefination 
{

	public Shared sh;
	public LoginStepDefination(Shared sh)
	{
		this.sh=sh;
	}
	
	public HomePage hp;
	public WebDriverWait wait;
	
// launch browser
	
@Given("^launch site using \"(.*)\"$")
public void launch(String bn)throws Exception
{
	sh.driver= sh.tu.openBrowser(bn);
	hp=new HomePage(sh.driver);
	//Thread.sleep(5000);
	sh.tu.launchsite(sh.p.getProperty("url"));
	//Thread.sleep(5000);
	wait =new WebDriverWait(sh.driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Search Flight'])[1]")));
	
	
}
//validate title

@Then("^title should be \"(.*)\"$")
public void title(String et)
{
	sh.tu.validate(sh.driver, sh.s, et);
}

}
