package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.Cart;
import web.Log;

public class Log_Test {
	private static WebDriver driver;
	SoftAssert sa = new SoftAssert();


	@BeforeClass
	public void CreateDriver() {
		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	}

	@AfterClass
	public void CloseDriver() {
		driver.close();
	}

	@Test
	public void a_goToCreateAccount() {
		Cart.AddDressToCart(driver);
		driver.findElement(By.xpath(Log.PROCEED_XPATH)).click();
		// driver.get(Log.PROCEED_LOGIN_URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Log.CreateAcc(driver);

		String title1 = driver.getTitle();
		String title2 = Log.ACC_DATA_TITLE;
		sa.assertEquals(title1, title2);
		sa.assertAll();
		
	}

	@Test
	// SignOut vraca na strnicu shopa -
	//expected [Login - My Store] but found [Order - My Store]
	
	public void b_FillAccData() {  
		driver.get(Log.ACCOUNT_DATA_URL);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Log.FillAccDataPage_given(driver);
		Log.clickRegister(driver);
		Log.clickSignOUT(driver);
		Log.SignIN(driver);
		
		
		String title1 = driver.getTitle();
		String title2 = Log.MY_ACC_TITLE;
		sa.assertEquals(title1, title2);
		sa.assertAll();
	}


}
