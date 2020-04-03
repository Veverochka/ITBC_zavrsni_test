package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.EData;
import web.Log;

public class E_Test {
	private static WebDriver driver;

	@BeforeClass
	public void CreateDriver() {
		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 5);

	}

	@AfterClass
	public void CloseDriver() {
		driver.close();
	}

	@Test
	public void AddUser() {
	

		for (int i = 4; i <= 5; i++) {

			driver.get(Log.LOGIN_URL);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			EData.CreateAcc(driver, i);
			EData.FillForm(driver, i);
			EData.clickRegister(driver);
			EData.clickSignOut(driver);
			
			String title1 = driver.getTitle();
			String title2 = Log.MY_ACC_TITLE;
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(title1, title2);
			sa.assertAll();
		}
		
	}
	
	public void testLogInUser() {
		
		for (int i = 4; i <= 5; i++) {
		driver.get(Log.LOGIN_URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		EData.clickSignIn(driver, i);
		EData.clickSignOut(driver);
		
		String title1 = driver.getTitle();
		String title2 = Log.MY_ACC_TITLE;
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(title1, title2);
		sa.assertAll();
	}
	}
	
}