package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CurrentBoardPageHelper extends PageBase {
    String name;
    @FindBy (css = ".placeholder")
    WebElement addButton;

    @FindBy (xpath = "//span[@dir='auto']")
    WebElement fieldNameList;

    public CurrentBoardPageHelper(WebDriver driver) {
        super(driver);
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void waitUntilPageIsLoaded() {
        waitUntilElementIsClickable(addButton, 30);
    }

    public boolean titleVerification() {
        return fieldNameList.getText().equals(name);
    }

    public void createNewList(String name) {
        WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        addListButton.click();
        waitUntilElementIsVisible(By.cssSelector(".list-name-input"), 10);
        driver.findElement(By.cssSelector(".list-name-input"))
                .sendKeys(name);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        waitUntilElementIsClickable(By.cssSelector("a.js-cancel-edit"), 10);
        driver.findElement(By.cssSelector("a.js-cancel-edit")).click();
    }

    public String getAddButtonName() {
 //       WebElement addListButton = driver.findElement(By.cssSelector(".placeholder"));
        return addButton.getText();
    }

    public boolean existList(String nameList) {
        boolean exitName = false;
        for (WebElement element : driver.findElements(By.xpath("//h2/../textarea"))) {
            if (element.getText().equals(nameList)) {
                exitName = true;
            }
        }
        return exitName;
    }

    public int getQuantityLists() {
        return driver.findElements(By.xpath("//h2")).size();
    }

    public void openMenuListActions() {
        WebElement listActions = driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"));
        listActions.click();
    }

    public void deleteList() {
        waitUntilElementIsClickable(By.xpath("//a[@class='js-close-list']"), 30);
        driver.findElement(By.xpath("//a[@class='js-close-list']")).click();
        waitUntilElementIsClickable(By.xpath("//span[@class='placeholder']"), 30);
    }

    public int getQuantityListsWithNameOfList1(String name) {
        int countAtFirst = 0;
        for(WebElement element: driver.findElements(By.xpath("//h2/../textarea"))) {
            if(element.getText().equals(name)) {
                countAtFirst++;
            }
        }
        return countAtFirst;
    }

    public String getNameOfList1() {
        return driver.findElements(By.xpath("//h2/../textarea")).get(0).getText();
    }

    public void createCopyOfTheList() {
        waitUntilElementIsClickable(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"), 30);
        driver.findElements(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"))
                .get(0).click();

        waitUntilElementIsClickable(By.xpath("//a[@class='js-copy-list']"), 20);
        driver.findElement(By.xpath("//a[@class='js-copy-list']")).click();

        waitUntilElementIsClickable(By.cssSelector(".js-submit"), 30);
        driver.findElement(By.cssSelector(".js-submit")).click();
        waitUntilElementIsClickable(By.cssSelector(".placeholder"), 30);
    }

    public void clickLastAddCardButton() {
        waitUntilAllElementsAreVisible(By.xpath("//span[@class = 'js-add-a-card']"),15);
        List<WebElement> listAddCardButtons = driver.findElements(By.xpath("//span[@class = 'js-add-a-card']"));
        int sizeListAddCardButtons = listAddCardButtons.size();
        WebElement lastAddCardButton = listAddCardButtons.get(sizeListAddCardButtons-1);
        lastAddCardButton.click();
    }

    public void addFirstCard() {
        waitUntilElementIsClickable(By
                .xpath("//input[@class='primary confirm mod-compact js-add-card']"),10);
        driver.findElement(By
                .xpath("//textarea[@placeholder='Enter a title for this card…']")).sendKeys("text");
        driver.findElement(By
                .xpath("//input[@class='primary confirm mod-compact js-add-card']")).click();

        waitUntilElementIsClickable(By.cssSelector("a.js-cancel"),10);
        driver.findElement(By.cssSelector("a.js-cancel")).click();
    }

    public int getQuantityAddAnotherCardButtons() {
        waitUntilAllElementsAreVisible(By.xpath("//span[@class= 'js-add-another-card']"),10);
        return driver.findElements(By.xpath("//span[@class= 'js-add-another-card']")).size();
    }
}
