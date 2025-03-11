package online.demoorangehrm;

import online.demoorangehrm.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) {
        WebDriver driver = DriverManager.getInstance().getDriver();

        String currentTabName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java");
        driver.close();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().window(currentTabName);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
        System.out.println("The test is finished and the driver is closed");


    }
}