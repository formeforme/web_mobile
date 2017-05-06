package Pages.MerchantsPage;


import Pages.HBBusiness.CategoryPage;
import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AllMerchantsPage extends State {
    @FindBy(xpath = AllMerchantsPageConst.CREATE_BUTTON)
    private WebElement createButton;
    @FindBy(xpath = AllMerchantsPageConst.SEARCH_FIELD)
    private WebElement searchField;
    @FindBy(xpath = AllMerchantsPageConst.SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(xpath = AllMerchantsPageConst.MERCHANTS)
    private List<WebElement> merchants;
    @FindBy(xpath = AllMerchantsPageConst.DELETE_BUTTONS)
    private List<WebElement> deleteButtons;

    private WebDriver webDriver;

    public AllMerchantsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public AddEditMerchantPage createMerchant(){
        createButton.click();
        return new AddEditMerchantPage(webDriver);
    }
    public MerchantInfoPage openMerchant(String name){
        for(WebElement item : merchants){
            if(item.getText().equals(name)){
                item.click();
                break;
            }
        }
        return new MerchantInfoPage(webDriver);
    }
    public void deleteHBBusiness(String name){
        for(int i = 0; i < merchants.size(); ++i) {
            if(merchants.get(i).getText().contains(name)){
                deleteButtons.get(i).click();
                break;
            }
        }
    }
    public boolean searchHBBusiness(String name){
        isElementPresent(searchField);
        searchField.sendKeys(name);
        searchButton.click();
        for(WebElement item : merchants){
            if(item.getText().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean isVisible(){
        return isElementPresent(createButton);
    }
}
