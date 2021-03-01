package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElectronicPage {
    private WebDriver driver;

    By mobilePhoneIcon=By.xpath("//a[@href='https://www.ozon.ru/category/smartfony-15502/']");

    public ElectronicPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMobilePhoneIcon(){
        driver.findElement(mobilePhoneIcon).click();
    }
}
