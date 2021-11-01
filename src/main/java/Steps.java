import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    private static final WebDriver WEB_DRIVER;
    private static final HomePage HOME_PAGE;

    static {
        System.setProperty("webdriver.chrome.driver",
                "/home/danny/Projects/LamodaTest/src/main/resources/chromedriver");
        WEB_DRIVER = new ChromeDriver();
        HOME_PAGE = new HomePage(WEB_DRIVER);
    }

    @Given("url of Lamoda {string}")
    public void url_of_lamoda(String url) {
        WEB_DRIVER.get(url);
    }

    @When("website is open accept cookie")
    public void website_is_open_accept_cookie() {
        HOME_PAGE.accept_cookie();
    }

    @Then("start search {string}")
    public void start_search(String clothesName) {
        HOME_PAGE.start_search(clothesName);
    }

    @Then("click on first image")
    public void click_on_first_image() {
        HOME_PAGE.clickFirstImage();
    }

    @Then("choose the size")
    public void choose_the_size() {
        HOME_PAGE.chooseTheSize();
    }

    @Then("click add button")
    public void click_add_button() {

        HOME_PAGE.clickAddButton();
    }

    @Then("assert that clothes have been added to cart")
    public void assert_that_clothes_have_been_added_to_cart() {
        HOME_PAGE.assert_that_clothes_have_been_added_to_cart();
    }
}
