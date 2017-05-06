package Pages.Categories;

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
import java.util.LinkedList;
import java.util.List;


public class AddEditSubCategoryPage extends State {
    @FindBy(how = How.XPATH, using = AddEditSubCategoryPageConst.IMAGE_FIELD)
    private WebElement imageField;
    @FindBy(how = How.XPATH, using = AddEditSubCategoryPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = AddEditSubCategoryPageConst.YES_RADIO_BUTTON)
    private WebElement yesRadioButton;
    @FindBy(how = How.XPATH, using = AddEditSubCategoryPageConst.NO_RADIO_BUTTON)
    private WebElement noRadioButton;
    @FindBy(how = How.XPATH, using = AddEditSubCategoryPageConst.SAVE_BUTTON)
    private WebElement saveButton;
    @FindBy(how = How.XPATH, using = AddEditSubCategoryPageConst.IMAGES)
    private List<WebElement> images;
    @FindBy(how = How.XPATH, using = AddEditSubCategoryPageConst.IMAGES)
    private List<WebElement> removeButtons;

    private WebDriver webDriver;

    public AddEditSubCategoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public CategoryPage addSubCategory(SubCategory subCategory){
        setName(subCategory.getName());
        setImages(subCategory.getImages());
        setType(subCategory.getIsShown());
        return saveChanges();
    }
    public CategoryPage saveChanges(){
        saveButton.click();
        return new CategoryPage(webDriver);
    }
    public void setName(String name){
        clearNameField();
        nameField.sendKeys(String.valueOf(name));
    }
    public String getName(){
        return nameField.getAttribute("value");
    }
    public void clearNameField(){
        nameField.clear();
    }
    public void setImages(List<String> images) {
        clearImageField();
        for(String image : images){
            File file = new File(System.getProperty("user.dir"), image);
            System.out.println(file.getAbsolutePath());
            imageField.click();
            uploadFile(file.getAbsolutePath());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public List<String> getImages(){
        List<String> lst = new LinkedList<String>();
        for(WebElement image:images){
            lst.add(image.getAttribute("alt"));
        }
        return lst;
    }
    public void clearImageField(){
        for(WebElement button:removeButtons){
            button.click();
        }
    }
    public void setType(boolean isShown){
        if(isShown){
            yesRadioButton.click();
        } else {
            noRadioButton.click();
        }
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

    public boolean isVisible() {
        return isElementPresent(saveButton);
    }
}
