package genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.LogoutPage;

public class BaseClass {
  public WebDriver driver;
  public PropertyFileUtility propUtility=new PropertyFileUtility();
  public JavaUtility jUtil=new JavaUtility();
  public WebdriverUtility webUtil=new WebdriverUtility();
  public static WebDriver sdriver;
  public LoginPage lg;
  public LogoutPage lo;
  public String browser;

  @BeforeClass
  public void startUp() {
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--disable-notifications");
	  browser = propUtility.getBrowser();
	  
	  if(browser.equalsIgnoreCase("chrome")) {
		
		  System.setProperty("webdriver.chrome.driver","./src/java/resources/chromedriver.exe");
		  driver=new ChromeDriver(options);
		  
	  }else if(browser.equalsIgnoreCase("edge")){
		  System.setProperty("webdriver.edge.driver","./src/java/resources/msedgedriver.exe");
		  driver=new EdgeDriver();
	  }else
		  System.out.println("Only chrome browser is exist"+browser);
	      Reporter.log("Only chrome browser is exist "+browser);
	  sdriver=driver;
	  System.out.println(browser+" Browser is Successfully Launched");
	  Reporter.log(browser+" Browser is Successfully Launched");
	  webUtil.maximizeWindow(sdriver);
	  webUtil.waitforPageToLoad(sdriver);
	  driver.get(propUtility.getBaseURL());  
  }
 
  
  @BeforeMethod
  public void Login() throws Throwable
  {
	  lg=new LoginPage(driver);
	  lg.LoginMethod(propUtility.getEmail(), propUtility.getPassword()); 
	  System.out.println("Successfully Logged-in");
  }
  //@AfterMethod
  public void Logout() {
	  lo=new LogoutPage(driver);
	  lo.LogoutForApplication();
	  System.out.println("Successfully Logged-Out");
  }
 // @AfterClass
  public void tearDown() {
	  driver.quit();
	  System.out.println(browser+" Browser is Successfully closed");
	  Reporter.log(browser+" Browser is Successfully closed");
  }
  
}
