package Pages.Categories;

/**
 * Created by liana on 4/23/17.
 */
public class CategoryPageConst {
    public static final String NAME_FIELD = "/html/body/div/div[2]/div[2]/div[2]/div/form/div/div[2]/div[1]/label[2]";
    public static final String IMAGE_FIELD = "/html/body/div/div[2]/div[2]/div[2]/div/form/div/div[2]/div[2]/div/img";
    public static final String EDIT_BUTTON = "/html/body/div/div[2]/div[2]/div[2]/div/div/div[2]/a[2]/button";
    public static final String CREATE_SUBCATEGORY_BUTTON = "//a[contains(@href,'addSubCategory')]/button[@class='btn redBtn']";
    public static final String EDIT_SUBCATEGORY_BUTTON = "//a[@class='editBtn' and contains(@href,'add')]";
    public static final String DELETE_SUBCATEGORY_BUTTON = "//a[@class='editBtn' and contains(@href,'delete')]";
    public static final String SUBCATEGORIES = "//tr/td[1]";
}
