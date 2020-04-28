package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class StepDefinitions {
    Random rnd = new Random();
    WebDriver driver;
    String message;
    String actualResult;
    //String[] testCase;
    String testCase;

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

    @And("has test case {string}")
    public void hasTestCase(String arg0) {
        testCase = arg0;
    }

    @And("has entered username {string}")
    public void hasEnteredUsername(String username) {

        //generate unique username for the "happy case"
        if (testCase.equals("TC1")) {
            username = rnd.nextInt(100) + username;
        }
        try {
            driver.findElement(By.name("username")).sendKeys(username);
        } catch (Exception e) {
            System.out.println("Could not fill in Username");
        }
    }

    @And("has entered email {string}")
    public void hasEnteredEmail(String email) {
        //generate unique username for the "happy case"
        if (testCase.equals("TC1")) {
            email = rnd.nextInt(100) + email;
        }

        try {
            driver.findElement(By.id("email")).sendKeys(email);
        } catch (Exception e) {
            System.out.println("Could not fill in email");
        }
    }

    @And("has entered password {string}")
    public void hasEnteredPassword(String password) {
        try {
            driver.findElement(By.cssSelector("form > div:nth-of-type(3) > div > input")).sendKeys(password);
        } catch (Exception e) {
            System.out.println("Could not fill in email");
        }
    }

    @And("has entered confirmed password {string}")
    public void hasEnteredConfirmedPassword(String passwordConfirmed) throws InterruptedException {
        try {
            driver.findElement(By.cssSelector("input[name='password-confirm']")).sendKeys(passwordConfirmed);
        } catch (Exception e) {
            System.out.println("Could not fill in passwordConfirmed");
        }
        Thread.sleep( 2000);
    }

    @When("he clicks to registrate")
    public void heClicksToRegistrate() throws InterruptedException {
        // submit form
        try {
        driver.findElement(By.id("register")).click();
        } catch (Exception e) {
            System.out.println("Could not click on \"Registration\" button");
        }
        Thread.sleep( 2000);
    }

    @Then("he gets {string}")
    public void he_gets(String expectedResult) {
        // Assert results according to the test case
        try {
            switch (testCase) {
                case "TC1": //#Skapa användare​
                    actualResult = driver.getCurrentUrl();
                    break;

                case "TC2": //#Skapa användare – långt användarnamn (mer än 16 tecken)​
                    actualResult = driver.findElement(By.id("username-notify")).getText();
                    break;

                case "TC3": //#Skapa användare – lösenord och bekräfta lösenord skiljer sig​
                    actualResult = driver.findElement(By.id("password-confirm-notify")).getText();
                    break;

                case "TC4": //#Skapa användare – E-postadress är redan använd​
                    actualResult = driver.findElement(By.id("email-notify")).getText();
                    break;
            }
        } catch (Exception e) {
            System.out.println(testCase + "did not pass");
        }

        Assert.assertEquals(expectedResult, actualResult);
        driver.close();
    }
}
