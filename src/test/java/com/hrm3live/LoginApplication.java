package com.hrm3live;import io.github.bonigarcia.wdm.WebDriverManager;import org.openqa.selenium.By;import org.openqa.selenium.WebDriver;import org.openqa.selenium.chrome.ChromeDriver;import org.openqa.selenium.firefox.FirefoxDriver;import org.openqa.selenium.support.ui.ExpectedCondition;import org.openqa.selenium.support.ui.ExpectedConditions;import org.openqa.selenium.support.ui.WebDriverWait;import java.time.Duration;public class LoginApplication {    public static WebDriver driver;    public static void main(String[] args) throws InterruptedException {//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Documents\\Drivers\\geckodriver.exe");        WebDriverManager.firefoxdriver().setup();        driver=new FirefoxDriver();        driver.get("https://opensource-demo.orangehrmlive.com/");        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));        //for username        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));        boolean test=  driver.findElement(By.name("username")).isDisplayed();        System.out.println(test);        driver.findElement(By.name("username")).clear();        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");        //for password        WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(5));        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));        driver.findElement(By.name("password")).clear();        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");        Thread.sleep(500);//for login button        WebDriverWait wait3=new WebDriverWait(driver,Duration.ofSeconds(5));        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));        driver.findElement(By.xpath("//button[@type='submit']")).click();        Thread.sleep(500);        //condition check actual result and expected result:        String expectedTitle="OrangeHRM";        String actualTitle=driver.getTitle();        System.out.println("Actual Page Title:" + " " + actualTitle);        if(expectedTitle.equals(actualTitle)){            System.out.println("Loged In Successfully and it's home page");        }        driver.quit();    }}