package DynamicXpath;

import DifferentSendkeys.SendKeys;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {
    public WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        DatePicker datePicker = new DatePicker();
        datePicker.launch();
        datePicker.selectDateBySelectClass("27", "January","1994");
        datePicker.selectDate("16","February","1998");
    }

    void launch() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/date-picker");
        Thread.sleep(2000);
    }

    void selectDateBySelectClass(String dayData, String monthData, String yearData) throws InterruptedException {
        driver.findElement(By.id("datePickerMonthYearInput")).click();
        WebElement month = driver.findElement(By.className("react-datepicker__month-select"));
        selectFromDropdown(month, monthData);
        Thread.sleep(2000);
        WebElement year = driver.findElement(By.className("react-datepicker__year-select"));
        selectFromDropdown(year, yearData);
        Thread.sleep(2000);
        WebElement day = driver.findElement(By.xpath("//div[contains(@class,'react-datepicker__day') and text()='"+dayData+"']"));
        day.click();
        Thread.sleep(2000);
        String selectedDate=driver.findElement(By.id("datePickerMonthYearInput")).getAttribute("value");
        System.out.println("Selected date : "+selectedDate);
        driver.quit();
    }
    void selectFromDropdown(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }
    void selectDate(String dayValue, String monthValue, String yearValue){
        driver.findElement(By.id("dateAndTimePickerInput")).click();
        WebElement month = driver.findElement(By.xpath("//div[@class='react-datepicker__month-read-view']"));
        month.click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__month-option' and text()='"+monthValue+"']")).click();
        WebElement year = driver.findElement(By.xpath("//div[@class='react-datepicker__year-read-view']"));
        year.click();
        driver.findElement(By.xpath("//div[@class='react-datepicker__year-option' and text()='"+yearValue+"']")).click();
        driver.findElement(By.xpath("//div[contains(@class='react-datepicker__day react-datepicker') and text()='"+dayValue+"']")).click();
    }
}
