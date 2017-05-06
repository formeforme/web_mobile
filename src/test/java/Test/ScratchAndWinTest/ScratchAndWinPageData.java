package Test.ScratchAndWinTest;


import Pages.HBBusiness.HBBusiness;
import Pages.ScratchAndWin.ScratchAndWin;
import Test.HBBusinessTest.HBBusinessPageData;
import Test.parser.Parser;
import WebDriverSupport.WebDriverBase;

import java.util.LinkedList;
import java.util.List;

public class ScratchAndWinPageData {
    private static ScratchAndWin scratchAndWin;
    public static ScratchAndWin getScratchAndWin(){
        if(scratchAndWin == null){
            scratchAndWin = new ScratchAndWin();
            List<List<String>> lst = Parser.parseFile(
                    WebDriverBase.DATA_FILE, ScratchAndWinPageData.class.getSimpleName());
            for(List<String> row:lst){
                //TODO
                scratchAndWin.setPrice(row.get(0));
                List<String> images = new LinkedList<String>();
                for(int i = 1; i<10; ++i){
                    images.add(row.get(i));
                }
                scratchAndWin.setImages(images);
            }
        }
        return scratchAndWin;
    }
}
