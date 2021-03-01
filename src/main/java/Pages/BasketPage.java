package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class BasketPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//a[@data-widget='cart']")
    private WebElement buttonBasket;
    @FindBy(xpath = "(//div[@class='a7m6 a7n2']//span)[1]")
    private WebElement locatorNamePhoneFromBasket;
    By waitButtonLocator = By.xpath("//span[@class='f-caption--bold a9c4']");

    public BasketPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void clickButtonBasket() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(waitButtonLocator));
        buttonBasket.click();
        if (!MobilePhonePage.namePhone.equals(locatorNamePhoneFromBasket.getAttribute("textContent"))) {
            try {
                throw new IOException();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
