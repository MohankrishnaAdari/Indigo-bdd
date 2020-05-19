package test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={
				"D:\\Selenium\\Workspace\\indigo\\src\\test\\resources\\feature\\ValidateTitle.feature",
				"D:\\Selenium\\Workspace\\indigo\\src\\test\\resources\\feature\\SearchFlights.feature"
		  			},
		glue={"gluecode"},
		monochrome=true,
		plugin={"pretty","html:target\\res1","rerun:target\\res.txt"}
		)
public class Runner1 
{

}
