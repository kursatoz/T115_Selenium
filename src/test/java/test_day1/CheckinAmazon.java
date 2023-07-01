package test_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CheckinAmazon {
    static WebDriver driver = new ChromeDriver();
    public static void main(String[] args) {
        searchJavaBook();

/**
 * go to the amazon
 * search for "Java book"
 * filter price like less than 25
 * print out how many book exist less than 25$
 *
 */
    }
    public static void searchJavaBook(){
        String testData1 = "Java Book";
        driver.get("https://www.amazon.ca/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys(testData1, Keys.ENTER);
       // driver.findElement(By.cssSelector("span[class='a-price-whole']"));
        List<WebElement> priceList = driver.findElements(By.className("a-price-whole")); //53
        List<String> getText = getAllText(priceList);
        int count = 0;
        for (String each : getText) {
                if (Integer.parseInt(each) < 25)
                    System.out.println("Price: "+each);
                count++;
        }
        System.out.println("Totaly "+ count +" Java books are less than 25");

        driver.quit();
    }
    @Test
    public static List<String> getAllText(  List<WebElement> elements){
        List<String> allText = new ArrayList<>();
        for (WebElement each: elements) {
                if (!each.getText().isEmpty())
                    allText.add(each.getText());
        }

       return allText;
    }

}
