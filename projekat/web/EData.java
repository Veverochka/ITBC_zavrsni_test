package web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class EData {

	private static XSSFWorkbook wb;

	public static String getData(int i, int j) {
		FileInputStream fis;

		try {
			fis = new FileInputStream("People.xlsx");
			wb = new XSSFWorkbook(fis);
			return wb.getSheetAt(0).getRow(i).getCell(j).toString();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static void CreateAcc(WebDriver driver, int i) {
		
		String data = getData(i, 3);
		driver.findElement(By.id("email_create")).sendKeys(data);
		//*[@id="email_create"]
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div[1]/form/div/div[3]/button/span"))
				.click();
	}

	public static void FillForm(WebDriver driver, int i) {

		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

		driver.findElement(By.xpath(Log.FirstName_xpath)).sendKeys(getData(i, 1));
		driver.findElement(By.xpath(Log.LAstName_xpath)).sendKeys(getData(i, 2));
		driver.findElement(By.xpath(Log.Pass_xpath)).sendKeys(getData(i, 4));
		driver.findElement(By.xpath(Log.Adress_xpath)).sendKeys(getData(i, 7));
		driver.findElement(By.xpath(Log.City_xpath)).sendKeys(getData(i, 8));

		Select state = new Select(driver.findElement(By.xpath(Log.State_xpath)));
		state.selectByVisibleText(getData(i, 9));

		driver.findElement(By.xpath(Log.Zip_xpath)).sendKeys(getData(i, 10));

		Select country = new Select(driver.findElement(By.xpath(Log.Country_xpath)));
		country.selectByVisibleText(getData(i, 12));

		driver.findElement(By.xpath(Log.Phone_xpath)).sendKeys(getData(i, 11));
		driver.findElement(By.xpath(Log.Alias_xpath)).clear();
		driver.findElement(By.xpath(Log.Alias_xpath)).sendKeys(getData(i, 13));
	}

	public static void clickRegister(WebDriver driver) {
		driver.findElement(By.xpath(Log.REGISTER_BTN_XPATH)).click();
	}

	public static void clickSignOut(WebDriver driver) {
		driver.findElement(By.xpath("//a[@class='logout']")).click();
	}

	public static String clickSignIn(WebDriver driver, int i) {
		driver.get(Home.SHOPHOME_URL);
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(getData(i, 3));
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(getData(i, 4));
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		return driver.getTitle();
	}
}
