package com.ecomauto.pages;

import com.ecomauto.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected final  WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

   protected void click(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

   protected void sendKeys(String xpath, String keys){
       WebElement element = driver.findElement(By.xpath(xpath));
       wait.until(ExpectedConditions.elementToBeClickable(element));
       element.clear();
       element.sendKeys(keys);
   }
    protected void goTo(String url){
        String baseUrl = Config.get().baseUrl();
        String target = baseUrl + url;
        driver.get(target);
    }


}