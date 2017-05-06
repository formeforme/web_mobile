package Pages;

import WebDriverSupport.WebDriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public abstract class State {
    public abstract boolean isVisible();
    public boolean isElementPresent(WebElement element){
        WebDriver webDriver = WebDriverBase.getDriverInstance().getWebDriver();
        WebDriverWait wait = new WebDriverWait(webDriver,8);
        try{
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
