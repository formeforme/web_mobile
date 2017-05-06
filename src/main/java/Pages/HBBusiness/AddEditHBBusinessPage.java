package Pages.HBBusiness;

import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class AddEditHBBusinessPage extends State {
    @FindBy(xpath = AddEditHBBusinessPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(xpath = AddEditHBBusinessPageConst.IMAGE_FIELD)
    private WebElement imageField;
    @FindBy(xpath = AddEditHBBusinessPageConst.IMAGE)
    private WebElement image;
    @FindBy(xpath = AddEditHBBusinessPageConst.IMAGE_REMOVE_BUTTON)
    private WebElement imageRemoveButton;
    @FindBy(xpath = AddEditHBBusinessPageConst.SAVE_BUTTON)
    private WebElement saveButton;

    private WebDriver webDriver;

    public AddEditHBBusinessPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void addHBBusiness(HBBusiness hbBusiness){
        setName(hbBusiness.getName());
        setImage(hbBusiness.getImage());
        saveChanges();
    }
    public void setName(String name){
        nameField.sendKeys(String.valueOf(name));
    }
    public void setImage(String image) {
        imageField.click();
        if(image != null) {
            File file = new File(System.getProperty("user.dir"), image);
            uploadFile(file.getAbsolutePath());
        }
        isElementPresent(this.image);
    }
    public String getName(){
        return nameField.getAttribute("value");
    }
    public String getImage(){
        return image.getAttribute("innerHTML");
    }
    public void clearNameField(){
        nameField.clear();
    }
    public void clearImageField(){
        imageRemoveButton.click();
    }
    public HBBusinessPage saveChanges(){
        saveButton.click();
        return new HBBusinessPage(webDriver);
    }
    private void uploadFile(String fileLocation) {
        try {
            StringSelection stringSelection = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.mousePress(InputEvent.BUTTON1_MASK);
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
    public boolean isVisible(){
        return isElementPresent(saveButton);
    }
}
