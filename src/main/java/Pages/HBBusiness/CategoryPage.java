package Pages.HBBusiness;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class CategoryPage extends State{
    @FindBy(xpath = CategoryPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(xpath = CategoryPageConst.IMAGE_FIELD)
    private WebElement imageField;
    @FindBy(xpath = CategoryPageConst.EDIT_BUTTON)
    private WebElement editButton;

    private WebDriver webDriver;

    public CategoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public String getName(){
        return nameField.getText();
    }
    public String getImage(){
        return imageField.getAttribute("src");
    }
    public AddEditHBBusinessPage editHBBusiness(){
        editButton.click();
        return new AddEditHBBusinessPage(webDriver);
    }
    public boolean isVisible() {
        return isElementPresent(editButton);
    }



}