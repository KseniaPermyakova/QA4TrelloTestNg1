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

    @FindBy (xpath = "//h2")
    List<WebElement> listHeaders;

    @FindBy (css = ".list-name-input")
    WebElement listInputNameField;

    @FindBy (xpath = "//a[@class='js-close-list']")
    WebElement archiveButton;

    @FindBy (xpath = "//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']")
    List<WebElement> menuListButtons;

    @FindBy (xpath = "//a[@class='js-copy-list']")
    WebElement copyListButton;

    @FindBy (css = ".js-submit")
    WebElement createCopyListButton;

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
        addButton.click();
        waitUntilElementIsClickable(listInputNameField, 30);
        listInputNameField.sendKeys(name);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        waitUntilElementIsClickable(By.cssSelector("a.js-cancel-edit"), 10);
        driver.findElement(By.cssSelector("a.js-cancel-edit")).click();
    }

    public String getAddButtonName() {
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
        return listHeaders.size();
    }

    public void openMenuListActions() {
        WebElement listActions = driver.findElement(By.xpath("//a[@class='list-header-extras-menu dark-hover js-open-list-menu icon-sm icon-overflow-menu-horizontal']"));
        listActions.click();
    }

    public void deleteList() {
        waitUntilElementIsClickable(archiveButton, 30);
        archiveButton.click();
        waitUntilElementIsClickable(addButton, 30);
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
        waitUntilElementIsClickable(menuListButtons.get(0), 30);
        menuListButtons.get(0).click();
        waitUntilElementIsClickable(copyListButton, 20);
        copyListButton.click();
        waitUntilElementIsClickable(createCopyListButton, 30);
        createCopyListButton.click();
        waitUntilElementIsClickable(addButton, 30);
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
