package Test.SubCategoriesTest;

import Pages.Categories.*;
import Pages.HomePage.HomePage;
import Pages.Login.LoginPage;
import Pages.Categories.AddEditSubCategoryPage;
import Pages.Categories.SubCategory;
import Test.BaseTest.BaseTest;
import Test.CategoriesTest.CategoriesPageData;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SubCategoryPageTest extends BaseTest{
    private Category category;
    private SubCategory subCategory;
    private HomePage homePage;
    private LoginPage loginPage;
    private CategoryPage categoryPage;
    private CategoriesPage categoriesPage;
    private AddEditCategoryPage addEditCategoryPage;

    protected void createObjects(){
        category = CategoriesPageData.getCategory();
        subCategory = SubCategoryPageData.getSubCategory();
    }
    protected void initializeMembers(){
        loginPage = new LoginPage(webDriver);
        addEditCategoryPage = new AddEditCategoryPage(webDriver);
    }
    protected void openPage(){
        homePage = loginPage.login(WebDriverBase.user);
        assertTrue(homePage.isVisible());
        categoriesPage = homePage.openCategories();
        assertTrue(categoriesPage.isVisible());
        createCategory();
        categoryPage = categoriesPage.openCategory(category.getName());
        assertTrue(categoryPage.isVisible());
    }
    private void createCategory(){
        if(categoriesPage.searchCategory(category.getName())){
            return;
        }
        AddEditCategoryPage addPage = categoriesPage.createCategory();
        assertTrue(addPage.isVisible());
        addPage.addCategory(category);
        assertTrue(categoriesPage.isVisible());
        assertTrue(categoriesPage.searchCategory(category.getName()));
    }
    @Test(priority = -1)
    void addSubCategory(){
        AddEditSubCategoryPage addPage = categoryPage.createSubCategory();
        assertTrue(addPage.isVisible());
        CategoryPage categoryPage = addPage.addSubCategory(subCategory);
        assertTrue(categoryPage.isVisible());
    }
    @Test
    void editSubCategory(){
        String oldName = subCategory.getName();
        String newName = subCategory.getName()+subCategory.getName();
        String name = newName;
        for(int i = 0; i<2; ++i) {
            AddEditSubCategoryPage addPage = categoryPage.editSubCategory(oldName);
            assertTrue(addPage.isVisible());
            addPage.clearNameField();
            addPage.setName(newName);
            addPage.saveChanges();
            assertTrue(categoryPage.isVisible());
            newName = oldName;
            oldName = name;
        }
    }
    @Test
    void validateRightEditSubCategoryPage(){
        String name = subCategory.getName();
        CategoryPage categoryPage = categoriesPage.openCategory(this.category.getName());
        assertTrue(categoryPage.isVisible());
        AddEditSubCategoryPage addPage = categoryPage.editSubCategory(name);
        assertTrue(addPage.isVisible());
        assertEquals(addPage.getName(),name);
//        assertTrue(image.contains(addEditCategoryPage.getImage()));
    }
   // @Test(dataProvider = "NTData", dataProviderClass = SubCategoryPageData.class)
    void validateNotWrongEditInputs(){
        String name = subCategory.getName();
        CategoryPage categoryPage = categoriesPage.openCategory(category.getName());
        assertTrue(categoryPage.isVisible());
        AddEditSubCategoryPage addPage = categoryPage.editSubCategory(name);
        assertTrue(addPage.isVisible());
        addPage.addSubCategory(subCategory);
        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(addPage.isVisible());
    }
    @Test(priority = 1)
    void deleteSubCategory(){
        String name = subCategory.getName();
        CategoryPage page = categoriesPage.openCategory(category.getName());//change if only this run
        assertTrue(page.isVisible());
        page.deleteSubCategory(name);
    }

    protected void deleteObjects(){
        categoriesPage = homePage.openCategories();
        assertTrue(categoriesPage.isVisible());
        String name = category.getName();
        assertTrue(categoriesPage.searchCategory(name));
        while (categoriesPage.searchCategory(name)) {
            categoriesPage.deleteCategory(name);
        }
        assertFalse(categoriesPage.searchCategory(name));
    }
}
