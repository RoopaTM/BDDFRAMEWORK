package Basess;

import org.openqa.selenium.WebDriver;

import bdd.PomPages.CreateNewOrganizationPage;
import bdd.PomPages.HomePage;
import bdd.PomPages.LoginPage;
import bdd.PomPages.OrganizationInfoPage;
import bdd.PomPages.OrganizationsPage;
import bdd.genericUtility.PropertyUtility;
import bdd.genericUtility.WebdriverUtility;

public class Base {

public	WebDriver driver;
public PropertyUtility propertyutility;
public WebdriverUtility webdriverutility;

public LoginPage loginpage;
public HomePage homepage;
public OrganizationsPage organizationsPage;
public CreateNewOrganizationPage createneworganizationpage ;
public OrganizationInfoPage  organizationinfopage;

}