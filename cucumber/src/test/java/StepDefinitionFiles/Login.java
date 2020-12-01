package StepDefinitionFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Login {
	
	WebDriver driver;
	
	@Before
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Given("^user navigates to the login page$")
	public void user_navigates_to_the_login_page() throws Throwable {
	    driver.get("https://demo.actitime.com/login.do");
	}

	@And("^user enters (.*) in username TextField$")
	public void user_enters_username_in_username_TextField(String username){
		driver.findElement(By.id("username")).sendKeys(username);
	}

	@And("^user enters (.*) in password TextField$")
	public void user_enters_password_in_password_TextField(String password){
	    driver.findElement(By.name("pwd")).sendKeys(password);
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {
	    driver.findElement(By.id("loginButton")).click();
	}

	@Then("^user should be able to navigated to homepage$")
	public void user_should_be_able_to_navigated_to_homepage() throws Throwable {
	    WebElement logoutLink=driver.findElement(By.id("logoutLink"));
	   Assert.assertEquals(true,logoutLink.isDisplayed());
	    
	 //   Assert.assertTrue(logoutLink.isDisplayed());
	}
	
//	@After
//	public void close()
//	{
//		driver.close();
//	}

}
