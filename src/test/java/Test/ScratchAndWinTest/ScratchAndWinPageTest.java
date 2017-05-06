package Test.ScratchAndWinTest;


import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Pages.ScratchAndWin.ScratchAndWin;
import Pages.ScratchAndWin.ScratchAndWinPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ScratchAndWinPageTest extends BaseTest{
    private ScratchAndWin scratchAndWin;
    private HomePage homePage;
    private LoginPage loginPage;
    private ScratchAndWinPage scratchAndWinPage;

    protected void createObjects(){
        scratchAndWin = ScratchAndWinPageData.getScratchAndWin();
    }
    protected void initializeMembers(){
        homePage = new HomePage(webDriver);
        loginPage = new LoginPage(webDriver);
        scratchAndWinPage = new ScratchAndWinPage(webDriver);
    }
    protected void openPage(){
        loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openScratchAndWin();
        assertTrue(scratchAndWinPage.isVisible());
    }
    @Test(priority = -1)
    void createScratchAndWin(){
        scratchAndWinPage.setScratchAndWin(scratchAndWin);
        homePage.openJoinUs();
        assertTrue(homePage.isVisible());
        homePage.openScratchAndWin();
        assertTrue(scratchAndWinPage.isVisible());
        assertEquals(scratchAndWinPage.getPrice(),scratchAndWin.getPrice());
        //assertEquals(scratchAndWinPage.getImages(),scratchAndWin.getImages());
    }
    @Test
    void validatePriceFieldIsNotEmpty(){
        scratchAndWinPage.setImages(scratchAndWin.getImages());
        scratchAndWinPage.clearPriceField();
        scratchAndWinPage.finish();
        assertTrue(scratchAndWinPage.isVisible());
        homePage.openJoinUs();
        assertTrue(homePage.isVisible());
        homePage.openScratchAndWin();
        assertTrue(scratchAndWinPage.isVisible());
        assertEquals(scratchAndWinPage.getPrice(),scratchAndWin.getPrice());
    }
    @Test
    void validateImageFieldIsNotEmpty(){
        scratchAndWinPage.setPrice(scratchAndWin.getPrice());
        scratchAndWinPage.clearImageField();
        scratchAndWinPage.finish();
        assertTrue(scratchAndWinPage.isVisible());
        homePage.openJoinUs();
        assertTrue(homePage.isVisible());
        homePage.openScratchAndWin();
        assertTrue(scratchAndWinPage.isVisible());
        assertEquals(scratchAndWinPage.getImages().size(),9);
    }
   // @Test
    void validateRightImageCount(){
        scratchAndWinPage.setScratchAndWin(scratchAndWin);
        assertEquals(scratchAndWinPage.getImages().size(),9);
        scratchAndWinPage.removeImage();
        scratchAndWinPage.finish();
        assertTrue(scratchAndWinPage.isVisible());
        homePage.openJoinUs();
        assertTrue(homePage.isVisible());
        homePage.openScratchAndWin();
        assertTrue(scratchAndWinPage.isVisible());
        assertEquals(scratchAndWinPage.getImages().size(),9);
    }
}
