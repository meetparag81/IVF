package com_Smile_Test;

import org.testng.annotations.Test;

import com_Smile_Base.TestBase;

import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Smile_Excelutility.Exls_Reader;
import com_Smile_POM.EMRDashBoardPage;
import com_Smile_POM.HomePage;
import com_Smile_POM.Loginpage;
import com_Smile_util.TestUtil;

public class HomePageTest extends TestBase
{
	Loginpage Loginpage;	
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Smile Baby IVF\\IVF\\IVFmilan\\src\\main\\java\\com_Smile_TestData\\Milandata.xlsx");
	
	HomePageTest()
	{
		super();
	}
	@BeforeMethod
	public void Setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1,enabled=false)
	public void DatacreationTest() 
	{
		int Actualrows= HomePage.PatientDataCreation();
		int Expected = reader.getRowCount("HomePage");
		Assert.assertEquals(Actualrows, Expected);
	}
		
@ Test(priority=4)
			
	public void ClickOnCmrTest() 
	{
		EMRPage= HomePage.ClickonEMR();
		String Actual= HomePage.EMRPageTitle();
		String Expected = "EMR Dashboard";
		Assert.assertEquals(Actual, Expected);
		System.out.println( "patient ClickOnCmrTest is completed");
		
	}
@ Test(priority=3)

public void SearchPatientUsingCalenderTest() 
{
	HomePage.SearchusingCalender();
	String Actual=	HomePage.Dahboardtitle();
	String Expectted = "EMR Dashboard";
	Assert.assertEquals(Actual, Expectted);
	System.out.println("search patient through Searchbox is completed");
}
@Test(priority=2)
private void SearchPatientUsingPatientTabTest() 
{
	HomePage.searchPaient();
	String Actual=	HomePage.Dahboardtitle();
	String Expectted = "EMR Dashboard";
	System.out.println("search patient test completed");
	
}



@AfterMethod
public void teardown()
{
	
	try
	{
	driver.quit();
	}
	catch(UnreachableBrowserException e)
	{
		System.out.println("UnreachableBrowserException is seen at-HomePageTest ");
	}
}
	
	
	
}
