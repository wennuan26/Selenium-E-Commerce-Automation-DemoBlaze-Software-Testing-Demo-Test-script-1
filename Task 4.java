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
