package Pages.HomePage;

import Pages.Categories.CategoriesPage;
import Pages.Charities.CharitiesPage;
import Pages.HBBusiness.HBBusinessPage;
import Pages.JoinUs.JoinUsPage;
import Pages.Login.LoginPage;
import Pages.MerchantsPage.AllMerchantsPage;
import Pages.ScratchAndWin.ScratchAndWinPage;
import Pages.State;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by liana on 4/9/17.
 */
public class HomePage extends State {
    @FindBy(xpath = HomePageConst.MENU_HOME)
    private WebElement menuHome;
    @FindBy(xpath = HomePageConst.MENU_MERCHANTS_AND_VOUCHERS)
    private WebElement menuMerchantsAndVouchers;
    @FindBy(xpath = HomePageConst.MENU_ALL_MERCHANTS)
    private WebElement menuAllMerchants;
    @FindBy(xpath = HomePageConst.MENU_ACTIVE_MERCHANTS)
    private WebElement menuActiveMerchants;
    @FindBy(xpath = HomePageConst.MENU_INACTIVE_MERCHANTS)
    private WebElement menuInactiveMerchants;
    @FindBy(xpath = HomePageConst.MENU_USERS)
    private WebElement menuUsers;
    @FindBy(xpath = HomePageConst.MENU_ALL_USERS)
    private WebElement menuAllUsers;
    @FindBy(xpath = HomePageConst.MENU_EXECUTIVES)
    private WebElement menuExecutives;
    @FindBy(xpath = HomePageConst.MENU_NON_EXECUTIVES)
    private WebElement menuNonExecutives;
    @FindBy(xpath = HomePageConst.MENU_CHARITIES)
    private WebElement menuCharities;
    @FindBy(xpath = HomePageConst.MENU_APP_MANAGMENT)
    private WebElement menuAppManagment;
    @FindBy(xpath = HomePageConst.MENU_CATEGORIES)
    private WebElement menuCategories;
    @FindBy(xpath = HomePageConst.MENU_HBBUSINESS)
    private WebElement menuHBBusiness;
    @FindBy(xpath = HomePageConst.MENU_JOIN_US)
    private WebElement menuJoinUs;
    @FindBy(xpath = HomePageConst.MENU_SCRATCH_AND_WIN)
    private WebElement menuScratchAndWin;
    @FindBy(xpath = HomePageConst.LOGOUT_BUTTON)
    private WebElement logoutButton;

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    public CategoriesPage openCategories(){
        menuAppManagment.click();
        isElementPresent(menuCategories);
        menuCategories.click();
        return new CategoriesPage(webDriver);
    }
    public HBBusinessPage openHBBusiness(){
        menuAppManagment.click();
        isElementPresent(menuHBBusiness);
        menuHBBusiness.click();
        return new HBBusinessPage(webDriver);
    }
    public JoinUsPage openJoinUs(){
        menuAppManagment.click();
        isElementPresent(menuJoinUs);
        menuJoinUs.click();
        return new JoinUsPage(webDriver);
    }
    public ScratchAndWinPage openScratchAndWin(){
        menuAppManagment.click();
        isElementPresent(menuScratchAndWin);
        menuScratchAndWin.click();
        return new ScratchAndWinPage(webDriver);
    }
    public CharitiesPage openCharity(){
        menuCharities.click();
        return new CharitiesPage(webDriver);
    }
    public AllMerchantsPage openAllMerchants(){
        menuMerchantsAndVouchers.click();
        isElementPresent(menuAllMerchants);
        menuAllMerchants.click();
        return new AllMerchantsPage(webDriver);
    }
  /*  public AllUsersPage openAllUsers(){
        menuUsers.click();
        isElementPresent(menuAllUsers);
        menuAllUsers.click();
        return new AllUsersPage(webDriver);
    }
    public ExecutivesPage openAllExecutives(){
        menuUsers.click();
        isElementPresent(menuExecutives);
        menuExecutives.click();
        return new ExecutivesPage(webDriver);
    }
    public NonExecutivesPage openNonExecutives(){
        menuUsers.click();
        isElementPresent(menuNonExecutives);
        menuNonExecutives.click();
        return new NonExecutivesPage(webDriver);
    }

    public ActiveMerchantsPage openActiveMerchants(){
        menuMerchantsAndVouchers.click();
        isElementPresent(menuActiveMerchants);
        menuActiveMerchants.click();
        return new ActiveMerchantsPage(webDriver);
    }
    public InactiveMerchantsPage openInactiveMerchants(){
        menuMerchantsAndVouchers.click();
        isElementPresent(menuInactiveMerchants);
        menuInactiveMerchants.click();
        return new InactiveMerchantsPage(webDriver);
    }
*/

    public LoginPage logout(){
        logoutButton.click();
        return new LoginPage(webDriver);
    }
    public boolean isVisible() {
        return isElementPresent(logoutButton);
    }


    @FindBy(xpath = "/html/body/div/div[1]/div/div[2]/nav/ul/li[1]/a/span[2]")
    public WebElement homeMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[2]/a/span[3]")
    public WebElement merchantsMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[3]/a/span[3]")
    public WebElement usersMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[4]/a/span[2]")
    public WebElement organizationsMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[5]/a")
    public WebElement appManagementMenuButton;
    @FindBy(how = How.XPATH, using = "/html/body/div/div[1]/div/div[2]/nav/ul/li[5]/ul/li")
    public List<WebElement> appManagementSubButtons;




/*    private void openDropdown(String menuItem){
        for(WebElement webElement : menuItems){
            if(webElement.getText().equals(menuItem)){
                webElement.click();
                break;
            }
        }
    }
    private void chooseElement(String menuSubItem){
        for(WebElement webElement : menuSubItems){
            if(webElement.getText().equals(menuSubItem)){
                webElement.click();
                break;
            }
        }
    }
    public void openPage(String menuItem,String menuSubItem){
        openDropdown(menuItem);
        areElementsPresent(menuSubItems);
        chooseElement(menuSubItem);
    }
    */

}
