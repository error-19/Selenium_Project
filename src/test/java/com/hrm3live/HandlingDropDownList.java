package com.hrm3live;import io.github.bonigarcia.wdm.WebDriverManager;import org.openqa.selenium.By;import org.openqa.selenium.WebDriver;import org.openqa.selenium.JavascriptExecutor;import org.openqa.selenium.WebElement;import org.openqa.selenium.firefox.FirefoxDriver;import org.openqa.selenium.support.ui.Select;import java.time.Duration;public class HandlingDropDownList {    public static WebDriver driver;    public static void main(String[] args) {        WebDriverManager.firefoxdriver().setup();        driver=new FirefoxDriver();        driver.get("https://demoqa.com/select-menu");        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));        JavascriptExecutor js = (JavascriptExecutor) driver;        js.executeScript("window.scrollBy(0,150)","");        WebElement element=driver.findElement(By.id("oldSelectMenu"));        Select select=new Select(element);//        select.selectByValue("4");         select.selectByIndex(3);//        select.selectByVisibleText("Blue");    }    //My name is Shamim Sorkar}