package Test.CategoriesTest;

import Pages.Categories.Category;
import Pages.Charities.Charity;
import Test.parser.Parser;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.DataProvider;

import java.util.List;


public class CategoriesPageData {
    private static Category category;
    public static Category getCategory(){
        if(category == null){
            category = new Category();
            List<List<String>> lst = Parser.parseFile(
                    WebDriverBase.DATA_FILE, CategoriesPageData.class.getSimpleName());
            for(List<String> row:lst){
                category.setName(row.get(0));
                category.setImage(row.get(1));
                category.setType(row.get(2));
            }
        }
        return category;
    }
}
