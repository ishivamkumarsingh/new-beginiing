package stepdefinition;

import utility.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Map;

public class HeaderVerificationSteps {

    WebDriver driver = BaseClass.getDriver();

    @Given("I navigate to the application homepage")
    public void i_navigate_to_the_application_homepage() {
        driver.get("https://www.letskodeit.com/");
    }

    @Then("The webpage title should be {string}")
    public void the_webpage_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Page title verification failed!", expectedTitle, actualTitle);
    }

    @Then("The following navigation sections should be displayed")
    public void the_following_navigation_sections_should_be_displayed(List<String> expectedSections) {
        for (String section : expectedSections) {
            String xpath = "//nav//a[contains(text(),'" + section + "')]";
            WebElement navElement = driver.findElement(By.xpath(xpath));
            Assert.assertTrue("Navigation section '" + section + "' not found!", navElement.isDisplayed());
        }
    }
}
