package com_Smile_Test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;

import com_Smile_Base.TestBase;
import com_Smile_POM.EMRDashBoardPage;
import com_Smile_POM.FamilyHistoryPage;
import com_Smile_POM.HomePage;
import com_Smile_POM.Loginpage;
import com_Smile_POM.SexualHistoryPage;
import com_Smile_POM.SurgicalHistoryPage;
import com_Smile_POM.WomenHistoryPage;
import com_Smile_util.TestUtil;

public class WFamilyHistoryTest extends TestBase
{
	HomePage HomePage;
	Loginpage Loginpage;
	EMRDashBoardPage EMRPage;
	WomenHistoryPage WHP;
	FamilyHistoryPage FHP;
	SexualHistoryPage SHP;
	SurgicalHistoryPage SurgicalPage;

	public WFamilyHistoryTest()
	{
		super();
	}
	
	@ BeforeMethod
	public void Seup() 
		{
			TestBase.initalization();
			Loginpage= new Loginpage();
			HomePage = Loginpage.Verifylogin(prop.getProperty("username"), prop.getProperty("password"));
			EMRPage= HomePage.searchPaient();
			//EMRPage= HomePage.ClickonEMR();
			WHP= EMRPage.clickOnWomenField();	
		}
}
