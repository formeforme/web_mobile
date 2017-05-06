package Pages.JoinUs;

import Pages.HBBusiness.CategoryPageConst;
import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liana on 4/14/17.
 */
public class CharityPage extends State {
    @FindBy(xpath = CharityPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(xpath = CharityPageConst.MAIN_IMAGE_FIELD)
    private WebElement mainImageField;
    @FindBy(xpath = CharityPageConst.SLIDER_IMAGE_FIELD)
    private List<WebElement> sliderImagesField;
    @FindBy(xpath = CharityPageConst.EDIT_BUTTON)
    private WebElement editButton;

    private WebDriver webDriver;

    public CharityPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public String getName(){
        return nameField.getText();
    }
    public String getMainImage(){
        return mainImageField.getAttribute("src");
    }
    public List<String> getSliderImages(){
        List<String> images = new LinkedList<String>();
        for(WebElement image:sliderImagesField){
            images.add(image.getAttribute("src"));
        }
        return images;
    }
    public AddEditJoinUsPage editJoinUs(){
        editButton.click();
        return new AddEditJoinUsPage(webDriver);
    }

    public boolean isVisible() {
        return isElementPresent(editButton);
    }
}
