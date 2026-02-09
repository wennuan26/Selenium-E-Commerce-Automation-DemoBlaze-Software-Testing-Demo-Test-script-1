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
