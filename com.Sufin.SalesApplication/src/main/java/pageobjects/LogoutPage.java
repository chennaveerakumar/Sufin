package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    public WebDriver driver;
    public LogoutPage() {}
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@role='button']")
	private WebElement Profile;
    @FindBy(xpath = "//span[@class='dropdown-item nohover']/span[text()='Logout ']")
    private WebElement LogoutOption;
    @FindBy(xpath = "//button[text()='OK']")
    private WebElement OkBtn;
    public void LogoutForApplication() {
    	Profile.click();
    	LogoutOption.click();
    	OkBtn.click();
    }
    
    
}
