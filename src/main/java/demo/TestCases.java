package demo;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        long epoch = System.currentTimeMillis() / 1000;
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        driver.get("https://forms.gle/wjPkzeSEk1CM7KgGA");
        WebElement inputName = driver.findElement(By.xpath("//div[@class='o3Dpx']/div[1]/div/div/div[2]//input"));
        inputName.sendKeys("Rinkal Gupta");
        WebElement inputReason = driver
                .findElement(By.xpath("//div[@class='o3Dpx']/div[2]//textarea"));
        inputReason.sendKeys("nuI want to be the best QA Engineer! " + epoch);
        WebElement checkboxLearnedJava = driver
                .findElement(By.xpath("//div[@class='o3Dpx']/div[4]//span[text()='Java']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", checkboxLearnedJava);
        WebElement radioTestingExp = driver.findElement(By.xpath("//div[@class='o3Dpx']/div[3]//span[text()='0 - 2']"));
        radioTestingExp.click();

        checkboxLearnedJava.click();
        WebElement checkboxLearnedSelenium = driver
                .findElement(By.xpath("//div[@class='o3Dpx']/div[4]//span[text()='Selenium']"));
        checkboxLearnedSelenium.click();
        WebElement checkboxLearnedTestng = driver
                .findElement(By.xpath("//div[@class='o3Dpx']/div[4]//span[text()='Java']"));
        checkboxLearnedTestng.click();
        WebElement submit = driver.findElement(By.xpath("//span[text()='Submit']"));
        js.executeScript("arguments[0].scrollIntoView();", submit);
        WebElement dropdown = driver.findElement(By.xpath("//div[@class='o3Dpx']/div[5]//span[text()='Choose']"));
        dropdown.click();
        Thread.sleep(2000);
        WebElement dropdownSelection = driver
                .findElement(By.xpath("//div[@class='o3Dpx']/div[5]//div[@jsname='V68bde']//span[text()='Mrs']"));
        dropdownSelection.click();
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,-7);
        String date = dateFormat.format(cal.getTime());
        Thread.sleep(1000);
        WebElement dateElement = driver.findElement(By.xpath("//div[@class='o3Dpx']/div[6]//input[@type='date']"));
        dateElement.sendKeys(date);
        Thread.sleep(2000);
        WebElement currentHours = driver.findElement(By.xpath("//input[@aria-label='Hour']"));
        WebElement currentMinutes = driver.findElement(By.xpath("//input[@aria-label='Minute']"));

        var time = new Date();
        currentHours.sendKeys(String.valueOf(time.getHours()));
        currentMinutes.sendKeys(String.valueOf(time.getMinutes()));
        Thread.sleep(2000);
        submit.click();
        System.out.println("end Test case: testCase01");
    }

}
