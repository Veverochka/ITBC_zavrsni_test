package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Cart {
	public static String CART_XPATH = "//b[contains(text(),'Cart')]";
	public static String CART_URL = "http://automationpractice.com/index.php?controller=order";
	public static String CART_BTN_XPATH = "//b[contains(text(),'Cart')]";

	public static String SUMMERDRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static String FIRSTDRESS_URL = "http://automationpractice.com/index.php?id_product=5&controller=product";

	// ovo ti treba za ubacivanje u cart
	public static void SelectBlueDress(WebDriver driver) {
		driver.findElement(By.xpath("//a[@id='color_14']")).click(); // plava boja
	}

	public static void SelectSizeM(WebDriver driver) {
		Select size = new Select(driver.findElement(By.id("group_1")));
		size.selectByValue("2");
	}

	public static void SelectQuantity(WebDriver driver) {
		driver.findElement(By.xpath("//a[@class='btn btn-default button-plus product_quantity_up']//span")).click();
	}

	public static void AddDress(WebDriver driver) {
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
	}

	// ovo ti treba za proveru carta
	public static String OpenCart_url(WebDriver driver) {
		driver.findElement(By.xpath("//b[contains(text(),'Cart')]")).click();
		return driver.getCurrentUrl();
	}

	public static void OpenCart(WebDriver driver) {
		driver.findElement(By.xpath("//b[contains(text(),'Cart')]")).click();
	}

	public static void AddDressToCart(WebDriver driver) {
		driver.get(Cart.FIRSTDRESS_URL);
		Cart.SelectBlueDress(driver);
		Cart.SelectSizeM(driver);
		Cart.SelectQuantity(driver);

		Cart.AddDress(driver);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span")).click();
		// driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]"))
		// .findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[1]/span")).click();
		// ovo je da zatvoris popup
		Cart.OpenCart(driver);

	}
}
