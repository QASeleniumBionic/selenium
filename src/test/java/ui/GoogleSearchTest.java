package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
/**
 * Created by Sergii.Oliinyk on 11/3/2014.
 */
public class GoogleSearchTest {
    WebDriver driver;

    //Preconditions
    @BeforeClass
    public void setUp() {

        //Initializes a browser
        driver = new FirefoxDriver();

        //Sets implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Maximizes a window size
        driver.manage().window().maximize();

        //Opens a url
        driver.get("https://www.google.com.ua");
    }

    @Test
    public void searchTest() {

        //Finds an element by name
        WebElement searchField = driver.findElement(By.name("q"));

        // Sends "Selenium" text into an input field
        searchField.sendKeys("Selenium");

        //Finds first link with specified result
        WebElement seleniumLink = driver.findElement(By.xpath(".//*[@id='rso']/div/li[1]/div/h3/a"));

        //Verifies a result
        Assert.assertEquals(seleniumLink.getText().toString().contains("Selenium"), true);
    }

    @AfterClass
    public void tearDown() {
        //Closes a browser
        driver.quit();
    }
}