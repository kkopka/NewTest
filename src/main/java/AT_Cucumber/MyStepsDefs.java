package AT_Cucumber;


import Pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepsDefs {
    public static WebDriver driver;
    public static WebDriverWait wait;
    MobilePhonePage mobilePhonePage;
    StartedPage startedPage;

    @Допустим("^пользователь зашел на сайт Ozon$")
    public void пользовательЗашелНаСайтOzon() throws InterruptedException {
        startedPage = new StartedPage(driver);
        startedPage.openOzon();
    }

    @И("^зашел в категорию электроника$")
    public void зашелВКатегориюЭлектроника() {
        startedPage.clickElectronic();
    }

    @Тогда("^он зашел в подкатегорию смартфоны$")
    public void онЗашелВПодкатегориюСмартфоны() {
        ElectronicPage electronicPage = new ElectronicPage(driver);
        electronicPage.clickMobilePhoneIcon();
    }

    @И("^установил цену от \"([^\"]*)\" р$")
    public void установилЦенуОтР(String setPrice) {
        mobilePhonePage = new MobilePhonePage(driver, wait);
        mobilePhonePage.setPrice(setPrice);
    }

    @И("^выбрал смарфон xiaomi$")
    public void выбралСмарфонXiaomi() {
        mobilePhonePage.choseXiaomi();
    }


    @Ктомуже("^положил в корзину один из телефонов$")
    public void положилВКорзинуОдинИзТелефонов() {
        mobilePhonePage.AddRandomPhoneAtBasket();
    }

    @И("^переходит в корзину$")
    public void переходитВКорзину() {
        BasketPage basketPage = new BasketPage(driver, wait);
        basketPage.clickButtonBasket();
    }
}
