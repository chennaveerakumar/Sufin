package pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import genericlibrary.BaseClass;
import genericlibrary.WebdriverUtility;


public class HomePage extends BaseClass{
	WebDriver driver;
	
	public HomePage() {}
	public  HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
  @FindBy(xpath = "//span[@title='Request for Quote']")
  private WebElement RFQ;
  @FindBy(xpath = "//h5[contains(.,' Create New RFQ ')]/../../div/div/input[@type='radio']")
  private WebElement RadioButton;
  
  @FindBy(xpath = "//button[text()=' Proceed ']")
  private WebElement ProceedFirst;
  
  
  @FindBy(xpath = "//textarea[@placeholder='Please enter here RFQ name']")
  private WebElement RFQName;
  
  @FindBy(xpath = "(//button[@id='proceedbtn']")
  private WebElement ProceedSecond;
  
  @FindBy(css = "input[id='searchFilter']")
  private WebElement AddProductTextField;
  
  @FindBy(xpath = "//a[contains(.,' O Rings ')]")
  private WebElement SearchedPrd;
  
  @FindBy(xpath = "//button[text()='Add']")
  private WebElement AddProduct;
  
  @FindBy(xpath = "/html/body/buyer-root/div/buyer-header/section/header/div[2]/nav/div[2]/a/img")
  private WebElement whatsapp;
  
  @FindBy(css = "input[placeholder='Enter product name here...']")
  private WebElement Searchfield;
  
  @FindBy(id = "searchFilter5")
  private WebElement SellerSearch;

  public void NewRFQ(String PassName,String PassPrd) throws Throwable {
	 // webUtil.waitForElementTobeVisible(driver, RFQ);
	  Thread.sleep(5000);
	  RFQ.click();
	  Thread.sleep(5000);
	  RadioButton.click();
	  ProceedFirst.click();
	  RFQName.sendKeys(PassName);
	  Thread.sleep(3000);
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,320);");
	  ProceedSecond.click();
	  AddProductTextField.click();
	  SearchedPrd.sendKeys(PassPrd);
	  AddProduct.click();
	  ProceedSecond.click(); 
  }
     public void whatsappMethod() {
    	whatsapp.click();
    	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
 	    driver.switchTo().window(tabs.get(1));
    	Assert.assertEquals(driver.getCurrentUrl(),"https://api.whatsapp.com/send?phone=918291912192&text=Hi");
     }
     
  
  
  
}
