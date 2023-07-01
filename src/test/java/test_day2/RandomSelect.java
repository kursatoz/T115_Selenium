package test_day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class RandomSelect {
    static WebDriver driver = new ChromeDriver();
    /**
     * /**
     *  * 1.go to http://samples.gwtproject.org/samples/Showcase/Showcase.html
     *  Randomly select a checkbox.
     *  * As soon as you check any day, print the name of the day and uncheck immediately.
     *  * After you check and uncheck Friday for the third time, exit the program.
     *  */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        Thread.sleep(2000);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='checkbox']/following-sibling::label"));

        int counter = 0;
        while(counter < 3){
            Random random = new Random();
            int checkboxSelectedSize = random.nextInt(checkboxes.size()); // random size will be max 7
            if (checkboxes.get(checkboxSelectedSize).isEnabled()){
                checkboxes.get(checkboxSelectedSize).click();
                System.out.println("Day Label: "+labels.get(checkboxSelectedSize).getText());
                checkboxes.get(checkboxSelectedSize).click();
            }
            if (labels.get(checkboxSelectedSize).getText().equals("Friday")){
                counter++;

            }

        }
            driver.quit();




    }


}
