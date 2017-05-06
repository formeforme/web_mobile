package WebDriverSupport;

import Pages.Login.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.util.Properties;

public class WebDriverBase {
    private String URL;
    private BROWSER executeBrowser;
    private static WebDriver webDriver;
    private static WebDriverBase driverInstance = new WebDriverBase();
    private final String PROPERTIES_FILE = "data/data.properties";
    public static final String DATA_FILE = "data/data.xlsx";
    public static User user;

    public enum BROWSER {
        FIREFOX, CHROME, OPERA
    }

    private WebDriverBase(){
        initializeMembers();
    }

    private void initializeMembers() {
        try {
            FileInputStream stream = new FileInputStream(new File(PROPERTIES_FILE));
            //InputStream stream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE);
            Properties properties = new Properties();
            properties.load(stream);
            this.URL = properties.getProperty("URL");
            String browser = properties.getProperty("BROWSER");
            this.executeBrowser = BROWSER.valueOf(browser);
            user = new User();
            user.setUsername(properties.getProperty("USERNAME"));
            user.setPassword(properties.getProperty("PASSWORD"));
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public WebDriver getWebDriver(){
        return webDriver;
    }

    public static WebDriverBase getDriverInstance(){
        return driverInstance;
    }


    public void start(){
        if(webDriver != null) {
            return;
        }
        switch (executeBrowser){
            case CHROME:
                System.setProperty("webdriver.chrome.driver","./driver/chromedriver");
                webDriver = new ChromeDriver();
                webDriver.get(URL);
                webDriver.manage().window().maximize();

                break;
            case FIREFOX:
                System.setProperty("webdriver.firefox.marionette","./driver/geckodriver");
                webDriver = new FirefoxDriver();
                webDriver.get(URL);
                break;
            case OPERA:
                System.setProperty("webdriver.opera.driver","./driver/operadriver64");
                System.setProperty("opera.binary","./driver/operadriver64");

               // DesiredCapabilities c = DesiredCapabilities.opera();
               // c.setCapability("opera.binary", "./driver/operadriver64");
                webDriver = new OperaDriver();
                webDriver.get(URL);
                break;
        }
    }
    public void close(){
        if(webDriver != null) {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
        }
    }

}
