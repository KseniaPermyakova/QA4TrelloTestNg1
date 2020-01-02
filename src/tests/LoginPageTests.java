package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @Test
    public void loginToTrelloPositive() throws InterruptedException {
        //----Login to trello----

        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        //Thread.sleep(5000);
        loginIcon.click();
        waitUntilElementIsClickable(By.id("login"),30);
        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("ksyshenjkateplova@gmail.com");
        driver.findElement(By.id("login")).click();
        //Thread.sleep(5000);
        waitUntilElementIsClickable(By.id("login-submit"),30);
        driver.findElement(By.id("login-submit")).click();
        //Thread.sleep(3000);
        waitUntilElementIsVisible(By.id("password"), 30);

        driver.findElement(By.id("password")).sendKeys("ghjkG562");
        waitUntilElementIsClickable(By.id("login-submit"),30);
        driver.findElement(By.id("login-submit")).click();
        //Thread.sleep(30000);
        waitUntilElementIsClickable(By
                .xpath("//button[@data-test-id='header-boards-menu-button']"),30);

        Assert.assertTrue(driver.findElement(By.xpath("//button[@data-test-id='header-boards-menu-button']"))
                .isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@class='boards-page-board-section-header-name']"))
                .getText().equals("Personal Boards"));

    }

    @Test
    public void loginIncorrectPassNegative() throws InterruptedException {

        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        waitUntilElementIsClickable(By.id("login"), 30);
//        Thread.sleep(5000);

        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("ksyshenjkateplova@gmail.com");

        driver.findElement(By.id("login")).click();
        waitUntilElementIsClickable(By.id("login-submit"), 30);
//        Thread.sleep(5000);

        driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsVisible(By.id("password"), 30);
//        Thread.sleep(3000);
        driver.findElement(By.id("password")).sendKeys("hgnbjbkbk");
        waitUntilElementIsClickable(By.id("login-submit"), 30);
        driver.findElement(By.id("login-submit")).click();
        waitUntilElementIsVisible(By.xpath("//div[@id='login-error']/span"), 10);
//        Thread.sleep(5000);

//        System.out.println("Error message: " + driver.findElement(By.id("login-error")).getText());

        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='login-error']/span"))
                .getText().contains("Incorrect email address and / or password."));

    }

    @Test
    public void loginIncorrectLoginNegative() throws InterruptedException {

        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        waitUntilElementIsClickable(By.id("login"), 30);
//        Thread.sleep(5000);

        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("fhgjhjhkjk@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("jgnnbjbhg");
        waitUntilElementIsClickable(By.id("login"), 3);
        driver.findElement(By.id("login")).click();
        waitUntilElementIsVisible(By.xpath("//p[@class='error-message']"), 30);
//        Thread.sleep(5000);

//        System.out.println(driver.findElement(By.xpath("//p[@class='error-message']")).getText());

        Assert.assertTrue(driver.findElement(By.xpath("//p[@class='error-message']"))
                .getText().contains("There isn't an account for this email"));
    }

}
