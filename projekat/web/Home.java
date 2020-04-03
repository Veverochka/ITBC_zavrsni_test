package web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home {

	public static String SHOPHOME_URL = "http://automationpractice.com/index.php";

	public static String WOMEN_BTN_XPATH = "//a[@class='sf-with-ul'][contains(text(),'Women')]";
	// /html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a";
	public static String SD_WOMEN_BTN_XPATH = "//li[@class='sfHover']//ul//li//a[contains(text(),'Summer Dresses')]";
	// "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/ul/li[2]/ul/li[3]/a";

	public static String DRESSES_BTN_XPATH = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a";
	// "//li[@class='sfHover']//a[@class='sf-with-ul'][contains(text(),'Dresses')]";
	public static String SD_DRESS_BTN_XPATH = "//li[@class='sfHover']//ul[@class='submenu-container clearfix first-in-line-xs']//li//a[contains(text(),'Summer Dresses')]";
	// /html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/ul/li[3]/a";

	public static void GoToSummerDresses_Women(WebDriver driver) {
		WebElement w = driver.findElement(By.xpath(WOMEN_BTN_XPATH));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.moveToElement(w).perform();
		driver.findElement(By.xpath(SD_WOMEN_BTN_XPATH)).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	public static void GoToSummerDresses_Dresses(WebDriver driver) {
		Actions actions = new Actions(driver);
		WebElement d = driver.findElement(By.xpath(DRESSES_BTN_XPATH));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		actions.moveToElement(d).perform();
		driver.findElement(By.xpath(SD_DRESS_BTN_XPATH)).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
}

/*
 * ovo je metoda sa klikom na linkove... public static String
 * GoToSummerDresses_Dresses(WebDriver driver) { // klik na btn
 * driver.findElement(By.xpath(DRESSES_BTN_XPATH)).click(); try {
 * Thread.sleep(1000); } catch (InterruptedException e) { // TODO Auto-generated
 * catch block e.printStackTrace(); }
 * driver.findElement(By.xpath(SD_DRESS_BTN_XPATH)).click();
 * driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS); return
 * driver.getCurrentUrl(); }
 */
