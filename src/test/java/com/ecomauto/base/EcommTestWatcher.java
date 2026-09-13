package com.ecomauto.base;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Optional;

public class EcommTestWatcher implements TestWatcher, BeforeTestExecutionCallback {

    private static final Logger log = LoggerFactory.getLogger(EcommTestWatcher.class);

    @Override
    public void testFailed(ExtensionContext context, Throwable cause){
        BaseTest baseTest = (BaseTest) context.getRequiredTestInstance();
        WebDriver driver = baseTest.getDriver();
        String testName = context.getDisplayName();

        log.error("Test failed: {}", testName);
        log.error("Cause: {}", cause.getMessage());

        TakesScreenshot camera = (TakesScreenshot) driver;
        byte[] screenshot = camera.getScreenshotAs(OutputType.BYTES);
        try {
            Files.createDirectories(new File("target/screenshots").toPath());
            Files.write(new File(
                    "target/screenshots/"
                    + context.getRequiredTestClass().getSimpleName()
                    + testName
                    + ".png").toPath(), screenshot);
        } catch (IOException exception){
            log.error("File error:", exception);
        }
        InputStream allureAttachment = new ByteArrayInputStream(screenshot);
        Allure.addAttachment(testName, "image/png", allureAttachment, "png");
    }

    @Override
    public void testSuccessful(ExtensionContext context){
        String testName = context.getDisplayName();
        log.info("Test successful: {}", testName);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause){
        String testName = context.getDisplayName();

        log.warn("Test aborted: {}", testName);
        log.warn("Cause: {}", cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason){
        String testName = context.getDisplayName();

        log.warn("Test disabled: {}", testName);
        reason.ifPresent(r -> log.warn("Reason: {}", r));
    }

    @Override
    public void beforeTestExecution(ExtensionContext context){
        String testName = context.getDisplayName();

        log.info("Test started: {}", testName);
    }
}
