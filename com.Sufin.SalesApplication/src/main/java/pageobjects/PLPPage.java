package pageobjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import genericlibrary.BaseClass;

public class PLPPage extends BaseClass{
	WebDriver driver;
	public PLPPage() {}
	public PLPPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
   @FindBy(xpath = "//img[@class='img-fluid']/../../../div[2]//h3[text()=' Ceiling Fans 3 Blades Brown 1200 mm ']")
   private WebElement CellingFan;
   
   @FindBy(id="del-pincode")
   private WebElement Pincode;
   
   @FindBy(xpath = "//button[text()='Check']")
   private WebElement checkBtn;
   
   @FindBy(xpath = "//button[text()='Add To Cart']")
   private WebElement AddtoCart;
   
   @FindBy(xpath = "//h4[contains(.,' Product added successfully. ')]")
   private WebElement CartTextVerified; 
   
   @FindBy(xpath = "//button[contains(.,' OK ')]")
   private WebElement OkPopup;
   
   @FindBy(xpath = "//img[@class='cart-icon d-none d-lg-inline-block']")
   private WebElement CartIcon;
   
   @FindBy(xpath = "//label[text()='Ceiling Fans 3 Blades Brown 1200 mm']")
   private WebElement CellingFanVerify;
   
   @FindBy(xpath = "//button[text()='Checkout']")
   private WebElement CheckOut;
   
   @FindBy(xpath = "//div[@class='add-shipping-address-btn']/button[@id='hideShowShippingAddressClickBtn']")
   private WebElement AddAddress;
   
   @FindBy(xpath = "//div[@class='add-new-address-container']")
   WebElement NewAddAddress;
   
   @FindBy(xpath = "//button[text()='Buy Now']")
   private WebElement BuyNow;
   
   @FindBy(xpath = "//button[text()='Continue']")  //button[text()='Confirm']
   private WebElement Continue;
   
   @FindBy(xpath = "//button[text()='Place Order']")
   private WebElement PlaceOrder;
   
   @FindBy(xpath = "//a[text()='Remove Product']")
   private WebElement RemoveOrder;
   
   @FindBy(xpath = "//button[text()='OK']")
   private WebElement OkBtn;
   
   @FindBy(xpath = "//h1[contains(.,' Your Cart is Empty')]")
   private WebElement EmptyCart;
 
   
   public void AddtoCart() throws Throwable{
	  CellingFan.click();
	  Thread.sleep(3000);	  
	  ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());

	   driver.switchTo().window(tabs.get(1));
	   
	   Pincode.click();
	   Pincode.clear();
	   Pincode.sendKeys("560029");
	   checkBtn.click();
	   Thread.sleep(2000);
	   AddtoCart.click();
	   OkPopup.click();
	   Thread.sleep(3000);
	   CartIcon.click();
	   CellingFanVerify.isDisplayed();
	   System.out.println("Added Product in cart is Present and Verified");
	   
	   
//	   js.executeScript("arguments[1].click();", checkBtn);
//	   js.executeScript("window.scrollBy(0,450);");
//	   webUtil.waitForElementTobeClickable(driver, AddtoCart);
//	   String URL = driver.getCurrentUrl();
//	   System.out.println(URL);
	   
	   //JavascriptExecutor js = (JavascriptExecutor) driver;
	  // Assert.assertEquals( URL,"https://demo.lntsufin.com/buyer/#/search/product/Ceiling-Fans-3-Blades-Brown-1200-mm/16100-837\"");
	   //js.executeScript("window.scrollBy(0,450)");
	   //js.executeScript("arguments[1].click();", AddtoCart);
	   
	  // BuyNow.click();
	  // Assert.assertEquals(CartTextVerified.getText(),"Product added successfully");
   }   
   public void CheckoutSTP() throws Throwable {
	   CartIcon.click();
	   CheckOut.click();
	   Thread.sleep(3000);
	   webUtil.singleClickAction(driver, AddAddress);
//	   JavascriptExecutor js = (JavascriptExecutor) driver;
//	   js.executeScript("arguments[1].click();", AddAddress);
	  // webUtil.waitForElementTobeClickable(driver, AddAddress);
	  // AddAddress.click();
	   Thread.sleep(4000);
	   Continue.click();
	   Continue.click();
	   PlaceOrder.click();
	   Continue.click();
	   System.out.println("Added Product to cart is Successfully Orderdered and New RFQ Id Generated");
   }
   public void removeOders() {
	   RemoveOrder.click();
	   OkBtn.click();
	   EmptyCart.isDisplayed();
	   System.out.println("Added Product to cart is Successfully Removed from Cart and Verified");
   }
}
