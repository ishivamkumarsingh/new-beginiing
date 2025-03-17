package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CourseSearchPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    private By iframe = By.id("courses-iframe");
    private By searchField = By.id("search-courses");
    private By searchButton = By.xpath("//button[contains(@class, 'search-course')]");
    private By searchResults = By.xpath("//div[contains(@class, 'course-listing-title')]");

    // Constructor
    public CourseSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // ✅ Updated
    }

    // Switch to iframe
    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
    }

    // Perform search
    public void searchCourse(String courseName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchField));
        searchBox.clear();
        searchBox.sendKeys(courseName);
        driver.findElement(searchButton).click();
    }

    // Verify search result
    public boolean isSearchSuccessful() {
        return driver.findElements(searchResults).isEmpty();
    }
}
