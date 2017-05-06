
package Test.JoinUs;

import Pages.HomePage.HomePage;
import Pages.JoinUs.AddEditJoinUsPage;
import Pages.JoinUs.CharityPage;
import Pages.JoinUs.JoinUs;
import Pages.JoinUs.JoinUsPage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class JoinUsTest extends BaseTest {
    private JoinUs joinUs;
    private LoginPage loginPage;
    private JoinUsPage joinUsPage;

    protected void initializeMembers(){
        loginPage = new LoginPage(webDriver);
        joinUsPage = new JoinUsPage(webDriver);
    }
    protected void openPage(){
        HomePage homePage = loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openJoinUs();
        assertTrue(joinUsPage.isVisible());
    }
    protected void createObjects(){
        joinUs = JoinUsData.getJoinUs();
    }

    @Test
    public void validateSearchWorks(){
        assertTrue(joinUsPage.searchOrganization(joinUs.getName()));
    }
    @Test
    public void validateOpenWorks(){
        String name = joinUs.getName();
        assertTrue(joinUsPage.searchOrganization(name));
        CharityPage charityPage = joinUsPage.openOrganization(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
    }
    @Test(priority = 1)
    public void validateDeleteWorks(){
        String name = joinUs.getName();
        assertTrue(joinUsPage.searchOrganization(name));
        while(joinUsPage.searchOrganization(name)) {
            joinUsPage.deleteOrganization(name);
        }
        assertFalse(joinUsPage.searchOrganization(name));
    }
    @Test(priority = -1)
    public void validateAddWorks(){
        String name = joinUs.getName();
        AddEditJoinUsPage addPage = joinUsPage.createOrganization();
        assertTrue(addPage.isVisible());
        addPage.addJoinUs(joinUs);
        assertTrue(joinUsPage.isVisible());
        assertTrue(joinUsPage.searchOrganization(name));
    }
    //@Test//(dataProvider = "NTData", dataProviderClass = JoinUsData.class)
    public void validateNoWrongInputsAdd(){
        AddEditJoinUsPage addPage = joinUsPage.createOrganization();
        assertTrue(addPage.isVisible());
        addPage.addJoinUs(joinUs);
        assertTrue(addPage.isVisible());
    }
    @Test
    public void validateEditWorks(){
        String oldName = joinUs.getName();
        String newName = joinUs.getName()+joinUs.getName();
        String name = newName;
        for (int i = 0; i < 2; ++i) {
            CharityPage charityPage = joinUsPage.openOrganization(oldName);
            assertTrue(charityPage.isVisible());
            AddEditJoinUsPage addPage = charityPage.editJoinUs();
            assertTrue(addPage.isVisible());
            assertEquals(addPage.getName(), oldName);
            addPage.setName(newName);
            addPage.saveChanges();
            assertTrue(joinUsPage.isVisible());
            assertTrue(joinUsPage.searchOrganization(newName));
            newName = oldName;
            oldName = name;
        }
    }
    @Test
    public void validateRightEditPageOpened(){
        String name = joinUs.getName();
        CharityPage charityPage = joinUsPage.openOrganization(name);
        assertTrue(charityPage.isVisible());
        assertEquals(charityPage.getName(),name);
        AddEditJoinUsPage addPage = charityPage.editJoinUs();
        assertTrue(addPage.isVisible());
        assertEquals(addPage.getName(),name);
    }
    @Test
    public void validateRightTitle(){}
}
















































































































