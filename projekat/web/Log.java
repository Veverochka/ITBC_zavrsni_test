package web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Log {

	public static String PROCEED_XPATH = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]";
	public static String PROCEED_LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
	public static String EMAIL_CREATE_XPATH = "//*[@id=\"email_create\"]";  
	public static String ACCOUNT_DATA_URL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0#account-creation";
	public static String ACC_DATA_TITLE = "Login - My Store";
	public static String LOGIN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	public static String MY_ACC_URL = "http://automationpractice.com/index.php?controller=my-account";
	public static String MY_ACC_TITLE = "My account - My Store";

	public static String REGISTER_URL = "http://automationpractice.com/index.php?controller=my-account";
	public static String REGISTER_TITLE = "My account - My Store";

		
		

	public static String SIGNOUT_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static String SIGNOUT_TITLE = "Login - My Store";

	public static String REGISTER_BTN_XPATH = "//span[contains(text(),'Register')]";
	public static String SINGOUT_XPATH = "//a[@class='logout']";
	// //ul[@class='bullet']//a[contains(text(),'Sign out')]";
	public static String STATUS_BTN = "//ul[@class='bullet']//a[contains(text(),'Sign out')]";

	public static String SINGIN_HOME_BTN_XPATH = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[1]/a";

	public static String EMAIL_LOGIN_XPATH = "//input[@id='email']";
	public static String PASS_LOGIN_XPATH = "//input[@id='passwd']";
	public static String SIGNIN_BTN_XPATH = "/html/body/div/div[2]/div/div[3]/div/div/div[2]/form/div/p[2]/button/span";

	public final static String SIGNIN_XPATH = "//a[@class='login']";
	public final static String SIGNIIN_XPATH = "//p[@class='submit']//span[1]";

	public static String Mr_xpath = "//*[@id=\"id_gender1\"]";
	public static String Mrs_xpath = "//*[@id=\"id_gender2\"]";
	public static String FirstName_xpath = "//*[@id=\"customer_firstname\"]";
	public static String LAstName_xpath = "//*[@id=\"customer_lastname\"]";

	public static String Pass_xpath = "//input[@id='passwd']";
	// private static String Day_xpath = "//select[@id='days']";
	// private static String Month_xpath = "//select[@id='months']";
	// private static String Year_xpath = "//select[@id='years']";
	public static String News_xpath = "//input[@id='newsletter']";
	public static String Spec_xpath = "//input[@id='optin']";
	public static String Adress_xpath = "//input[@id='address1']";
	public static String City_xpath = "//input[@id='city']";
	public static String State_xpath = "//select[@id='id_state']";
	public static String Zip_xpath = "//input[@id='postcode']";
	public static String Country_xpath = "//select[@id='id_country']";
	public static String Phone_xpath = "//input[@id='phone_mobile']";
	public static String Alias_xpath = "//input[@id='alias']";

	// private static String gender;
	private static String name = "Vera";
	private static String surname = "Nikolic";
	private static String mail = "8fd54av2a@mail.com";
	private static String pass = "2020Veve";
	private static String company = "KARE";
	private static String adress = "12 Decanska St";
	private static String city = "Beograd";
	private static String state = "California";
	private static String zip = "11000";
	private static String phone = "011-123-456";
	public static String dob = "1981-1-2";
	public static String country = "United States";
	public static String alias = "alt";

	public static void CreateAcc(WebDriver driver) {
		driver.findElement(By.xpath(EMAIL_CREATE_XPATH)).sendKeys(mail);
		driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();
	}

	public static void FillAccDataPage_given(WebDriver driver) {

		/*
		 * driver.findElement(By.xpath(Mrs_xpath)); gender = gender.toLowerCase(); if
		 * (gender.equals("female")) { driver.findElement(By.xpath(Mrs_xpath)).click();
		 * } else if (gender.equals("male")) {
		 * driver.findElement(By.xpath(Mr_xpath)).click(); }
		 */
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.findElement(By.xpath(FirstName_xpath)).sendKeys(name);

		driver.findElement(By.xpath(LAstName_xpath)).sendKeys(surname);
		driver.findElement(By.xpath(Pass_xpath)).sendKeys(pass);

		String[] date = dob.split("-");
		String year = date[0];
		String month = date[1];
		String day = date[2];
		if (month.charAt(0) == '0') {
			month = Character.toString(month.charAt(1));
		}
		if (day.charAt(0) == '0') {
			day = Character.toString(month.charAt(1));
		}
		Select days = new Select(driver.findElement(By.id("days")));
		days.selectByValue(day);
		Select months = new Select(driver.findElement(By.id("months")));
		months.selectByValue(month);
		Select years = new Select(driver.findElement(By.id("years")));
		years.selectByValue(year);

		driver.findElement(By.xpath(News_xpath)).click();
		driver.findElement(By.xpath(Spec_xpath)).click();

		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(company);
		driver.findElement(By.xpath(Adress_xpath)).sendKeys(adress);
		driver.findElement(By.xpath(City_xpath)).sendKeys(city);

		Select states = new Select(driver.findElement(By.xpath(State_xpath)));
		states.selectByVisibleText(state);

		driver.findElement(By.xpath(Zip_xpath)).sendKeys(zip);
		Select countries = new Select(driver.findElement(By.xpath(Country_xpath)));
		countries.selectByVisibleText(country);
		driver.findElement(By.xpath(Phone_xpath)).sendKeys(phone);
		driver.findElement(By.xpath(Alias_xpath)).clear();
		driver.findElement(By.xpath(Alias_xpath)).sendKeys(alias);

	}

	public static void clickRegister(WebDriver driver) {
		driver.findElement(By.xpath(REGISTER_BTN_XPATH)).click();
	}

	public static void clickSignOUT(WebDriver driver) {
		driver.findElement(By.xpath("//a[@class='logout']")).click();
	}

	public static String SignIN(WebDriver driver) {
		driver.get(Home.SHOPHOME_URL);
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(mail);
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(pass);
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		return driver.getTitle();
	}
}

/*
 * 
 * public static boolean logStatus(WebDriver driver) { String status =
 * driver.findElement(By.xpath(STATUS_BTN)).getText(); if
 * (status.equals("Sign out")) return true; else return false; }
 * 
 * public static void clickSignOut(WebDriver driver) { if (logStatus(driver)) {
 * driver.findElement(By.linkText("Sign out")).click(); } }
 * 
 * public static void SignInFromHome(WebDriver driver) {
 * driver.navigate().to(Home.SHOPHOME_URL);
 * driver.findElement(By.xpath(SINGIN_HOME_BTN_XPATH)).click(); }
 * 
 * public static void FillSignIn(WebDriver driver) { //
 * driver.findElement(By.xpath(SIGNIN_XPATH));
 * driver.findElement(By.xpath(EMAIL_LOGIN_XPATH)).sendKeys(mail);
 * driver.findElement(By.xpath(PASS_LOGIN_XPATH)).sendKeys(pass);
 * driver.findElement(By.xpath(SIGNIN_BTN_XPATH)).click(); }
 * 
 * /* private static void sleep() { try { Thread.sleep(2000); } catch
 * (InterruptedException e) { e.printStackTrace(); } }
 */
