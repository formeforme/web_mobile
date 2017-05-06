package Test.MerchantsPage;

import Pages.HBBusiness.HBBusiness;
import Pages.MerchantsPage.Merchant;
import Test.HBBusinessTest.HBBusinessPageData;
import Test.parser.Parser;
import WebDriverSupport.WebDriverBase;

import java.util.List;


public class AllMerchantsPageData {
    private static Merchant merchant;

    public static Merchant getMerchant(){
        if(merchant == null){
            merchant = new Merchant();
            List<List<String>> lst = Parser.parseFile(
                    WebDriverBase.DATA_FILE, HBBusinessPageData.class.getSimpleName());
            for(List<String> row:lst){
                //TODO
               // merchant.setName(row.get(0));
               // merchant.setImage(row.get(1));
            }
        }
        return merchant;
    }

}
