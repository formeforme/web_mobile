package Test.HBBusinessTest;

import Pages.HBBusiness.HBBusiness;
import Test.parser.Parser;
import WebDriverSupport.WebDriverBase;

import java.util.List;


public class HBBusinessPageData {
    private static HBBusiness hbBusiness;

    public static HBBusiness getHbBusiness(){
        if(hbBusiness == null){
            hbBusiness = new HBBusiness();
            List<List<String>> lst = Parser.parseFile(
                    WebDriverBase.DATA_FILE, HBBusinessPageData.class.getSimpleName());
            for(List<String> row:lst){
                //TODO
                hbBusiness.setName(row.get(0));
                hbBusiness.setImage(row.get(1));
            }
        }
        return hbBusiness;
    }
}