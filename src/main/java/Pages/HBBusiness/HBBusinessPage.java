package Pages.HBBusiness;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HBBusinessPage extends State {
    @FindBy(xpath = HBBusinessPageConst.ADD_BUTTON)
    private WebElement addButton;
    @FindBy(xpath = HBBusinessPageConst.SEARCH_FIELD)
    private WebElement searchField;
    @FindBy(xpath = HBBusinessPageConst.SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(xpath = HBBusinessPageConst.ITEMS)
    private List<WebElement> items;
    @FindBy(xpath = HBBusinessPageConst.DELETE_BUTTONS)
    private List<WebElement> deleteButtons;

    private WebDriver webDriver;

    public HBBusinessPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public AddEditHBBusinessPage addHBBusiness(){
        addButton.click();
        return new AddEditHBBusinessPage(webDriver);
    }
    public CategoryPage openHBBusiness(String name){
        CategoryPage page = null;
        for(WebElement item : items){
            if(item.getText().equals(name)){
                item.click();
                page = new CategoryPage(webDriver);
                break;
            }
        }
        return page;
    }
    public void deleteHBBusiness(String name){
        for(int i = 0; i < items.size(); ++i) {
            if(items.get(i).getText().contains(name)){
                deleteButtons.get(i).click();
                break;
            }
        }
    }
    public boolean searchHBBusiness(String name){
        isElementPresent(searchField);
        searchField.sendKeys(String.valueOf(name));
        searchButton.click();
        for(WebElement item : items){
            if(item.getText().equals(name)){
                return true;
            }
        }
        return false;
    }
    public boolean isVisible(){
        return isElementPresent(addButton);
    }
}
