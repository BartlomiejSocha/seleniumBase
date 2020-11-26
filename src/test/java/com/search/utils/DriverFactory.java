package com.search.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.File;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();

    public static WebDriver getDriver() {

        if(driverInstance.get()==null) {
            File chromeExe = new File("src//test//resources//executables//drivers//chromedriver.exe");
            ChromeDriverService chromeService = new ChromeDriverService.Builder()
                .usingDriverExecutable(chromeExe)
                .usingAnyFreePort().build();
            driverInstance.set(new ChromeDriver(chromeService));

            driverInstance.get().manage().window().maximize();
        }
        return driverInstance.get();
    }
}
