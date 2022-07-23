package StepDefinationsAndHook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Basess.Base;
import bdd.PomPages.CreateNewOrganizationPage;
import bdd.PomPages.HomePage;
import bdd.PomPages.LoginPage;
import bdd.PomPages.OrganizationInfoPage;
import bdd.PomPages.OrganizationsPage;
import bdd.genericUtility.PropertyUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateOrgSteps extends Base {
	Base base;
	
	public CreateOrgSteps(Base base) {
	this.base=base;
	}

	
	@When("Home page is displayed click on org link")
	public void home_page_is_displayed_click_on_org_link() {
	   HomePage homepages = base.homepage=new HomePage(base.driver);
	   homepages.clickOnOrgLnk();
		
	}
	@When("In organizations page click on create new org image")
	public void in_organizations_page_click_on_create_new_org_image() {
		OrganizationsPage orgPage = base.organizationsPage=new OrganizationsPage(base.driver);
		orgPage.clickOnCreateOrgImg();
	}
	@When("In create new organization page enter madatory fields and click on save button")
	public void in_create_new_organization_page_enter_madatory_fields_and_click_on_save_button() {
	 CreateNewOrganizationPage createnewOrgPage = base.createneworganizationpage=new CreateNewOrganizationPage(base.driver);
	 createnewOrgPage.createNewOrg("BDDGoogle");
	 
	}
	@Then("Verify orgis created or not")
	public void verify_orgis_created_or_not() {
	    OrganizationInfoPage orginfopage = base.organizationinfopage=new OrganizationInfoPage(base.driver);
	    String actualOrgName = orginfopage.OrgNameInfo();
	    Assert.assertTrue(actualOrgName.contains("BDDGoogle"));
	
	}
}
