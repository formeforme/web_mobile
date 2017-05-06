package Pages.JoinUs;

import Pages.State;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class JoinUsPage extends State {
    @FindBy(xpath = JoinUsPageConst.CREATE_BUTTON)
    private WebElement createButton;
    @FindBy(xpath = JoinUsPageConst.SEARCH_FIELD)
    private WebElement searchField;
    @FindBy(xpath = JoinUsPageConst.SEARCH_BUTTON)
    private WebElement searchButton;
    @FindBy(xpath = JoinUsPageConst.ORG_LIST)
    private List<WebElement> orgList;
    @FindBy(xpath = JoinUsPageConst.DELETE_BUTTONS)
    private List<WebElement> deleteButtons;

    private WebDriver webDriver;

    public JoinUsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public AddEditJoinUsPage createOrganization(){
        createButton.click();
        return new AddEditJoinUsPage(webDriver);
    }
    public boolean searchOrganization(String name){
        isElementPresent(searchField);
        searchField.sendKeys(String.valueOf(name));
        searchButton.click();
        for(WebElement org : orgList){
            if(org.getText().equals(name)){
                return true;
            }
        }
        return false;
    }
    public void deleteOrganization(String name){
        for(int i = 0; i < orgList.size(); ++i) {
            if(orgList.get(i).getText().contains(name)){
                deleteButtons.get(i).click();
                break;
            }
        }
    }
    public CharityPage openOrganization(String name){
        for(WebElement org : orgList){
            if(org.getText().equals(name)){
                org.click();
                break;
            }
        }
        return new CharityPage(webDriver);
    }

    public boolean isVisible(){
        return isElementPresent(createButton);
    }
}
