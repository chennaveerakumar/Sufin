package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibrary.BaseClass;

public class DashBoardPage extends BaseClass{
	
    public DashBoardPage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//div[@class='showLoggedin']")
	private WebElement Profile;
    
	@FindBy(xpath = "//span[contains(.,' Buyer Dashboard ')]")
	private WebElement DashBoard;
	
	@FindBy(xpath = "//div[text()='P497-0064']/..//div[5]/ng-component/span/a[text()='View']")
	private WebElement view;
	
	@FindBy(xpath = "//a[text()='Download Order Details']")
	private WebElement ClickOnDownload;
	
	
	public void DashBoardAction() throws Throwable {
		Thread.sleep(3000);
		//webUtil.singleClickAction(driver, Profile);
		//Thread.sleep(3000);
		Profile.click();
		DashBoard.click();
		view.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		ClickOnDownload.click();
		System.out.println("Successfully Document is downloded");
	}
}
