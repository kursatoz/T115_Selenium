package test_day2;
/** test steps
 * 1-go to amazon.ca
 * 2-type on searching box "Java"
 * 3-click on prime_checkbox
 * 4-get numbers of products
 * 5-clear to searching box
 * 6-type on searching box "Java Books"
 * 7-click on prime_checkbox
 * 8-get numbers of products
 * 9-assert two searching products numbers are same
 *
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearch {
    WebDriver driver = new ChromeDriver();

@Test
    public void amazonSearch() throws InterruptedException {
        driver.get("https://www.amazon.ca/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        WebElement searchButton = driver.findElement(By.cssSelector("div[class='nav-search-submit nav-sprite']"));
        searchBox.sendKeys("Java");
        searchButton.click();
        WebElement freeShipping = driver.findElement(By.xpath("//*[@id='p_76/3276484011']/span/a"));
        freeShipping.click();
         Thread.sleep(3000);
        String productJavaNumberLabel = driver.findElement(By.xpath("//*[@id='search']/span/div/h1/div/div[1]/div/div/span[1]")).getText();
        String JavaNumber = productJavaNumberLabel.split(" ")[3];
        searchBox.clear();

        //_________________Second search
        searchBox.sendKeys("Java Books for OCA");
        searchButton.click();
         freeShipping.click();
        Thread.sleep(3000);
        String JavaBookForOCANumber = productJavaNumberLabel.split(" ")[3];
        Assert.assertEquals(JavaBookForOCANumber,JavaNumber);






    }

}
