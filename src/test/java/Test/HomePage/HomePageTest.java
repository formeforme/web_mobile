package Test.HomePage;

import Pages.Categories.CategoriesPage;
import Pages.HBBusiness.HBBusinessPage;
import Pages.HomePage.HomePage;
import Pages.JoinUs.JoinUsPage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;

import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;


public class HomePageTest extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;

    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
    }
    protected void openPage(){
        loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
    }
    @Test
    void openCategoryPage(){
        CategoriesPage page = homePage.openCategories();
        assertTrue(page.isVisible());
    }
    @Test
    void openHBBusinessPage(){
        HBBusinessPage page = homePage.openHBBusiness();
        assertTrue(page.isVisible());
    }
    @Test
    void openJoinUsPage(){
        JoinUsPage page = homePage.openJoinUs();
        assertTrue(page.isVisible());
    }
    @Test
    void openScratchAndWinPage(){
        //ScratchAndWinPage page = homePage.openScratchAndWin();
        //assertTrue(page.isVisible());
    }
    @Test
    void validateLogoutWorks(){
        LoginPage page = homePage.logout();
        assertTrue(page.isVisible());
    }
}
