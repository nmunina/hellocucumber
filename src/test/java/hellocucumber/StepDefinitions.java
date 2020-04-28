package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinitions {
    WebDriver driver;
    String message;
    String actualResult;

    @Given("user is on {string}")
    public void user_is_on(String string) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/nmunina/dev/chromedriver2");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(string);
        Thread.sleep( 2000);

        // confirm cookies
        driver.findElement(By.id("cookie-continue-btn")).click();
    }

    @And("has entered username {string}")
    public void hasEnteredUsername(String username) {
        driver.findElement(By.name("username")).sendKeys(username);
    }

    @And("has entered email {string}")
    public void hasEnteredEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("has entered password {string}")
    public void hasEnteredPassword(String password) {
        driver.findElement(By.cssSelector("form > div:nth-of-type(3) > div > input")).sendKeys(password);
    }

    @And("has entered confirmed password {string}")
    public void hasEnteredConfirmedPassword(String arg0) throws InterruptedException {
        driver.findElement(By.cssSelector("input[name='password-confirm']")).sendKeys(arg0);
        Thread.sleep( 2000);
    }

    @When("he clicks to registrate")
    public void heClicksToRegistrate() throws InterruptedException {
        // When submit form
        driver.findElement(By.id("register")).click();
        Thread.sleep( 2000);
    }

    @Then("he gets {string}")
    public void he_gets(String expectedResult) {
        //String expectedResult = string;
        String[] testCase = expectedResult.split(":");
        switch (testCase[0]) {
            case "TC1": //#Skapa användare​
                message = driver.getCurrentUrl();
                actualResult = "TC1:" + message;
                break;

            case "TC2": //#Skapa användare – långt användarnamn (mer än 16 tecken)​
                message = driver.findElement(By.id("username-notify")).getText();
                actualResult = "TC2:" + message;
                break;

            case "TC3": //#Skapa användare – lösenord och bekräfta lösenord skiljer sig​
                message = driver.findElement(By.id("password-confirm-notify")).getText();
                actualResult = "TC3:" + message;
                break;

            case "TC4": //#Skapa användare – E-postadress är redan använd​
                message = driver.findElement(By.id("email-notify")).getText();
                actualResult = "TC4:" + message;
                break;
        }

        Assert.assertEquals(expectedResult, actualResult);
        System.out.println("then" + expectedResult);

        driver.close();

    }
}
