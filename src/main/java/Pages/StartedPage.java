package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartedPage {
    private WebDriver driver;
    @FindBy(xpath = "//a[text()='Электроника']")
    private WebElement electronicIcon;
    public StartedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void openOzon(){
        driver.get("https://www.ozon.ru/");
        Assert.assertTrue(driver.getTitle().equals("OZON — интернет-магазин. Миллионы товаров по выгодным ценам"));
    }

    public void clickElectronic(){
        electronicIcon.click();
    }
}
