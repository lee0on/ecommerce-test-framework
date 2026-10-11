package com.ecomauto.components;

import com.ecomauto.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {

    public Header(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private static final String HEADER_ROOT_XPATH = "//*[@id='header']";
    private static final By HEADER_ROOT = By.xpath(HEADER_ROOT_XPATH);
    private static final By HOME_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[contains(@class,'home')]");
    private static final By PRODUCTS_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[@href='/products']");
    private static final By CART_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[@href='/view_cart']");
    private static final By LOGIN_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[@href='/login']");
    private static final By TEST_CASES_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[@href='/test_cases']");
    private static final By API_TESTING_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[@href='/api_list']");
    private static final By VIDEO_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[contains(@href,'https://www.youtube.com/')]");
    private static final By CONTACT_US_BUTTON = By.xpath(HEADER_ROOT_XPATH + "//*[@href='/contact_us']");
    private static final By LOGO = By.xpath(HEADER_ROOT_XPATH + "//*[contains(@src,'logo')]");

    public void clickProductsButton(){
        click(PRODUCTS_BUTTON);
    }

    public void clickCartButton(){
        click(CART_BUTTON);
    }

    public void clickLoginButton(){
        click(LOGIN_BUTTON);
    }

    public void clickTestCasesButton(){
        click(TEST_CASES_BUTTON);
    }

    public void clickApiTestingButton(){
        click(API_TESTING_BUTTON);
    }

    public void clickVideoButton(){
        click(VIDEO_BUTTON);
    }

    public void clickContactUsButton(){
        click(CONTACT_US_BUTTON);
    }

    public void clickLogo(){
        click(LOGO);
    }
}
