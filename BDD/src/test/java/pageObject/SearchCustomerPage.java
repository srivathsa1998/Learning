package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {

    public WebDriver ldriver;

    public SearchCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this); //Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns. In Page Factory, testers use @FindBy annotation. The initElements method is used to initialize web elements.
    }

    @FindBy(xpath = "//input[@id='SearchEmail']")
    @CacheLookup
    WebElement searchEmail;

    @FindBy(xpath = "//button[@id='search-customers']")
    @CacheLookup
    WebElement searchButton;

    @FindBy(xpath = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
    @CacheLookup
    List<WebElement> tableRow;

    @FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
    @CacheLookup
    List<WebElement> tableCol;

    public void setEmail(String email) {
        searchEmail.clear();
        searchEmail.sendKeys(email);
    }

    public void setSearchButton() {
        searchButton.click();
    }

    public int getRows() {
        return (tableRow.size());
    }

    public int getCols() {
        return (tableCol.size());
    }

    public boolean searchCustByEmail(String email) {
        boolean flag = false;

        for (int i = 1; i <= getRows(); i++) {
            String emailId = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[\"+i+\"]/td[2]")).getText();
            System.out.println(emailId);

            if (emailId.equals(email)) {
                flag = true;
            }

        }
        return flag;
    }
}

