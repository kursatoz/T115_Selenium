package test_day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class FirstTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String testData = "Err";
        driver.get("https://testpages.herokuapp.com/calculate.php");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[name='number1']")).sendKeys("1");
        driver.findElement(By.cssSelector("input[name='number2']")).sendKeys("0");
        driver.findElement(By.cssSelector("select option[value='divide']")).click();
        driver.findElement(By.id("calculate")).click();
        Thread.sleep(1000);
       String answer =  driver.findElement(By.id("answer")).getText();
    //if (answer.equals(testData))
      if (Objects.equals(answer,testData))
        System.out.println("test is passed");
    else
        System.out.println("test is failed");
        Thread.sleep(1000);
        driver.close(); //close for window tap
        //driver.quit(); // close the browser

    }


}
