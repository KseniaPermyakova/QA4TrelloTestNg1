package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {

    @Test
    public void loginToTrelloPositive() throws InterruptedException {

        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(5000);

        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("ksyshenjkateplova@gmail.com");

        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("password")).sendKeys("ghjkG562");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(20000);

    }

    @Test
    public void loginIncorrectPassNegative() throws InterruptedException {

        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(5000);

        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("ksyshenjkateplova@gmail.com");

        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);

        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("password")).sendKeys("hgnbjbkbk");
        driver.findElement(By.id("login-submit")).click();
        Thread.sleep(5000);

        System.out.println(driver.findElement(By.id("login-error")).getText());

    }

    @Test
    public void loginIncorrectLoginNegative() throws InterruptedException {

        WebElement loginIcon = driver.findElement(By.xpath("//a[@class='btn btn-sm btn-link text-white']"));
        loginIcon.click();
        Thread.sleep(5000);

        WebElement userField = driver.findElement(By.id("user"));
        userField.click();
        userField.clear();
        userField.sendKeys("fhgjhjhkjk@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys("jgnnbjbhg");

        driver.findElement(By.id("login")).click();
        Thread.sleep(5000);

        System.out.println(driver.findElement(By.xpath("//p[@class='error-message']")).getText());
    }

}
