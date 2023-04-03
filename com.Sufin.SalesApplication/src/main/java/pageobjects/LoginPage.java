package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   public WebDriver driver;

   public LoginPage(WebDriver driver) {
	   this.driver=driver;
	   PageFactory.initElements( driver,this);
   }
  
   @FindBy(xpath = "//span[text()='Login/Register ']")
   private WebElement LoginOption;
   
   @FindBy(xpath = "//button[contains(.,' Login ')]")
   private WebElement LoginButton;
   
   @FindBy(xpath = "//input[@id='signInName']")
   private WebElement EmailTextField;
   
   @FindBy(xpath = "//button[text()='Continue']")
   private WebElement ContinueButton;
   
   @FindBy(id = "password")
   private WebElement PasswordTextField;
   @FindBy(id = "next")
   private WebElement Signin;
   
   public void LoginMethod(String email,String pwd) throws Throwable {
	   LoginOption.click();
	   LoginButton.click();
	   Thread.sleep(5000);
	   EmailTextField.sendKeys(email);
	   ContinueButton.click();
	   PasswordTextField.sendKeys(pwd);
	   Signin.click();
   }
}
