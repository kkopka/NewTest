package AT_Cucumber;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bin\\chromedriver.exe");
        MyStepsDefs.driver = new ChromeDriver();
        MyStepsDefs.wait = new WebDriverWait(MyStepsDefs.driver, 10);
        MyStepsDefs.driver.manage().window().maximize();
        MyStepsDefs.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyStepsDefs.driver.close();

    }
}
