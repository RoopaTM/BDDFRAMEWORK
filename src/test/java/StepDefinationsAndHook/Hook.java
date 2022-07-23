package StepDefinationsAndHook;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Basess.Base;
import bdd.PomPages.LoginPage;
import bdd.genericUtility.PropertyUtility;
import bdd.genericUtility.WebdriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook  extends Base {

	private Base base;
	
	public Hook(Base base) {
		this.base=base;
	}
	
	@Before
	public void LoginVtiger() throws Throwable {
		PropertyUtility propUtility = base.propertyutility=new PropertyUtility();
		base.webdriverutility=new WebdriverUtility();
		propUtility.loadPropertyFile();
		String browser = propUtility.readBrowser();
		String url = propUtility.readUrl();
		String username = propUtility.readUsername();
		System.out.println(username);
		String password = propUtility.readPassword();
		
		
	if(browser.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		base.driver=new ChromeDriver();
		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	else if(browser.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		base.driver=new FirefoxDriver();
		base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	else {
		System.out.println("Enter Valid Browser Name");
	}
	base.driver.get(url);
	
	LoginPage loginepage = base.loginpage=new LoginPage(base.driver);
	loginepage.loginToApp(username, password);
	}
	
	@After()
	public void LogoutVtiger(Scenario scenario) {
		
		if(scenario.isFailed()) {
			
		}
		
	base.driver.quit();
	}
	
	
}
