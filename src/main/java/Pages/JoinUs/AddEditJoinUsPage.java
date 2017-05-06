package Pages.JoinUs;


import java.awt.event.InputEvent;
import java.util.List;
import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.*;


public class AddEditJoinUsPage extends State {
    @FindBy(xpath = AddEditJoinUsPageConst.NAME_FIELD)
    private WebElement nameField;
    @FindBy(xpath = AddEditJoinUsPageConst.MAIN_IMAGE_FIELD)
    private WebElement mainImageField;
    @FindBy(xpath = AddEditJoinUsPageConst.SLIDER_IMAGES_FIELD)
    private WebElement sliderImagesField;
    @FindBy(xpath = AddEditJoinUsPageConst.MAIN_IMAGE)
    private WebElement mainImage;
    @FindBy(xpath = AddEditJoinUsPageConst.SLIDER_IMAGES)
    private List<WebElement> sliderImages;
    @FindBy(xpath = AddEditJoinUsPageConst.SAVE_BUTTON)
    private WebElement saveButton;

    private WebDriver webDriver;

    public AddEditJoinUsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void addJoinUs(JoinUs joinUs){
        setName(joinUs.getName());
        setMainImage(joinUs.getMainImage());
        setSliderImages(joinUs.getSliderImages());
        saveChanges();
    }
    public void setName(String name){
        clearNameField();
        nameField.sendKeys(String.valueOf(name));
    }
    public void setMainImage(String image) {
        if(image != null) {
            File file = new File(System.getProperty("user.dir"), image);
            mainImageField.click();
            uploadFile(file.getAbsolutePath());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setSliderImages(List<String> images) {
        if(images != null) {
            for (String image:images) {
                File file = new File(System.getProperty("user.dir"), image);
                sliderImagesField.click();
                uploadFile(file.getAbsolutePath());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public String getName(){
        return nameField.getAttribute("value");
    }
    public String getMainImage(){return mainImage.getAttribute("innerHTML");}
    public List<String> getSliderImages(){
        List<String> images = new LinkedList<String>();
        for(WebElement sliderImage : sliderImages){
            images.add(sliderImage.getAttribute("innerHTML"));
        }
        return images;
    }
    public void clearNameField(){
        nameField.clear();
    }
    public void clearMainImageField(){

    }
    public void clearSliderImageField(){

    }
    public JoinUsPage saveChanges(){
        saveButton.click();
        return new JoinUsPage(webDriver);
    }
    private void uploadFile(String fileLocation) {
        try {
            StringSelection stringSelection = new StringSelection(fileLocation);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
           // robot.setAutoDelay(2000);
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
