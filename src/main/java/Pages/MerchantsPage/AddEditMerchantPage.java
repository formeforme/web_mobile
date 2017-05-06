package Pages.MerchantsPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEditMerchantPage {
    @FindBy(xpath = AddEditMerchantPageConst.ID)
    private WebElement IDField;
    @FindBy(xpath = AddEditMerchantPageConst.BRAND_NAME)
    private WebElement brandNameField;
    @FindBy(xpath = AddEditMerchantPageConst.CYCLE_7)
    private WebElement cycle7Button;
    @FindBy(xpath = AddEditMerchantPageConst.CYCLE_30)
    private WebElement cycle30Button;
    @FindBy(xpath = AddEditMerchantPageConst.REPORT_EMAIL)
    private WebElement reportEmailField;
    @FindBy(xpath = AddEditMerchantPageConst.BV)
    private WebElement BVField;
    @FindBy(xpath = AddEditMerchantPageConst.SHOP_NAME)
    private WebElement shopNameField;
    @FindBy(xpath = AddEditMerchantPageConst.SHOP_PHONE)
    private WebElement shopPhoneField;
    @FindBy(xpath = AddEditMerchantPageConst.OPENING_HOURS)
    private WebElement openingHoursField;
    @FindBy(xpath = AddEditMerchantPageConst.COUPON_EMAIL)
    private WebElement couponEmailField;
    @FindBy(xpath = AddEditMerchantPageConst.LOGO)
    private WebElement logoField;
    @FindBy(xpath = AddEditMerchantPageConst.GRAPHICS)
    private WebElement graphicsField;
    @FindBy(xpath = AddEditMerchantPageConst.MEMBER_SINCE)
    private WebElement memberSinceField;
    @FindBy(xpath = AddEditMerchantPageConst.FINISH_BUTTON)
    private WebElement finishButton;

    private WebDriver webDriver;
    public AddEditMerchantPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }
    public void setID(String ID){
        IDField.sendKeys(ID);
    }
    public String getID(){
        return IDField.getAttribute("value");
    }
    public void clearIDField(){
        IDField.clear();
    }
    public void setBrandName(String brandName){
        brandNameField.sendKeys(brandName);
    }
    public String getBrandName(){
        return brandNameField.getAttribute("value");
    }
    public void clearBrandName(){
        brandNameField.clear();
    }
    public void setReportEmail(String reportEmail){
        reportEmailField.sendKeys(reportEmail);
    }
    public String getReportEmail(){
        return reportEmailField.getAttribute("value");
    }
    public void clearReportEmailField(){
        reportEmailField.clear();
    }

}
