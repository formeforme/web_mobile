package Test.MerchantsPage;

import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Pages.MerchantsPage.AddEditMerchantPage;
import Pages.MerchantsPage.AllMerchantsPage;
import Pages.MerchantsPage.Merchant;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class AllMerchantsPageTest extends BaseTest {
    private Merchant merchant;
    private LoginPage loginPage;
    private AllMerchantsPage allMerchantsPage;

    protected void createObjects(){
        merchant = AllMerchantsPageData.getMerchant();
    }
    protected void initializeMembers(){
        loginPage = new LoginPage(webDriver);
        allMerchantsPage = new AllMerchantsPage(webDriver);
    }
    protected void openPage(){
        HomePage homePage = loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openAllMerchants();
        assertTrue(allMerchantsPage.isVisible());
    }
 //   @Test
    void createMerchant(){
        AddEditMerchantPage addPage = allMerchantsPage.createMerchant();
        addPage.setID("okkkkkkk");
        System.out.println(">>>>>>>>"+addPage.getID());
    }
 //   @Test
    void openMerchant(){
        allMerchantsPage.openMerchant("HBM-HKG-17-03-00004 (Pure Green Dance)");
    }
}
