package Framework1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonFunctions {
    public WebDriver driver;
    public CommonFunctions(WebDriver driver){
        this.driver=driver;
    }

    public void sendKeys(WebElement element, String data){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.sendKeys(data);
    }

    public void dropDown(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void acceptAlerts(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitAndClick(WebElement element){
        waitForElement(element);
        element.click();
    }
}