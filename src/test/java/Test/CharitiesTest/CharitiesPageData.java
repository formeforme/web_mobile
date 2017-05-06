package Test.CharitiesTest;

import Pages.Charities.Charity;
import Pages.HBBusiness.HBBusiness;
import Test.HBBusinessTest.HBBusinessPageData;
import Test.parser.Parser;
import WebDriverSupport.WebDriverBase;
import org.testng.annotations.DataProvider;

import java.util.List;

public class CharitiesPageData {
    private static Charity charity;
    public static Charity getCharity(){
        if(charity == null){
            charity = new Charity();
            List<List<String>> lst = Parser.parseFile(
                    WebDriverBase.DATA_FILE, CharitiesPageData.class.getSimpleName());
            for(List<String> row:lst){
                charity.setName(row.get(0));
                charity.setEmail(row.get(1));
                charity.setInfo(row.get(2));
                charity.setLogo(row.get(3));
            }
        }
        return charity;
    }

    @DataProvider(name = "NTData")
    public static Object[][] NTData() {
        return new Object[][]{
                {new Charity()},
                {new Charity() {{
                    setName("auto_Charity");
                    setEmail("auto_Charity@c.com");
                    setInfo("general_info");
                }}},
                {new Charity() {{
                    setName("auto_Charity");
                    setEmail("auto_Charity@c.com");
                    setLogo("image/coffee.jpeg");
                }}},
                {new Charity() {{
                    setName("auto_Charity");
                    setInfo("general_info");
                    setLogo("image/coffee.jpeg");
                }}},
                {new Charity() {{
                    setEmail("auto_Charity@c.com");
                    setInfo("general_info");
                    setLogo("image/coffee.jpeg");
                }}}
        };
    }
}
