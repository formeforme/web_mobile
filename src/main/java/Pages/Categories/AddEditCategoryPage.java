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

public class AddEditCategoryPage extends State {
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.IMAGE_FIELD)
    private WebElement imageField;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.ONLINE_SALES_BUTTON)
    private WebElement onlineSalesButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.FREE_BUTTON)
    private WebElement freeButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.SAVE_BUTTON)
    private WebElement saveButton;
    @FindBy(how = How.XPATH, using = AddEditCategoryPageConst.IMAGES)
    private WebElement image;

    private WebDriver webDriver;

    public AddEditCategoryPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public void addCategory(Category category){
        setName(category.getName());
        setImage(category.getImage());
        chooseType(category.getType());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveChanges();
    }

    public String getName(){
        return nameField.getAttribute("value");
    }
    public void setName(String name){
        nameField.sendKeys(String.valueOf(name));
    }
    public void clearNameField(){
        nameField.clear();
    }
    public String getImage(){
        return image.getAttribute("src");
    }
    public void setImage(String image) {
            //for(String image : images) {
                File file = new File(System.getProperty("user.dir"), image);
                imageField.click();
                uploadFile(file.getAbsolutePath());
            //}
    }
    public void clearImageField(){}
    private void chooseType(String type) {
        if (type.contains("OnlineSales")) {
            onlineSalesButton.click();
        } else {
            freeButton.click();
        }
    }
    public CategoriesPage saveChanges(){
        saveButton.click();
        return new CategoriesPage(webDriver);
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
