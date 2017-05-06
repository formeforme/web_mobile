package Pages.Login;

import Pages.HomePage.HomePage;
import Pages.State;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends State {
    @FindBy(xpath = LoginPageConst.USERNAME_FIELD)
    private WebElement usernameField;
    @FindBy(xpath = LoginPageConst.PASSWORD_FIELD)
    private WebElement passwordField;
    @FindBy(xpath = LoginPageConst.LOGIN_BUTTON)
    private WebElement loginButton;

    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }
    public void login(String username, String password){
        clearUsernameField();
        clearPasswordField();
        setUsername(username);
        setPassword(password);
        pressloginButton();
    }
    public HomePage login(User user){
        clearUsernameField();
        clearPasswordField();
        setUsername(user.getUsername());
        setPassword(user.getPassword());
        return pressloginButton();
    }

    public void setUsername(String username){
        usernameField.sendKeys(
                String.valueOf(username));
    }
    public void setPassword(String password){
        passwordField.sendKeys(
                String.valueOf(password));
    }
    public String getUsername(){
        return usernameField.getText();
    }
    public String getPassword(){
        return passwordField.getText();
    }
    public void clearUsernameField(){
        usernameField.clear();
    }
    public void clearPasswordField(){
        passwordField.clear();
    }
    public HomePage pressloginButton(){
        loginButton.click();
        return new HomePage(webDriver);
    }

    public boolean isVisible(){
        return isElementPresent(loginButton);
    }
}
