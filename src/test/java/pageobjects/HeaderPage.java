package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class HeaderPage {
    
    WebDriver driver;

    // Locators for navigation sections
    @FindBy(xpath = "//nav//a")  
    private List<WebElement> navigationLinks;

    // Constructor
    public HeaderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to verify if a navigation section exists
    public boolean isNavigationSectionDisplayed(String sectionName) {
        for (WebElement link : navigationLinks) {
            if (link.getText().trim().equalsIgnoreCase(sectionName)) {
                return link.isDisplayed();
            }
        }
        return false; // Section not found
    }
}
