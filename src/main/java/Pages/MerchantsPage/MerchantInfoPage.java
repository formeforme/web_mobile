package Pages.MerchantsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MerchantInfoPage {

    private WebDriver webDriver;

    public MerchantInfoPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
}
