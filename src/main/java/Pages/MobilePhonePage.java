package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class MobilePhonePage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//div[@class='_597t']//input")
    private WebElement priceField;
    @FindBy(xpath = "//a[@href='/category/smartfony-15502/?brand=32686750']//div[@class='_3eqP']")
    private WebElement xioamiIcon;
    @FindBy(xpath = "//a[@href='/category/smartfony-15502/?brand=32686750']//input")
    private WebElement chexBoxXiaomi;
    @FindBy(xpath = "//div[@class='a2j0 a3x4 b3p6 a3x5']/../../../..//a[@class='a2g0 tile-hover-target']")
    private WebElement namePhoneElement;
    private By waitFieldLocator = By.xpath("(//div[@class='_29hd _1GB4 _103h _1KAI'])[1]");
    private By buttonAdd = By.xpath("//div[@class='_29hd']");
    private By waitBasketIcon = By.xpath("//div[@class='a2j0 a3x4 b3p6 a3x5']");
    public static String namePhone = null;
    public MobilePhonePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait=wait;
        PageFactory.initElements(driver,this);
    }

    public void setPrice(String setPrice) {
        priceField.sendKeys(Keys.CONTROL + "a");
        priceField.sendKeys(Keys.DELETE);
        priceField.sendKeys(setPrice);
    }

    public void choseXiaomi() {
        xioamiIcon.click();
        if (!chexBoxXiaomi.getAttribute("checked").equals("true")) { // проверяем наличие чекбокса
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void AddRandomPhoneAtBasket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitFieldLocator));
        List<WebElement> ListAddBasketIcon = driver.findElements(buttonAdd);
        Collections.shuffle(ListAddBasketIcon);
        ListAddBasketIcon.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitBasketIcon));
        namePhone = namePhoneElement.getAttribute("text");
    }


}
