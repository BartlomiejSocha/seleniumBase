package com.search.tests;

import com.search.utils.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GoogleSearchSecondTest {

    @Test
    public void searchForFacebookTest() {
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        DriverFactory.getDriver().get("https://www.google.com/");
        DriverFactory.getDriver().switchTo().frame(0);
        WebElement acceptButton = DriverFactory.getDriver().findElement(By.id("introAgreeButton"));
        acceptButton.click();
        DriverFactory.getDriver().switchTo().defaultContent();
        DriverFactory.getDriver().findElement(By.name("q")).sendKeys("Facebook");
        DriverFactory.getDriver().findElement(By.name("q")).sendKeys(Keys.ENTER);
        DriverFactory.getDriver().findElement(By.xpath("//h3//span[text()='Facebook – zaloguj się lub zarejestruj']")).click();
        System.out.println(DriverFactory.getDriver().getTitle());
    }
}
