package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC001ExecuteWithOutPOM {

	/**
	 * @author saikiran.nataraja
	 * This testCases case will loginButton in http://demo.borland.com/InsuranceWebExtJS/
	 * Login to application
	 * Verify the home page using Dashboard message
	 */
	@Test(priority=0)
	public void testLoginPage(){
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.borland.com/InsuranceWebExtJS/");
		//Find user name and fill user name
	    driver.findElement(By.name("login-form:email")).sendKeys("john.smith@gmail.com");
	    //find passwordTextField and fill it
	    driver.findElement(By.name("login-form:password")).sendKeys("john");
	    //click loginButton button
	    driver.findElement(By.name("login-form:login")).click(); 
	    String homeText = driver.findElement(By.xpath("//label[@for='logout-form']")).getText();
	    //verify loginButton success
		Assert.assertTrue(homeText.equalsIgnoreCase("John Smith"));
		driver.close();
	}
	
}
