import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static String expectedBrandName;
    private static String actualBrandName;
    private final WebDriver WEB_DRIVER;

    public HomePage(WebDriver WEB_DRIVER) {
        this.WEB_DRIVER = WEB_DRIVER;
    }

    public void accept_cookie() {
        WEB_DRIVER.findElement(By.xpath("/html/body/div[1]/div[6]/div[1]/div/button"))
                .click();
    }

    public void start_search(String clothesName) {
        WebElement searchButton = WEB_DRIVER
                .findElement(By.xpath("//*[@id=\"menu-wrapper\"]/div/div/div/div/button"));
        searchButton.click();
        WebElement searchField = WEB_DRIVER
                .findElement(By.xpath("//*[@id=\"menu-wrapper\"]/div/div/div/div/input"));
        searchField.sendKeys(clothesName);
        searchButton.click();
    }

    public void clickFirstImage() {
        WebDriverWait waiter =
                new WebDriverWait(WEB_DRIVER, Duration.ofSeconds(30));
        waiter.until(ExpectedConditions
                .elementToBeClickable(By.className("products-list-item__type"))).click();
    }

    public void chooseTheSize() {
        WebDriverWait waiter =
                new WebDriverWait(WEB_DRIVER, Duration.ofSeconds(30));
        waiter.until(ExpectedConditions
                        .elementToBeClickable(By.xpath(
                                "//*[@id=\"vue-root\"]/x-app-content/div[1]/div[2]/div[2]/div/div[3]" +
                                        "/div/div[4]/div/div/div[1]/div[1]")))
                .click();
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(
                        "//*[@id=\"vue-root\"]/x-app-content/div[1]/div[2]/div[2]/div/div[3]" +
                                "/div/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div[2]")))
                .findElements(By.xpath(
                        "//*[@id=\"vue-root\"]/x-app-content/div[1]/div[2]/div[2]/div/div[3]" +
                                "/div/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div[2]"))
                .get(0).click();
    }

    public void clickAddButton() {
        expectedBrandName = WEB_DRIVER.findElement(By.xpath(
                "//*[@id=\"vue-root\"]/x-app-content/div[1]/div[2]/div[2]/div/div[2]/div/h1/a")).getText();
        WEB_DRIVER.findElement(By.xpath("//*[@id=\"vue-root\"]/x-app-content/div[1]" +
                "/div[2]/div[2]/div/div[3]/div/div[5]/button")).click();
    }


    public void assert_that_clothes_have_been_added_to_cart() {
        WebDriverWait waiter =
                new WebDriverWait(WEB_DRIVER, Duration.ofSeconds(30));
        actualBrandName = waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                "/html/body/div[1]/div[10]/div/div/div[2]/div[1]/div[1]/div[1]/b"))).getText();
        Assert.assertEquals(expectedBrandName, actualBrandName);
        WEB_DRIVER.quit();
    }
}
