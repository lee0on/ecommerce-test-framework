package com.ecomauto.base;

import com.ecomauto.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

@ExtendWith(EcommTestWatcher.class)
public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = DriverFactory.createDriver();
    }

    @AfterEach
    public void teardown(){
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}
