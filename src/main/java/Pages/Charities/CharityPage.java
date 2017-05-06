package Pages.Charities;


import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CharityPage extends State {
    @FindBy(how = How.XPATH, using = CharityPageConst.TITLE)
    private WebElement title;
    @FindBy(how = How.XPATH, using = CharityPageConst.NAME)
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = CharityPageConst.EMAIL)
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = CharityPageConst.INFO)
    private WebElement infoField;
    @FindBy(how = How.XPATH, using = CharityPageConst.LOGO)
    private WebElement logoField;
    @FindBy(how = How.XPATH, using = CharityPageConst.EDIT_BUTTON)
    private WebElement editButton;

    private WebDriver webDriver;

    public CharityPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public String getName(){
        return nameField.getText();
    }
    public String getEmail(){
        return emailField.getText();
    }
    public String getInfo(){
        return infoField.getText();
    }
    public String getLogo(){
        return logoField.getText();
    }
    public AddCharityPage edit(){
        editButton.click();
        return new AddCharityPage(webDriver);
    }
    public boolean isVisible() {
        return isElementPresent(nameField);
    }
}
