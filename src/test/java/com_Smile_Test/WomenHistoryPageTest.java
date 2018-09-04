package com_Smile_Test;

import org.testng.annotations.Test;

import com_Smile_Base.TestBase;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com_Smile_POM.AddictionsPage;
import com_Smile_POM.AllergiesPage;
import com_Smile_POM.EMRDashBoardPage;
import com_Smile_POM.FamilyHistoryPage;
import com_Smile_POM.HomePage;
import com_Smile_POM.Loginpage;
import com_Smile_POM.ObstetricHistoryPage;
import com_Smile_POM.SearchPage;
import com_Smile_POM.SexualHistoryPage;
import com_Smile_POM.SurgicalHistoryPage;
import com_Smile_POM.VaccinationPage;
import com_Smile_POM.WPastMedicationHistoryPage;
import com_Smile_POM.WomenHistoryPage;
import com_Smile_POM.previousTreatmentHistoryPage;
import com_Smile_POM.socialHistoryPage;

public class WomenHistoryPageTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	FamilyHistoryPage FHP;
	SexualHistoryPage SHP;
	SurgicalHistoryPage SurgicalPage;
	previousTreatmentHistoryPage PTHP;
	WPastMedicationHistoryPage PMH;
	AllergiesPage Allergies;
	AddictionsPage Addictions;
	VaccinationPage Vaccination;
	socialHistoryPage socialHistory;
	SearchPage SearchPage;
	ObstetricHistoryPage OHP;
	
	public WomenHistoryPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setup() 
	{
		TestBase.initalization();
		Loginpage= new Loginpage();
		HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
		EMRPage= HomePage.searchPaient();
		WHP= EMRPage.clickOnWomenField();	
	}
	
	@Test(priority=1,enabled= true)
	public void SexualHistoryTest() 
	{
		SHP= WHP.ClickonSexsuslHistory();
	}
	
	@Test(priority=2,enabled= true)
	public void ObstetricHistoryTest() 
	{
		OHP= WHP.ClickonObstetricHistory();
	}
	@Test(priority=3,enabled= true)
	public void MedicalHistoryTest() throws Throwable
	{
		WHP.ClickonMedicalHistory();
	}
	
	@Test(priority=4,enabled= true)
	public void FamilyHistoryTest () 
	{
		WHP.ClicOnFamilyHistory();
	}
	
	@Test(priority=5,enabled= true)
	public void SurgicalHistoryTest () 
	{
		WHP.ClickOnSurgicalHistory();
	}
	
	@Test(priority=6,enabled= true)
	public void PreviousTreatmentHistoryTest() 
	{
		PTHP= WHP.ClickOnpreviousTreatmentHistory();
	}
	@Test(priority=7,enabled= true)
	public void pastMedicationHistoryTest() 
	{
		PMH= WHP.ClickOnpastMedicationHistory();
	}
	
	@Test(priority=8)
	public void AllergiesTest() 
	{
		Allergies= WHP.ClickOnAllergies();
	}
	
	@Test(priority=9)
	public void AddictionsTest() 
	{
		Addictions= WHP.ClickOnAddictions();
	}
	@Test(priority=10)
	public void VaccinationTest() throws Exception
	{
		Vaccination = WHP.ClickOnVaccination();
	}@Test(priority=11)
	public void socialHistoryTest() 
	{
		socialHistory = WHP.ClickOnsocialHistory();
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
			System.out.println("UnreachableBrowserException is seen at-WomenHistoryPageTest ");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
