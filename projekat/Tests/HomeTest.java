package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.Home;

public class HomeTest {

	private static WebDriver driver;

	@BeforeClass
	public void CreateDriver() {
		System.setProperty("webdriver.firefox.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		// WebDriverWait wait = new WebDriverWait(driver, 5);

	}

	@AfterClass
	public void CloseDriver() {
		driver.close();
	}

	@Test
	public void SummerDressFromWomen() {
		driver.get(Home.SHOPHOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Home.GoToSummerDresses_Women(driver);

		String p1 = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(p1, expectedUrl);
	}

	@Test
	public void SummerDressFromDress() {
		driver.get(Home.SHOPHOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Home.GoToSummerDresses_Dresses(driver);

		String p2 = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertEquals(p2, expectedUrl);
	}

	@Test
	public void z_compareURLs() {
		driver.get(Home.SHOPHOME_URL);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Home.GoToSummerDresses_Dresses(driver);
		String t1 = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Home.GoToSummerDresses_Women(driver);
		String t2 = driver.getCurrentUrl();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(t1, t2);
		sa.assertAll();
	}

}
