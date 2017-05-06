package Test.HBBusinessTest;

import Pages.HBBusiness.AddEditHBBusinessPage;
import Pages.HBBusiness.CategoryPage;
import Pages.HBBusiness.HBBusiness;
import Pages.HBBusiness.HBBusinessPage;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class HBBusinessPageTest extends BaseTest{
    private LoginPage loginPage;
    private HBBusiness hbBusiness;
    private HBBusinessPage hbBusinessPage;

    protected void createObjects(){
        hbBusiness = HBBusinessPageData.getHbBusiness();
    }
    protected void initializeMembers(){
        loginPage = new LoginPage(webDriver);
        hbBusinessPage = new HBBusinessPage(webDriver);
    }
    protected void openPage(){
        HomePage homePage = loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openHBBusiness();
        assertTrue(hbBusinessPage.isVisible());
    }
    @Test(priority = -1)
    void validateCreateWorks(){
        String name = hbBusiness.getName();
        AddEditHBBusinessPage addPage = hbBusinessPage.addHBBusiness();
        assertTrue(addPage.isVisible());
        addPage.addHBBusiness(hbBusiness);
        assertTrue(hbBusinessPage.isVisible());
        assertTrue(hbBusinessPage.searchHBBusiness(name));
    }
    @Test(priority = 1)
    void validateDeleteWorks(){
        String name = hbBusiness.getName();
        assertTrue(hbBusinessPage.searchHBBusiness(name));
        while (hbBusinessPage.searchHBBusiness(name)) {
            hbBusinessPage.deleteHBBusiness(name);
        }
        assertFalse(hbBusinessPage.searchHBBusiness(name));
    }
    @Test
    void validateSearchWorks(){
        String name = hbBusiness.getName();
        assertTrue(hbBusinessPage.searchHBBusiness(name));
    }
    @Test
    void validateOpenWorks(){
        String name = hbBusiness.getName();
        assertTrue(hbBusinessPage.searchHBBusiness(name));
        CategoryPage categoryPage = hbBusinessPage.openHBBusiness(name);
        assertTrue(categoryPage.isVisible());
        assertEquals(categoryPage.getName(),name);
    }
    @Test
    void validateNameFieldIsNotEmpty(){
        AddEditHBBusinessPage addPage = hbBusinessPage.addHBBusiness();
        assertTrue(addPage.isVisible());
        addPage.setName(hbBusiness.getName());
        addPage.saveChanges();
        assertTrue(addPage.isVisible());
    }
    @Test
    void validateImageFieldIsNotEmpty(){
        AddEditHBBusinessPage addPage = hbBusinessPage.addHBBusiness();
        assertTrue(addPage.isVisible());
        addPage.setImage(hbBusiness.getImage());
        addPage.saveChanges();
        assertTrue(addPage.isVisible());
    }
    @Test
    void validateRightEditPageOpened(){
        String name = hbBusiness.getName();
        CategoryPage categoryPage = hbBusinessPage.openHBBusiness(name);
        assertTrue(categoryPage.isVisible());
        String image = categoryPage.getImage();
        AddEditHBBusinessPage editPage = categoryPage.editHBBusiness();
        assertTrue(editPage.isVisible());
        assertEquals(editPage.getName(),name);
        assertTrue(image.contains(editPage.getImage()));
    }
    @Test
    void validateEditWorks(){
        String oldName = hbBusiness.getName();
        String newName = hbBusiness.getName()+hbBusiness.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            CategoryPage categoryPage = hbBusinessPage.openHBBusiness(oldName);
            assertTrue(categoryPage.isVisible());
            AddEditHBBusinessPage editPage = categoryPage.editHBBusiness();
            assertTrue(editPage.isVisible());
            editPage.clearNameField();
            editPage.setName(newName);
            editPage.saveChanges();
            assertTrue(hbBusinessPage.isVisible());
            assertTrue(hbBusinessPage.searchHBBusiness(newName));
            newName = oldName;
            oldName = name;
        }
    }
    /*@Test
    void validateRightTitle(){}
    @Test(dataProvider = "NTData", dataProviderClass = HBBusinessPageData.class)
    void validateNoWrongInputsAdd(HBBusiness hbBusiness){
        AddEditHBBusinessPage addPage = hbBusinessPage.addHBBusiness();
        assertTrue(addPage.isVisible());
        addPage.addHBBusiness(hbBusiness);
        assertTrue(addPage.isVisible());
    }*/
}
