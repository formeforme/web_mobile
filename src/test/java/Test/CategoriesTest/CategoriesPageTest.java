package Test.CategoriesTest;

import Pages.Categories.*;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Test.BaseTest.BaseTest;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CategoriesPageTest extends BaseTest{
    private Category category;
    private LoginPage loginPage;
    private CategoriesPage categoriesPage;

    protected void createObjects(){
        category = CategoriesPageData.getCategory();
    }

    protected void initializeMembers(){
        loginPage = new LoginPage(webDriver);
        categoriesPage = new CategoriesPage(webDriver);
    }
    protected void openPage(){
        HomePage homePage = loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        homePage.openCategories();
        assertTrue(categoriesPage.isVisible());
    }

    @Test(priority = -1)
    void validateAddWorks(){
        AddEditCategoryPage addPage = categoriesPage.createCategory();
        assertTrue(addPage.isVisible());
        addPage.addCategory(category);
        assertTrue(categoriesPage.isVisible());
        assertTrue(categoriesPage.searchCategory(category.getName()));
    }
    @Test
    void validateSearchWorks(){
        assertTrue(categoriesPage.searchCategory(category.getName()));
    }
    @Test
    void validateOpenWorks(){
        String name = category.getName();
        assertTrue(categoriesPage.searchCategory(name));
        CategoryPage categoryPage = categoriesPage.openCategory(name);
        assertTrue(categoryPage.isVisible());
        assertEquals(categoryPage.getName(),name);
    }
    @Test(priority = 1)
    void validateDeleteWorks(){
        String name = category.getName();
        while (categoriesPage.searchCategory(name)) {
            categoriesPage.deleteCategory(name);
        }
        assertFalse(categoriesPage.searchCategory(name));
    }
   // @Test(dataProvider = "NTData", dataProviderClass = HBBusinessPageData.class)
    void validateNoWrongInputsAdd(Category category){
        AddEditCategoryPage addPage = categoriesPage.createCategory();
        assertTrue(addPage.isVisible());
        addPage.addCategory(category);
        assertTrue(addPage.isVisible());
    }
    @Test
    void validateRightEditPageOpened(){
        String name = category.getName();
        CategoryPage categoryPage = categoriesPage.openCategory(name);
        assertTrue(categoryPage.isVisible());
        String image = categoryPage.getImage();
        AddEditCategoryPage addPage = categoryPage.editCategory();
        assertTrue(addPage.isVisible());
        assertEquals(addPage.getName(),name);
        assertTrue(image.contains(addPage.getImage()));
    }
    @Test
    void validateEditWorks(){
        String oldName = category.getName();
        String newName = category.getName()+category.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            CategoryPage categoryPage = categoriesPage.openCategory(oldName);
            assertTrue(categoryPage.isVisible());
            AddEditCategoryPage addPage = categoryPage.editCategory();
            assertTrue(addPage.isVisible());
            addPage.clearNameField();
            addPage.setName(newName);
            CategoriesPage categoriesPage = addPage.saveChanges();
            assertTrue(categoriesPage.isVisible());
            assertTrue(categoriesPage.searchCategory(newName));
            newName = oldName;
            oldName = name;
        }
    }
}

