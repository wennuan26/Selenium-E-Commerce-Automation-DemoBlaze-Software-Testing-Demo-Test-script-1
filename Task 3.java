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
