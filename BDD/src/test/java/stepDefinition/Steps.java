package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObject.AddCustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;


public class Steps extends BaseClass{
    public WebDriver driver;
    public LoginPage lp;
    @Given("User Launch Chrome Browser")
    public void user_Launch_Chrome_Browser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\SR091504\\Downloads\\spring-crud-master\\BDD\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        lp=new LoginPage(driver);
        driver.manage().window().maximize();
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) {
        driver.get(url);

    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) {

        lp.setUserName(email);
        lp.setPassword(pwd);
    }

    @When("Click on Login")
    public void click_on_Login() {

        lp.clickLogin();
    }


    @Then("page title should be {string}")
    public void page_title_should_be(String title) {

        if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")){
            driver.close();
            Assert.assertTrue(false);
        }
        else {
            Assert.assertEquals(title,driver.getTitle());
        }

    }

    @When("user click on log out link")
    public void user_click_on_log_out_link() throws InterruptedException {

        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("close browser")
    public void close_browser() {

        driver.quit();
    }

    //Customer feature step definitions----------------------

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        addCust=new AddCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() throws InterruptedException {
        Thread.sleep(3000);
        addCust.clickOnCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() throws InterruptedException {
        Thread.sleep(2000);
        addCust.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() throws InterruptedException {
        addCust.clickOnAddnew();
        Thread.sleep(2000);
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
       Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {
        addCust.setEmail("xyz@gmail.com");
        addCust.setPassword("test1234");
        addCust.setFirstName("Alex");
        addCust.setLastName("S");
        addCust.setGender("Male");
        addCust.setDob("7/05/1986");
        addCust.setCompanyName("AwesomeQA");
        addCust.setManagerOfVendor("Vendor 2");
        addCust.setAdminContent("This is for testing");
        //addCust.setCustomerRoles("Guest");
        Thread.sleep(3000);
    }

    @When("click on Save button")
    public void click_on_save_button() throws InterruptedException {
        addCust.clickOnSave();
        Thread.sleep(2000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
    }

    //Search customer by EmailId
    @When("Enter customer Email")
    public void enter_customer_email() {
        searchCust=new SearchCustomerPage(driver);
        searchCust.setEmail("xyz@gmail.com");
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.setSearchButton();
        Thread.sleep(3000);
    }

    @Then("User should find in Email in the Search Table")
    public void user_should_find_in_email_in_the_search_table() {
        boolean status=searchCust.searchCustByEmail("xyz@gmail.com");
        Assert.assertEquals(true,status);
    }

}
