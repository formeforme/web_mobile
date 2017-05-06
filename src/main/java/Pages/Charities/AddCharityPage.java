package Pages.Charities;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Created by liana on 4/23/17.
 */
public class AddCharityPage extends State{
    @FindBy(how = How.XPATH, using = AddCharityPageConst.TITLE)
    private WebElement title;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.NAME)
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.EMAIL)
    private WebElement emailField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.INFO)
    private WebElement infoField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.LOGO)
    private WebElement logoField;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.SAVE_BUTTON)
    private WebElement saveButton;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.IMAGES)
    private WebElement images;
    @FindBy(how = How.XPATH, using = AddCharityPageConst.REMOVE_BUTTON)
    private WebElement removeButton;

    private WebDriver webDriver;

    public AddCharityPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void addCharity(Charity organization){
        setName(organization.getName());
        setEmail(organization.getEmail());
        setInfo(organization.getInfo());
        setLogo(organization.getLogo());
        saveChanges();
    }

    public String getName(){
        return nameField.getAttribute("value");
    }
    public String getEmail(){
        return emailField.getAttribute("value");
    }
    public String getInfo(){
        return infoField.getAttribute("value");
    }
    public String getLogo(){
        return logoField.getAttribute("value");
    }

    public void setName(String name){
        nameField.sendKeys(String.valueOf(name));
    }
    public void setEmail(String email){
        emailField.sendKeys(String.valueOf(email));
    }
    public void setInfo(String info){
        infoField.sendKeys(String.valueOf(info));
    }
    public void setLogo(String image){
        if(image != null) {
            File file = new File(System.getProperty("user.dir"), image);
            logoField.click();
            uploadFile(file.getAbsolutePath());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void clearNameField(){
        nameField.clear();
    }
    public void clearEmailField(){
        emailField.clear();
    }
    public void clearInfoField(){
        infoField.clear();
    }
    public void clearLogo(){
        removeButton.click();
    }
    public AddCharityPage saveChanges(){
        saveButton.click();
        return new AddCharityPage(webDriver);
    }
    public boolean isVisible() {
        return isElementPresent(nameField);
    }

    private void uploadFile(String fileLocation) {
        try {
            StringSelection stringSelection = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.setAutoDelay(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

}
