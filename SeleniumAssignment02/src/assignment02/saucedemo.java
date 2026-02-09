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

    // ---------- TASK 1: OPEN WEBSITE ----------
    public static void openWebsite() {
        System.out.println("Executing Task 1: Opening Website...");
        driver.get("https://www.demoblaze.com/");
        
        String title = driver.getTitle();
        System.out.println("Website Title: " + title);
        
        // Verify the page loaded correctly
        Assert.assertTrue("Title should contain STORE", title.contains("STORE"));
    }

    // ---------- TASK 2: REGISTER NEW USER ----------
    public static void registerUser() {
        System.out.println("Executing Task 2: Registering New User...");
        driver.findElement(By.id("signin2")).click(); 
        
        // Wait for registration modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        
        // Generate a unique username using timestamp to prevent 'User already exists' errors
        currentUsername = "student_test_" + System.currentTimeMillis();
        driver.findElement(By.id("sign-username")).sendKeys(currentUsername);
        driver.findElement(By.id("sign-password")).sendKeys("Pass123!");
        
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        // Handle the JavaScript Alert pop-up
        wait.until(ExpectedConditions.alertIsPresent());
        String alertText = driver.switchTo().alert().getText();
        System.out.println("Registration Alert Text: " + alertText);
        driver.switchTo().alert().accept(); // Click 'OK'
        
        // Verification: Ensure the registration was successful
        Assert.assertTrue("Alert should confirm success", alertText.contains("successful"));
        
        // Wait for modal to disappear before moving to next task
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("signInModal")));
    }

    // ---------- TASK 3: LOGIN WITH CREATED USER ----------
    public static void loginUser() throws InterruptedException {
        System.out.println("Executing Task 3: Logging in...");
        
        // Small pause to ensure the UI has settled after the registration modal
        Thread.sleep(1000); 
        
        driver.findElement(By.id("login2")).click(); 
        
        // Wait for login modal
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        
        // Enter the credentials we created in Task 2
        driver.findElement(By.id("loginusername")).sendKeys(currentUsername);
        driver.findElement(By.id("loginpassword")).sendKeys("Pass123!");
        
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        // Verification: Check if "Welcome [username]" is displayed in the navigation bar
        WebElement welcomeMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        System.out.println("Login Status: " + welcomeMsg.getText());
        
        Assert.assertTrue("Welcome message should contain username", welcomeMsg.getText().contains(currentUsername));
    }

    // ---------- TASK 4: SEARCH AND SELECT PRODUCT ----------
    public static void searchProduct() {
        System.out.println("Executing Task 4: Selecting Product...");
        
        // Select 'Laptops' category
        driver.findElement(By.linkText("Laptops")).click();
        
        // Wait and click on a specific product (MacBook air)
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("MacBook air")));
        product.click();

        // Verification: Ensure we are on the product detail page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("name")));
        String productName = driver.findElement(By.className("name")).getText();
        System.out.println("Verified Product Page: " + productName);
        
        Assert.assertEquals("Product name mismatch", "MacBook air", productName);
    }

    // ---------- TASK 5: CLOSE BROWSER ----------
    public static void closeBrowser() {
        System.out.println("Executing Task 5: Closing Browser...");
        if (driver != null) {
            driver.quit();
            System.out.println("Test execution finished successfully.");
        }
    }
}