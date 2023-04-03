package create_rft;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import genericlibrary.BaseClass;
import genericlibrary.ListnerClass;
import pageobjects.DashBoardPage;
import pageobjects.HomePage;
import pageobjects.PLPPage;


@Listeners(genericlibrary.ListnerClass.class)
public class TestCases extends BaseClass {
//	LoginPage lg;

	// @Test
//  public void Login() {
//	  lg=new LoginPage(driver);
//  lg.LoginMethod(propUtility.getEmail(), propUtility.getPassword());
//	  }
	
	
	private HomePage hg;
	private PLPPage pl;
	private DashBoardPage db;

	/*       CREATE NEW RFQ FLOW   */
   // @Test(retryAnalyzer = genericlibrary.RetryAnalyser.class)
	public void CreateNewRFQ() throws Throwable {
		hg = new HomePage(driver);
		hg.NewRFQ("Demo123", "O rings");
	}
    /*         NAVIGATING TO WHATSAPP URL    */
//	 @Test(retryAnalyzer = genericlibrary.RetryAnalyser.class)
	public void ClickOnWhatsapp() {
		hg = new HomePage(driver);
//		Assert.assertTrue(false);
		hg.whatsappMethod();
	}

	
	/*        ADD A PRODUCT TO CART   */
	// @Test
	public void CartVerification() throws Throwable {
		pl = new PLPPage(driver);
		pl.AddtoCart();
	}
 
	
	/*         CHECKOUT A PRODUCT FROM CART   */
	 @Test
	public void STPProduct() throws Throwable {
		pl = new PLPPage(driver);
		pl.AddtoCart();
		pl.CheckoutSTP();
	}
	
	/*         REMOVE A PRODUCT FROM CART   */
	@Test
	 public void RemoveFromCart() throws Throwable {
			pl = new PLPPage(driver);
			pl.AddtoCart();
			pl.removeOders();
		}
	 @Test
	public void DownloadOrderDetails() throws Throwable {
		db=new DashBoardPage(driver);
		db.DashBoardAction();
	}
	
}
	
