package Test.FirstPage;


import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class FirstPageTest extends BaseTest{
    private LoginPage loginPage;

    protected void createObjects(){
    }
    protected void initializeMembers(){
        loginPage = new LoginPage(webDriver);
    }
    protected void openPage() {}

    @Test
    void checkTitle(){
        Assert.assertEquals("Hong Bao",webDriver.getTitle());
    }
    @Test
    void validateCorrectPage(){
        Assert.assertTrue(loginPage.isVisible());
    }
}
