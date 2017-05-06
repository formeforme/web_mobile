package Test.JoinUs;


import Pages.HBBusiness.HBBusiness;
import Pages.JoinUs.JoinUs;
import Test.HBBusinessTest.HBBusinessPageData;
import Test.parser.Parser;
import WebDriverSupport.WebDriverBase;

import java.util.LinkedList;
import java.util.List;

public class JoinUsData {
    private static JoinUs joinUs;
    public static JoinUs getJoinUs(){
        if(joinUs == null){
            joinUs = new JoinUs();
            List<List<String>> lst = Parser.parseFile(
                    WebDriverBase.DATA_FILE, JoinUsData.class.getSimpleName());
            for(List<String> row:lst){
                //TODO
                joinUs.setName(row.get(0));
                joinUs.setMainImage((row.get(1)));
                List<String> images = new LinkedList<String>();
                images.add(row.get(2));
                images.add(row.get(3));
                images.add(row.get(4));
                joinUs.setSliderImages(images);
            }
        }
        return joinUs;
    }

}
