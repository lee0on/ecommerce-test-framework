package com.ecomauto.pages;

import com.ecomauto.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By Slider = By.xpath("//@id=['slider-carousel']");
    private By SliderBtnBack = By.xpath("//@data-slide=[prev]");
    private By SliderBtnFwd = By.xpath("//@data-slide=[next]");

    public HomePage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void goToHome(){
        goTo("");
    }

    public void waitHomeVis(By Slider){
        WebElement element = driver.findElement(Slider);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}