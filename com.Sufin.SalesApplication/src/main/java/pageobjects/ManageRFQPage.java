package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericlibrary.BaseClass;

public class ManageRFQPage extends BaseClass{
	public ManageRFQPage(WebDriver driver) {
		this.driver=driver;
	}
	
  @FindBy(xpath = "//span[contains(.,' Manage your RFQs ')]")
  private WebElement ManageRFQLink;
 
  
}
