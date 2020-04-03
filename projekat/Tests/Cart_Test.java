package Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import web.Cart;
import web.Log;

public class Cart_Test {

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
	public void a_AddDressToCart() {
		Cart.AddDressToCart(driver);

		String u1 = driver.getCurrentUrl();
		String u2 = Cart.OpenCart_url(driver);
		Assert.assertEquals(u1, u2);
	}

	@Test
	public void b_checkCart() {
		Cart.OpenCart(driver);

		String expectedUrl = "http://automationpractice.com/index.php?id_product=5&controller=product#/size-m/color-blue";

		WebElement img = driver
				.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[1]/a"));
		String ImageUrl = img.getAttribute("href");

		WebElement description = driver
				.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]"));
		String DescUrl = description.getAttribute("href");

		WebElement sizeColor = driver
				.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(),'Color : Blue, Size : M')]"));
		String SizeColor = sizeColor.getAttribute("href");

		WebElement qty = driver.findElement(By.xpath("//input[@name='quantity_5_24_0_0']"));
		String Qty = qty.getAttribute("value");

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(ImageUrl, expectedUrl);
		sa.assertEquals(DescUrl, expectedUrl);
		sa.assertEquals(SizeColor, expectedUrl);
		sa.assertEquals(Qty, "2");
		sa.assertAll();

	}

	@Test
	public void c_Proceed() {
		driver.findElement(By.xpath(Log.PROCEED_XPATH)).click();
		String currentUrl = driver.getCurrentUrl();

		String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";

		Assert.assertEquals(currentUrl, expectedUrl);
	}

}
