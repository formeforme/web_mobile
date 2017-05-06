package Test.SubCategoriesTest;

import Pages.Categories.SubCategory;
import Pages.ScratchAndWin.ScratchAndWin;
import Test.ScratchAndWinTest.ScratchAndWinPageData;
import Test.parser.Parser;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.DataProvider;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class SubCategoryPageData {
    private static SubCategory subCategory;
    public static SubCategory getSubCategory(){
        if(subCategory == null){
            subCategory = new SubCategory();
            List<List<String>> lst = Parser.parseFile(
                    WebDriverBase.DATA_FILE, SubCategoryPageData.class.getSimpleName());
            for(List<String> row:lst){
                subCategory.setName(row.get(0));
                List<String> images = new LinkedList<String>();
                images.add(row.get(1));
                images.add(row.get(2));
                subCategory.setImages(images);
            }
        }
        return subCategory;
    }



    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new SubCategory() {{
                    setName("auto_SubCategory");
                    setImages(new LinkedList<String>(){{
                                  add("image/coffee.jpeg");
                                  add("image/coffee.jpeg");
                              }}
                    );
                }}}
        };
    }
}
