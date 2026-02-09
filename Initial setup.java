package assignment02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import java.time.Duration;

public class saucedemo {

    static WebDriver driver;
    static WebDriverWait wait;
    static String currentUsername; // Stores the user created in Task 2 to use in Task 3

    public static void main(String[] args) {
        try {
            setupBrowser();   // INITIAL SETUP
            openWebsite();    // TASK 1
            registerUser();   // TASK 2
            loginUser();      // TASK 3
            searchProduct();  // TASK 4
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeBrowser();   // TASK 5
        }
    }

    // ---------- INITIAL SETUP ----------
    public static void setupBrowser() {
        // Selenium Manager automatically handles the chromedriver executable
        driver = new ChromeDriver();
        // Explicit wait to handle dynamic elements and modals
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println("Browser setup completed.");
    }
