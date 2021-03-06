package com_Smile_Test;

import org.testng.annotations.Test;

import com_Smile_Base.TestBase;

import org.testng.AssertJUnit;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Smile_Excelutility.Exls_Reader;
import com_Smile_POM.EMRDashBoardPage;
import com_Smile_POM.HomePage;
import com_Smile_POM.Loginpage;
import com_Smile_POM.WPastMedicationHistoryPage;
import com_Smile_POM.WomenHistoryPage;
import com_Smile_util.TestUtil;

public class WPastMedicationHistoryTest extends TestBase
{
	Loginpage Loginpage;
	HomePage HomePage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	WPastMedicationHistoryPage PMHP;
	Exls_Reader reader = new Exls_Reader("C:\\Parag\\Smile Baby IVF\\IVF\\IVFmilan\\src\\main\\java\\com_Smile_TestData\\Milandata.xlsx");
	
	
	WPastMedicationHistoryTest()
	{
		super();	}
	@BeforeMethod
	public void Setup() 
	{
	TestBase.initalization();
	Loginpage= new Loginpage();
	HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
	//EMRPage=HomePage.SearchusingCalender();
	//EMRPage= HomePage.ClickonEMR();
	EMRPage = HomePage.searchPaient();
	WHP= EMRPage.clickOnWomenField();
	PMHP=WHP.ClickOnpastMedicationHistory();
	}
	
	@Test(priority=1)
	public void DrugNameTest() 
	{
		//PMHP.DrugName();
		String Actual = PMHP.DrugName();
		String Expected = "ADAPALENE";  //PMHP.drugexpected();
		Assert.assertEquals(Actual, Expected, "Stringdoen't matched");
		System.out.println("testcase DrugNameTest is completed");
	}
	@Test(priority=2)
	public void DrugNameFieldEnableconditionTest() 
	{
		PMHP.DrugName();
		boolean flag = PMHP.DrugNameFieldEnablecondition();
		Assert.assertFalse(flag);
		System.out.println("DrugNameFieldEnableconditionTest is completed");
		
	}
	@Test(priority=3,enabled=true)
	public void pastMedicationHistorysetdataTest() 
	{
		int Actual= PMHP.pastMedicationHistorysetdata();
		List<WebElement>searchbox1= driver.findElements(By.xpath("(//ul[@role='listbox'])[3]//a"));
		int Expected = searchbox1.size();
		Assert.assertEquals(Actual, Expected);
		
	}
	@AfterMethod
	public void Teardown()
	{
		try
		{
		driver.quit();
		}
		catch(UnreachableBrowserException e)
		{
			System.out.println("UnreachableBrowserException is seen at-PastMedicationHistoryPageTest ");
		}
	}
	
	
	
	
	
	
}
