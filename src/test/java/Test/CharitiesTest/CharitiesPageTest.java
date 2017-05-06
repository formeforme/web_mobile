package Test.CharitiesTest;

import Pages.Charities.AddCharityPage;
import Pages.Charities.CharitiesPage;
import Pages.Charities.CharityPage;
import Pages.Charities.Charity;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CharitiesPageTest extends BaseTest{
    private Charity charity;
    private LoginPage loginPage;
    private CharitiesPage charitiesPage;

    protected void createObjects(){
        charity = CharitiesPageData.getCharity();
    }
    protected void initializeMembers(){
        loginPage = new LoginPage(webDriver);
        charitiesPage = new CharitiesPage(webDriver);
    }
    protected void openPage(){
        HomePage homePage = loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openCharity();
        assertTrue(charitiesPage.isVisible());
    }
    @Test(priority = -1)
    private void validateCreateWorks(){
        AddCharityPage addPage = charitiesPage.createCharity();
        assertTrue(addPage.isVisible());
        addPage.addCharity(charity);
        assertTrue(charitiesPage.isVisible());
        assertTrue(charitiesPage.searchCharity(charity.getName()));
    }
    @Test(priority = 1)
    private void validateDeleteWorks(){
        assertTrue(charitiesPage.searchCharity(charity.getName()));
        while(charitiesPage.searchCharity(charity.getName())){
            charitiesPage.deleteCharity(charity.getName());
        }
        assertFalse(charitiesPage.searchCharity(charity.getName()));
    }
    @Test
    private void validateSearchWorks(){
        assertTrue(charitiesPage.searchCharity(charity.getName()));
    }
    @Test
    private void validateOpenWorks(){
        String name = charity.getName();
        assertTrue(charitiesPage.searchCharity(name));
        CharityPage charityPage = charitiesPage.openCharity(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
    }
    //@Test//(dataProvider = "NTData", dataProviderClass = CharitiesPageData.class)
    private void validateNoWrongInputsAdd(){
        AddCharityPage addPage = charitiesPage.createCharity();
        assertTrue(addPage.isVisible());
        addPage.addCharity(charity);
        assertTrue(addPage.isVisible());
    }
    @Test
    private void validateEditWorks(){
        String oldName = charity.getName();
        String newName = charity.getName()+charity.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            CharityPage charityPage = charitiesPage.openCharity(oldName);
            assertTrue(charityPage.isVisible());
            AddCharityPage editPage = charityPage.edit();
            assertTrue(editPage.isVisible());
            editPage.clearNameField();
            editPage.setName(newName);
            editPage.saveChanges();
            assertTrue(charitiesPage.isVisible());
            assertTrue(charitiesPage.searchCharity(newName));
            newName = oldName;
            oldName = name;
        }
    }

    @Test
    private void validateRightEditPageOpened(){
        String name = charity.getName();
        CharityPage charityPage = charitiesPage.openCharity(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
        AddCharityPage addPage = charityPage.edit();
        assertTrue(addPage.isVisible());
        assertEquals(addPage.getName(),name);
    }
    @Test
    void validateRightTitle(){}
}
