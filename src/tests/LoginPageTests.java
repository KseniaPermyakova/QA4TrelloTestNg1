package tests;

import helpers.BoardsPageHelper;
import helpers.HomePageHelper;
import helpers.LoginPageHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTests extends TestBase {
    HomePageHelper homePage;
    LoginPageHelper loginPage;
    BoardsPageHelper boardsPage;

    @BeforeMethod
    public void initTests() {
        homePage = new HomePageHelper(driver);
        loginPage = new LoginPageHelper(driver);
        boardsPage = new BoardsPageHelper(driver);
    }

    @Test
    public void loginToTrelloPositive() {

        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTrelloAsAtlassian(LOGIN, PASSWORD);
        boardsPage.waitUntilPageIsLoaded();

        Assert.assertTrue(boardsPage.verifyIfBoardsIconIsDisplayed());
        Assert.assertTrue(boardsPage.verifyIfPersonalBoardsHeaderIsDisplayed());

    }

    @Test
    public void loginIncorrectPassNegative() {

        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTrelloAsAtlassian(LOGIN, PASSWORD + "1");
        loginPage.waitPasswordError();

        Assert.assertTrue(loginPage.verifyIfPasswordErrorIsCorrect(), "Error message is not correct");

    }

    @Test
    public void loginIncorrectLoginNegative() {

        homePage.openLoginPage();
        loginPage.waitUntilPageIsLoaded();
        loginPage.loginToTrello(LOGIN+"1", PASSWORD);
        loginPage.waitLoginError();

        Assert.assertTrue(loginPage.verifyIfLoginErrorIsCorrect(), "Error login message is not correct");
    }
}
