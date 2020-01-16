package tests;

import helpers.HomePageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static final String LOGIN = "ksyshenjkateplova@gmail.com";
    public static final String PASSWORD = "ghjkG562";
    WebDriver driver;
    HomePageHelper homePage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        //===========Enter to Trello====
        driver.manage().window().fullscreen();
        driver.get("https://trello.com/");
        homePage.waitUntilPageIsLoaded();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
