package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import java.util.concurrent.TimeUnit;

public class DriverSetup {
    public String LocalChromeDrive = null;
    public String LocalFirefoxDrive = null;
    public String LocalEdgeDrive = null;
    public String LocalOperaDrive = null;

    public void Validator (){
        String OS = System.getProperty("os.name").toLowerCase();
        boolean IS_WINDOWS = (OS.contains("win"));
        boolean IS_MAC = (OS.contains("mac"));
        boolean IS_UNIX = (OS.contains("nix")  || OS.contains("nux")  || OS.contains("aix") );

        if (IS_WINDOWS) {
            LocalChromeDrive = "\\src\\main\\resources\\win\\chromedriver.exe";
            LocalFirefoxDrive = "\\src\\main\\resources\\win\\geckodriver";
            LocalEdgeDrive = "\\src\\main\\resources\\win\\msedgedriver";
            LocalOperaDrive = "\\src\\main\\resources\\win\\operadriver";
        } else if (IS_MAC) {
            LocalChromeDrive = "/src/main/resources/ios/chromedriver";
            LocalFirefoxDrive = "/src/main/resources/ios/geckodriver";
            LocalEdgeDrive = "/src/main/resources/ios/msedgedriver";
            LocalOperaDrive = "/src/main/resources/ios/operadriver";

        } else if (IS_UNIX) {
            LocalChromeDrive = "/src/main/resources/linux/chromedriver";
            LocalFirefoxDrive = "/src/main/resources/linux/geckodriver";
            LocalEdgeDrive = "/src/main/resources/linux/msedgedriver";
            LocalOperaDrive = "/src/main/resources/linux/operadriver";
        } else {
            System.out.println("Your OS is not support!!");
        }
    }
   WebDriver driver;

    public DriverSetup(){
        Validator();
        //Chamada para executar o teste no Chrome
        setDefaultChromeDriverPath();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Chamada para executar o teste no Firefox
        //setDefaultGeckoDriverPath();
        //driver = new FirefoxDriver();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

        //Chamada para executar o teste no Edge
        //setDefaultMsEdgeDriverPath();
        //driver = new EdgeDriver();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

        //Chamada para executar o teste no Opera
        //setDefaultOperaDriverPath();
        //driver = new OperaDriver();
        //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

    }

    public WebDriver getDriver(){
        return driver;
    }

    public void loadPage(String webApllication){

    }

    public void setDefaultChromeDriverPath(){

        setCustomDriverPath(System.getProperty("user.dir") + LocalChromeDrive);
    }
    public void setDefaultGeckoDriverPath(){

        setCustomDriverPath(System.getProperty("user.dir") + LocalFirefoxDrive);
    }
    public void setDefaultMsEdgeDriverPath(){

        setCustomDriverPath(System.getProperty("user.dir") + LocalEdgeDrive);
    }
    public void setDefaultOperaDriverPath(){

        setCustomDriverPath(System.getProperty("user.dir") + LocalOperaDrive);
    }

    public void setCustomDriverPath(String pathDriver){
        pathDriver = System.getProperty("user.dir") + LocalChromeDrive;
        System.setProperty("webdriver.chrome.driver", pathDriver);
        System.out.println("webdriver.chrome.driver:" + pathDriver);
    }

}
